package com.demo.util;


import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;
import java.util.Set;

/**
 * 读取properties文件工具类
 *
 * @author admin
 */
public class ReadPropUtil {
	

    private static Properties properties;

    public static final Logger log = Logger.getLogger(ReadPropUtil.class);

    public static String getReqAddress(String key) throws IOException {
        if (properties == null) {
            String[] profiles = SpringContextUtils.getApplicationContext().getEnvironment().getActiveProfiles();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(Thread.currentThread().getContextClassLoader().getResource("").getPath());
            stringBuilder.append("/config/").append(profiles[0]);
            stringBuilder.append("/requestAddress.properties");

            properties = new Properties();
            try {
                properties.load(new FileInputStream(new File(new String(stringBuilder))));
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }

        // 返回获取的值
        return properties.getProperty(key);
    }

    /**
     * 根据key获取消息配置文件中的配置内容
     *
     * @param key
     * @return
     */
    public static String getMessageConfig(String key) {
        Properties properties = new Properties();

        InputStream propertyInputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("/config/message.properties");

        try {
            properties.load(propertyInputStream);

            return properties.getProperty(key);
        } catch (IOException e) {
            log.error("根据" + key + "获取配置文件内容失败：", e);
        }

        return null;
    }

    /**
     * 根据key获取消息配置文件中的配置内容
     *
     * @param key
     * @param arguments 参数
     * @return
     */
    public static String getMessageConfig(String key, Object... arguments) {
        Properties properties = new Properties();

        InputStream propertyInputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("config/message.properties");
        try {
            properties.load(propertyInputStream);

            String value = properties.getProperty(key);
            if (value != null) {
                return MessageFormat.format(value, arguments);
            }
        } catch (IOException e) {
            log.error("加载配置文件失败：", e);
        } catch (Exception e) {
            log.error("根据" + key + "获取配置文件内容失败：", e);
        }

        return null;
    }

    /**
     * 根据key获取微信配置文件中的配置内容
     *
     * @param key
     * @return
     */
    public static String getWechatRequestConfig(String key) {
        Properties properties = new Properties();

        InputStream propertyInputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("/config/wechat.properties");

        try {
            properties.load(propertyInputStream);

            return properties.getProperty(key);
        } catch (IOException e) {
            log.error("根据" + key + "获取配置文件内容失败：", e);
        }

        return null;
    }

    /**
     * 根据key获取微信配置文件中的配置内容
     *
     * @param key
     * @param arguments 参数
     * @return
     */
    public static String getWechatRequestConfig(String key, Object... arguments) {
        Properties properties = new Properties();

        InputStream propertyInputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("config/wechat.properties");
        try {
            properties.load(propertyInputStream);

            String value = properties.getProperty(key);
            if (value != null) {
                return MessageFormat.format(value, arguments);
            }
        } catch (IOException e) {
            log.error("加载配置文件失败：", e);
        } catch (Exception e) {
            log.error("根据" + key + "获取配置文件内容失败：", e);
        }

        return null;
    }

    /**
     * 根据key获取集群配置文件中的配置内容
     *
     * @return
     */
    public static Set<String> getClusterRequestConfig() {
        Properties properties = new Properties();
        String[] profiles = SpringContextUtils.getApplicationContext().getEnvironment().getActiveProfiles();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Thread.currentThread().getContextClassLoader().getResource("").getPath());
        stringBuilder.append("/config/").append(profiles[0]);
        stringBuilder.append("/clusterConfig.properties");
        System.out.println(stringBuilder);
        System.out.println("-----------------------------------");
        try {
            properties.load(new FileInputStream(new File(new String(stringBuilder))));
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        // 返回获取的值
        return properties.stringPropertyNames();
    }


    public static String getClusterRequestValue(String key) throws IOException {
        Properties properties = new Properties();
        String[] profiles = SpringContextUtils.getApplicationContext().getEnvironment().getActiveProfiles();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Thread.currentThread().getContextClassLoader().getResource("").getPath());
        stringBuilder.append("/config/").append(profiles[0]);
        stringBuilder.append("/clusterConfig.properties");
        try {
            properties.load(new FileInputStream(new File(new String(stringBuilder))));
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        // 返回获取的值
        return properties.getProperty(key);
    }


    /**
     * 坐席即将到期提醒天数
     */
    public static final String MESSAGE_SIP_AGENT_REMIND_DAY = "sip.agent.remind.day";
    /**
     * 坐席过期后距离回收天数
     */
    public static final String MESSAGE_SIP_AGENT_OVERDUE_RECYCLE_DAY = "sip.agent.overdue.recycle.day";
    /**
     * 账户余额不足阈值
     */
    public static final String MESSAGE_BALANCE_REMIND = "balance.remind";
}
