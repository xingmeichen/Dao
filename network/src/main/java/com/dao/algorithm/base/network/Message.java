package com.dao.algorithm.base.network;

import lombok.Data;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Date;
import java.util.zip.CRC32;

/**
 * @project:
 * @description: 订一空一个消息类
 * @author: Mabel.Chen
 * @create: 2020/3/25
 **/
@Data
public class Message implements Serializable {

    private CRC32 crc;
    private short versionId;
    private Date createTime;
    private String key;
    private String value;
    private ByteBuffer byteBuffer;
}
