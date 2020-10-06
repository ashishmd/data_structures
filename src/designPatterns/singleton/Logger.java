package designPatterns.singleton;

public class Logger {
  private static Logger loggerInstance = new Logger();
  int data;
  private Logger() {}

  public static Logger getLoggerInstance() {
    return loggerInstance;
  }

  public void setData(int data) {
    this.data = data;
  }
}
