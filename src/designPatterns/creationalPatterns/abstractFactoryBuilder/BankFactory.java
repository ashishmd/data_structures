package designPatterns.creationalPatterns.abstractFactoryBuilder;

public class BankFactory extends BankingSystem{
  public Bank getBank(String bankName) {
    if(bankName.equals("HDFC")) {
      return new HDFC();
    }
    return new ICIC();
  }
}
