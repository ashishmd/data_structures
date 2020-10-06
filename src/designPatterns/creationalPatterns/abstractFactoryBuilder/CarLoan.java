package designPatterns.creationalPatterns.abstractFactoryBuilder;

import utils.CommonUtils;

public class CarLoan extends Loan {
  @Override
  void getLoanDetails() {
    CommonUtils.println("This is a car loan");
  }
}
