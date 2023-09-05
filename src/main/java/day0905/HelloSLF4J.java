package day0905;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloSLF4J {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(HelloSLF4J.class);
        logger.info("Hello SLF4J");
    }
}
