package com.mabel.condition;

import org.springframework.context.annotation.Conditional;

@Conditional(MabelCondition.class)
public @interface MabelConditionAnnotation {
}
