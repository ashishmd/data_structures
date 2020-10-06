package designPatterns.creationalPatterns.factoryBuilder;

public class MainApplication {
  public static void main(String[] args) {
    OSBuilder builder = new OSBuilder();
    OS os = builder.getOS("Windows");
    os.name();
    os = builder.getOS("Mac");
    os.name();
  }
}
