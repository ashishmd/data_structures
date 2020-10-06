package designPatterns.creationalPatterns.factoryBuilder;

public class OSBuilder {
  public OS getOS(String name) {
    if (name.equals("Windows")) {
      return new Windows();
    } else {
      return new MacOS();
    }
  }
}
