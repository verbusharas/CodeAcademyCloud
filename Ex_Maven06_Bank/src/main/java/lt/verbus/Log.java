package lt.verbus;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {

    private static final Logger LOG = LogManager.getLogger(AppMaven06.class);

    public static Logger getLogger() {
        return LOG;
    }
}
