package day0905;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetLogger {
    private static final Logger log = LoggerFactory.getLogger(GetLogger.class);

    public static void main(String[] args) {
        log.debug("private static final Logger log = ...");
    }
}
