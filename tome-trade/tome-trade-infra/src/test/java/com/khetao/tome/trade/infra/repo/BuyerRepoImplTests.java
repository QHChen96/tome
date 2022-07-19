package com.khetao.tome.trade.infra.repo;

import com.khetao.tome.dto.SingleResponse;
import com.khetao.tome.member.dto.MemberDTO;
import com.khetao.tome.member.facade.MemberClientFacade;
import com.khetao.tome.tdd.TomeTddContainer;
import com.khetao.tome.trade.domain.model.Buyer;
import com.khetao.tome.trade.domain.repo.BuyerRepo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * @author chenqinhao 2022/7/16
 * @email qhchen96@gmail.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TomeTddContainer.class)
public class BuyerRepoImplTests {

    @Configuration
    static class Config {

        /**
         * mock 远程类
         * @return
         */
        @Bean
        public MemberClientFacade memberClientFacade() {
            MemberClientFacade mockMemberClient = mock(MemberClientFacade.class);
            MemberDTO memberDTO = new MemberDTO();
            memberDTO.setMemberId(1L);
            memberDTO.setMemberName("tome");
            when(mockMemberClient.getMember(any())).thenReturn(SingleResponse.success(memberDTO));
            return mockMemberClient;
        }
    }

    @Inject
    private BuyerRepo buyerRepo;


    @Test
    public void testGetBuyer() {
        Long memberId = 1L;
        Buyer buyer = buyerRepo.getBuyer(memberId);
        verify(buyerRepo).getBuyer(memberId);
        Assert.assertNotNull(buyer);
    }


}
