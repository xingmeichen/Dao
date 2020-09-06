package com.mabel.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.MultiValueMap;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @project: JavaLearning
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