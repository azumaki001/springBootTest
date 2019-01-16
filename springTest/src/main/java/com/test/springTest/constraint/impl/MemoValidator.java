package com.test.springTest.constraint.impl;

import java.util.HashSet;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.test.springTest.constraint.Memo;

public class MemoValidator implements ConstraintValidator<Memo, String> {
	@Override
    public void initialize(Memo arg0) {
    }

    @Override
    public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
        HashSet<String> memoSet = new HashSet<String>();
        memoSet.add("圈养");
        memoSet.add("散养");
        return memoSet.contains(arg0);
    }
}
