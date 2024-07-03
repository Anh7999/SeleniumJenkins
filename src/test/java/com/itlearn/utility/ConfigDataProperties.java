package com.itlearn.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProperties {

    Properties prop;

    public ConfigDataProperties() {
        try {
            File f = new File("./Configuration/config.properties");
            FileInputStream fis = new FileInputStream(f);
            prop = new Properties();
            prop.load(fis);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Can not read properties file");
        }
    }

    public String getBrowserName() {
        return prop.getProperty("browser");
    }

    public String getURL() {
        return prop.getProperty("url");
    }


    public static String getProperty(String key) {
        Properties properties = new Properties();
        String value = null;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("CONFIG_PATH_PROPERTIES");
            properties.load(fileInputStream);
            value = properties.getProperty(key);
            return value;

        } catch (Exception ex) {
            // TODO: handle exception
            System.out.println("Xảy ra lỗi khi đọc giá trị của  " + key);
            ex.printStackTrace();

        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return value;

    }
}
