pipeline {
    agent {
        node {
            label 'maven'
        }
    }
    stages {
        stage('拉取代码') {
            agent none
            steps {
                container('base') {
                    git(url: 'https://github.com/QHChen96/tome.git', credentialsId: '$GITHUB_CREDENTIAL_ID', branch: 'release', changelog: true, poll: false)
                    sh 'ls -al'
                }
            }
        }

        stage('单元测试') {
            steps {
                container('maven') {
                    sh 'mvn clean -gs `pwd`/configuration/settings.xml test'
                }
            }
        }

        stage('项目编译') {
            agent none
            steps {
                container('maven') {
                    sh 'mvn clean package -Dmaven.test.skip=true'
                    archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
                }
            }
        }

        stage('镜像构建') {
            parallel {
                stage('构建tome-gateway镜像') {
                    agent none
                    steps {
                        container('maven') {
                            sh 'ls tome-gateway/target'
                            sh 'docker build -t tome-gateway:latest -f tome-gateway/Dockerfile ./tome-gateway/'
                        }
                    }
                }
            }
        }

        stage('推送镜像') {
            when {
                branch 'release'
            }
            parallel {
                stage('推送tome-gateway镜像') {
                    steps {
                        container('maven') {
                            sh 'docker tag $REGISTER/$DOCKERHUB_NAMESPACE/tome-gateway:SNAPSHOT-$BRANCH_NAME-$BUILD_NUMBER $REGISTER/$DOCKERHUB_NAMESPACE/tome-gateway:latest'
                            withCredentials([usernamePassword(credentialsId: '$DOCKER_CREDENTIAL_ID', usernameVariable: '$DOCKER_CREDENTIAL_USERNAME', passwordVariable: '$DOCKER_CREDENTIAL_PASSWORD')]) {
                                sh 'docker login --username=$$DOCKER_CREDENTIAL_USERNAME $REGISTRY'
                                sh 'docker tag $REGISTER/$DOCKERHUB_NAMESPACE/tome-gateway:SNAPSHOT-$BRANCH_NAME-$BUILD_NUMBER $REGISTER/$DOCKERHUB_NAMESPACE/tome-gateway:latest'
                                sh 'echo "$DOCKER_CREDENTIAL_PASSWORD" | docker login $REGISTRY -u "$DOCKER_CREDENTIAL_USERNAME" --password-stdin'
                                sh 'docker push $REGISTER/$DOCKERHUB_NAMESPACE/tome-gateway:SNAPSHOT-$BRANCH_NAME-$BUILD_NUMBER'
                            }
                        }
                    }
                }
            }
        }
        stage('发布到dev环境') {
            steps {
                input(id: 'deploy-to-production', message: '是否要发布生产环境？')
                kubernetesDeploy(configs: 'tome-gateway/deploy/**', enableConfigSubstitutions, kubeconfigId: '$KUBECONFIG_CREDENTIAL_ID')
            }
        }
        stage('发布到prod环境') {
            parallel {
                 stage('deploy to production') {
                    agent none
                    steps {
                        input(id: 'deploy-to-production', message: '是否要发布生产环境？')
                        kubernetesDeploy(configs: 'tome-gateway/deploy/**', enableConfigSubstitutions, kubeconfigId: '$KUBECONFIG_CREDENTIAL_ID')
                    }
                 }
            }
        }

        stage('发送邮件') {
            agent none
            steps {
                mail(to: 'qhchen96@gmail.com', subject: '构建结果', body: "构建成功了 $BUILD_NUMBER")
            }
        }
    }
    environment {
        DOCKER_CREDENTIAL_ID = 'dockerhub-id'
//         DOCKER_CREDENTIAL_USERNAME_ID = 'dockerhub_credential_username_id'
//         DOCKER_CREDENTIAL_PASSWORD_ID = 'dockerhub_credential_password_id'
        GITHUB_CREDENTIAL_ID = 'github-id'
        KUBECONFIG_CREDENTIAL_ID = 'demo-kubeconfig'
        REGISTRY = 'docker.io'
        DOCKERHUB_NAMESPACE = 'khetao'
        GITHUB_ACCOUNT = 'khetao'
    }
    parameters {
        string(name: 'TAG_NAME', defaultValue: '', description: '')
    }
}