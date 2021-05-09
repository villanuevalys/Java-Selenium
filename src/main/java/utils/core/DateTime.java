package utils.core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTime
{

    public static String getDateTime(){
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm-ss");
        return localDateTime.format(formatter);
    }
}
