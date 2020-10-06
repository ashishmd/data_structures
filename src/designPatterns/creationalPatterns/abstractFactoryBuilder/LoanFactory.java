package designPatterns.creationalPatterns.abstractFactoryBuilder;

public class LoanFactory extends BankingSystem {
  public Loan getLoan(String type) {
    if(type.equals("car")) {
      return new CarLoan();
    }
    return new HomeLoan();
  }
}
