package designPatterns.creationalPatterns.abstractFactoryBuilder;

import utils.CommonUtils;

public class ICIC implements Bank {
  @Override
  public void getBankDetails() {
    CommonUtils.println("Name: ICIC");
    CommonUtils.println("Address: 456");
  }
}
