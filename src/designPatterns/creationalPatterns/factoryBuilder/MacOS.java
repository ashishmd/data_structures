package designPatterns.creationalPatterns.factoryBuilder;

import utils.CommonUtils;

public class MacOS implements OS {
  @Override
  public void name() {
    CommonUtils.println("This is MacOS");
  }
}
