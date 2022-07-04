package com.khetao.tome.toolkit.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author chenqinhao 2022/7/3
 * @email qhchen96@gmail.com
 */
@Documented
@Constraint(validatedBy = PhoneNumberValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface PhoneNumber {
    String message() default "非法手机号";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
