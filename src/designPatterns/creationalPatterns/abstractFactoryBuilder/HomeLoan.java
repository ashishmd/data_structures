package designPatterns.creationalPatterns.abstractFactoryBuilder;

import utils.CommonUtils;

public class HomeLoan extends Loan {
  @Override
  void getLoanDetails() {
    CommonUtils.println("This is a home loan");
  }
}
