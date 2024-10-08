package com.thetestingacademy.Utils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader {

    public static  String readkey(String key)
    {
        Properties properties=new Properties();

        // Read the data.properties and give the key -> value

        try{
            FileInputStream file = new FileInputStream("src/test/java/com/thetestingacademy/Resources/data/data.properties");
            properties.load(file);

        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return properties.getProperty(key);

    }
}
