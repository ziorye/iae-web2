package day0905;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedMessages {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(ParameterizedMessages.class);

        Object entry = new Object();

        logger.debug("The new entry is " + entry + ".");
        logger.debug("The new entry is {}.", entry);
    }
}
