package core_java;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 关于日志logger，这是一个程序员的基本素养。
 */
public class LoggingTest {
    public static void main(String[] args) {
        Logger logger =Logger.getLogger("core_java.LoggingTest");
        /*
        ConsoleHandler consoleHandler =new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        // Handler可以选择将日志文件输出到哪里，比如console,file等
        logger.addHandler(consoleHandler);
        */
        // Level控制默认显示什么。ALL全部显示，低于此级别将不显示。
        logger.setLevel(Level.ALL);
        logger.info("I am good");
        logger.info("dfd");
        logger.warning("there is fault");
        System.out.println(logger.getName());
    }
}




