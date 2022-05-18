package com.mabel.stream;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * @project:
 * @description: 读写文件示例，// TODO 待补充
 * @author: Mabel.Chen
 * @create: 2020/3/17
 **/
public class FileUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileUtil.class);

    /**
     * 字节流写文件
     * */
    public static void writeFile() {
        // 定义文件路径
        String dir = "tmp";
        File directory = new File(dir);
        // 创建目录, 多层目录用 mkdirs(), 单层目录用 mkdir(),
        directory.mkdirs();
        FileOutputStream fileOutputStream = null;
        String absolutePath = directory.getAbsolutePath();
        try {
            fileOutputStream = new FileOutputStream(new File(absolutePath + "/a.txt"));
            int i = 1;
            while (i <= 5) {
                String content = "第" + i + "行：这是简单的一个文件内容\n";
                fileOutputStream.write(content.getBytes());
                i++;
            }
        } catch (Exception e) {
            LOGGER.error("open file output stream error", e);
        } finally {
            IOUtils.closeQuietly(fileOutputStream);
        }
    }

    /**
     * 字节流读文件，不用考虑编码问题，没有缓冲区
     */
    public static void readFile(String filePath) {
        File file = new File(filePath);
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            int read = fileInputStream.read();
            System.out.println(read);
        } catch (Exception e) {
            LOGGER.error("open file input stream error", e);
        } finally {
            IOUtils.closeQuietly();
        }
    }


    /**
     * 字符流读文件，需要考虑编码问题，存在缓冲区
     * */
    public static void readFileByReader(String filePath) {
        File file = new File(filePath);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String line = null;
            while (null != (line = reader.readLine())) {
                System.out.println(line);
            }
        } catch (Exception e) {
            LOGGER.error("open file reader error", e);
            throw new RuntimeException(e.getMessage());
        } finally {
            IOUtils.closeQuietly(reader);
        }
    }

    public static void main(String[] args) {
        writeFile();
        readFileByReader(System.getProperty("user.dir") + "/tmp/a.txt");
    }
}
