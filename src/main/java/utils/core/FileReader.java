package utils.core;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileReader {

    public Properties getPropertiesValues(String filePath) {
        Properties getPropertiesValues = null;
        FileInputStream file = null;
        try {
            getPropertiesValues = new Properties();
            getPropertiesValues.load(new FileInputStream(filePath));
        } catch (Exception e) {

        } finally {
            if (file != null) {
                try {
                    file.close();
                } catch (IOException e) {
                    System.out.println("Exception thrown  :" + e.getMessage());
                }
            }
        }
        return getPropertiesValues;
    }
}
