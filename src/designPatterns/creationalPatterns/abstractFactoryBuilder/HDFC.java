package designPatterns.creationalPatterns.abstractFactoryBuilder;

import utils.CommonUtils;

public class HDFC implements Bank {
  @Override
  public void getBankDetails() {
    CommonUtils.println("Name: HDFC");
    CommonUtils.println("Address: 1234");
  }

  public void getExtraDetails() {
    CommonUtils.println("These are the extra details");
  }
}
