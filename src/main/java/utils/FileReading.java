package utils;

import java.io.*;
import java.nio.file.Paths;
import java.util.Properties;

public class FileReading {
    public static String GlobalPath = Paths.get("").toAbsolutePath().toString() +
            File.separator + "src"+ File.separator+ "main" + "" +
            File.separator + "java" + File.separator + "config" + File.separator;

    private String fileName;

    public String getField(String fieldName) {
        try {
            InputStream input = new FileInputStream(GlobalPath+""+this.fileName);
            Properties prop = new Properties();
            prop.load(input);
            return prop.getProperty(fieldName);
        }catch (FileNotFoundException e){
            return null;
        } catch (IOException e) {
            return null;
        }
    }

    public void setFileName(String fileName){
        this.fileName = fileName;
    }
}
