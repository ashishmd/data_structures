package designPatterns.creationalPatterns.abstractFactoryBuilder;

import utils.CommonUtils;

public class MainBankApplication {
  public static void main(String[] args) {
    Bank bank = BankingSystemFactory.getFactory("Bank").getBank("HDFC");
    bank.getBankDetails();

    // get hdfc specific details
    BankFactory bf = (BankFactory) BankingSystemFactory.getFactory("Bank");
    ((HDFC)bf.getBank("HDFC")).getExtraDetails();

    Loan loan = BankingSystemFactory.getFactory("Loan").getLoan("car");
    loan.getLoanDetails();
    loan.setRate(2);
    CommonUtils.println("Loan interest rate is: " + loan.calculateInterest());

  }
}
