package designPatterns.singleton;

import static utils.CommonUtils.print;
import static utils.CommonUtils.println;

public class MainApplication {
  public static void main(String[] args) {

    println("This is the implementation of load time instantiated class");
    Logger loggerInstance = Logger.getLoggerInstance();
    loggerInstance.setData(10);

    println("This is the logger data: " + loggerInstance.data);

    loggerInstance = Logger.getLoggerInstance();
    println("This is the logger data: " + loggerInstance.data);

    println("\n\nThis is the implementation of lazy loaded instantiated class");

    LazyLogger logger = LazyLogger.getLoggerInstance();
    logger.setData(10);

    println("This is the lazy load of logger implementation: Value is : " + logger.data);

    logger = LazyLogger.getLoggerInstance();
    println("This is the lazy load of logger implementation: Value is : " + logger.data);
  }
}
