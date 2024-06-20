package com.dao.designpattern.decoration;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @project:
 * @description:
 * 装饰者模式示例 FilterInputStream 是一个装饰类，它装饰了InputStream这个抽象组件
 * LowerCaseInputStream 去扩展了 FilterInputStream 这个装饰类
 *
 * 装饰者模式的特点是：
 * （1）遵循开放-关闭原则，即对扩展开放对修改关闭
 * （2）装饰者模式利用了
 * @author: Mabel.Chen
 * @create: 2020/3/31
 **/
public class LowerCaseInputStream extends FilterInputStream {

    public LowerCaseInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int read = super.read();
        return (-1 == read ? read : Character.toLowerCase((char) read));
    }
}
