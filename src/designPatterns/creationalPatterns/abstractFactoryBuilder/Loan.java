package designPatterns.creationalPatterns.abstractFactoryBuilder;

public abstract class Loan {
  int rate;

  public void setRate(int r) {
    rate = r;
  }

  abstract void getLoanDetails();

  public int calculateInterest() {
    return rate*2;
  }
}
