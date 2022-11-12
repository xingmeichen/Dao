package com.dao.resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StreamUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * @project:
 * @description: 注入 {@link javax.annotation.Resource} 对象
 * @author: Mabel.Chen
 * @create: 2020/6/13
 *
 * @see org.springframework.context.annotation.AnnotationConfigApplicationContext
 * @see org.springframework.core.io.Resource
 * @see org.springframework.beans.factory.annotation.Value
 **/
public class InjectingResource {

    @Value("classpath:/META-INF/default.properties")
    private Resource defaultPropertiesResource;

    @Value("classpath:/META-INF/production.properties")
    private Resource productionPropertiesResource;

    @PostConstruct
    public void init() throws IOException {
        URI uri = defaultPropertiesResource.getURI();
        File file = ResourceUtils.getFile(defaultPropertiesResource.getURI());
        System.out.println(file);
    }

    public static void main(String[] args) throws IOException {
        URL url = new URL("classpath:/META-INF/default.properties");
        InputStream inputStream = url.openStream();
        System.out.println(StreamUtils.copyToString(inputStream, Charset.forName("UTF-8")));
    }
}
