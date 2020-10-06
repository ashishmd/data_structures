package designPatterns.creationalPatterns.singleton;

public class LazyLogger {
  private static LazyLogger loggerInstance;
  int data;

  private LazyLogger() {}

  public static LazyLogger getLoggerInstance() {
    if(loggerInstance == null) {
      synchronized (LazyLogger.class) {
        if(loggerInstance == null) {
          loggerInstance = new LazyLogger();
        }
      }
    }
    return loggerInstance;
  }

  public void setData(int data) {
    this.data = data;
  }
}
