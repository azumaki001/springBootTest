package com.test.springTest.constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.test.springTest.constraint.impl.MemoValidator;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.METHOD })
@Constraint(validatedBy=MemoValidator.class)
public @interface Memo {

	String message() default "请输入正确的备注";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
