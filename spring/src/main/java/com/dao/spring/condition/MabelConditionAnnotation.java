package com.dao.spring.condition;

import org.springframework.context.annotation.Conditional;

@Conditional(MabelCondition.class)
public @interface MabelConditionAnnotation {
}
