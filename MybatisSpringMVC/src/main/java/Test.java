import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *@author linbingwen
 *@2015Äê5ÔÂ18ÈÕ9:14:21
 */
public class Test {
	public static void main(String[] args) {  
	    Logger logger = LogManager.getLogger("mylog");  
	    for(int i = 0; i < 50000; i++) {  
	        logger.trace("trace level");  
	        logger.debug("debug level");  
	        logger.info("info level");  
	        logger.warn("warn level");  
	        logger.error("error level");  
	        logger.fatal("fatal level");  
	    }  
	    try {  
	        Thread.sleep(1000 * 61);  
	    } catch (InterruptedException e) {}  
	    logger.trace("trace level");  
	    logger.debug("debug level");  
	    logger.info("info level");  
	    logger.warn("warn level");  
	    logger.error("error level");  
	    logger.fatal("fatal level");  
	}

}