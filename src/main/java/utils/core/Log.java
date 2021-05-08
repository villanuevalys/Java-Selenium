package utils.core;


import org.apache.log4j.Logger;

public class Log {

    private static Logger log = Logger.getLogger(Log.class.getName());
    
    public static void info (String message) {
        log.info(message);
    }

    public static void printLines(){
        log.info("*********************************************************************************************");
    }

    //Warn Level Logs
    public static void warn (String message) {
        log.warn(message);
    }

    //Error Level Logs
    public static void error (String message) {
        log.error(message);
    }

    //Fatal Level Logs
    public static void fatal (String message) {
        log.fatal(message);
    }

    //Debug Level Logs
    public static void debug (String message) {
        log.debug(message);
    }

}
