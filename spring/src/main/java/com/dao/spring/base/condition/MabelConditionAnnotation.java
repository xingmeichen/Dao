package com.dao.spring.base.condition;

import org.springframework.context.annotation.Conditional;

@Conditional(MabelCondition.class)
public @interface MabelConditionAnnotation {
}
