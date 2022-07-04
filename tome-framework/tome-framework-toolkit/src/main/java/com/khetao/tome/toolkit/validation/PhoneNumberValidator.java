package com.khetao.tome.toolkit.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author chenqinhao 2022/7/3
 * @email qhchen96@gmail.com
 */
public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null) {
            // 单一职责，这里的空值交给其他注解去处理
            return true;
        }
        return false;
    }
}
