package utils;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @project: JavaLearning
 * @description:
 * @author: Mabel.Chen
 * @create: 2021-10-12 16:37
 **/
public class ConfigurationUtil {

    public volatile static Properties properties;
    public static final String CONFIG_PATH = "config/config.properties";
    public static final String FORMATE_PATH = "config/config-%s.properties";
    public static final Map<String, Properties> CONFIG_MAP = new ConcurrentHashMap<>();

    public static Properties getConfig(String environment) {
        Properties properties = new Properties();
        InputStream input = null;
        String fileName = null;
        try {
            if (StringUtils.isBlank(environment)) {
                fileName = CONFIG_PATH;
            } else {
                fileName = String.format(FORMATE_PATH,environment);
            }
            input = ConfigurationUtil.class.getClassLoader()
                    .getResourceAsStream(fileName);
            if (null == input) {
                throw new RuntimeException(fileName + "not found");
            }
            properties.load(input);
            CONFIG_MAP.put(environment, properties);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return properties;
    }

    public static Properties getCommonConfig() {
        Properties config = getConfig("");
        return config;
    }

    public static String getChromeDriver() {
        Properties commonConfig = getCommonConfig();
        return commonConfig.getProperty("chrome_driver");
    }

    public static String getIEDriver() {
        Properties commonConfig = getCommonConfig();
        return commonConfig.getProperty("ie_driver");
    }

    public static String getEdgeDriver() {
        Properties commonConfig = getCommonConfig();
        return commonConfig.getProperty("edge_driver");
    }
}