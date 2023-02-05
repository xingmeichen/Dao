package com.dao.condition;

import org.springframework.context.annotation.*;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.CollectionUtils;
import org.springframework.util.MultiValueMap;

import java.util.Iterator;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2020-09-03 09:35
 **/
public class MabelCondition implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        MultiValueMap<String, Object> attributes = annotatedTypeMetadata.getAllAnnotationAttributes(Conditional.class.getName());
        if (CollectionUtils.isEmpty(attributes)) {
            return false;
        }
        Iterator<Object> iterator = attributes.get("value").iterator();
        if (iterator.hasNext()) {
            return true;
        }
        return false;
    }
}