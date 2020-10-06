package designPatterns.creationalPatterns.abstractFactoryBuilder;

public abstract class BankingSystemFactory {

  public static BankingSystem getFactory(String type) {
    if (type.equals("Bank")) {
      return new BankFactory();
    }
    return new LoanFactory();
  }

}
