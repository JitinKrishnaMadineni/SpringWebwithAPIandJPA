package com.Module2.Web.Annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PrimeNumberValidator implements ConstraintValidator<PrimeNumber, Integer> {
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context)
    {
        if(value == null)
        {
            return true;
        }
        if(value < 2)
        {
            return false;
        }
        for(int i=2; i<= Math.sqrt(value); i++)
        {
            if(value % i == 0)
            {
                return false;
            }
        }
        return true;
    }
}
