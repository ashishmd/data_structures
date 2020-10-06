package designPatterns.creationalPatterns.factoryBuilder;

import utils.CommonUtils;

public class Windows implements OS {
  @Override
  public void name() {
    CommonUtils.println("This is Windows OS");
  }
}
