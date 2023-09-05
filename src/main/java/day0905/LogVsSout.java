package day0905;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogVsSout {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(LogVsSout.class);
        logger.info("log msg from logger");
        System.out.println("log msg from sout");
    }
}
