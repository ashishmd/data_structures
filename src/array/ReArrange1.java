package array;
import java.io.*;
public class ReArrange1 {
    public static void main(String[] args)
    {
        RandomPlan r = new RandomPlan();
        r.getRate();
    }

}
abstract class Plan{
    abstract void getRate();
    protected double rate;

    public void calculateBill(int units){
        System.out.println(units*rate);
    }
}

class  DomesticPlan extends Plan{
    public void getRate(){
        System.out.println("domestic plan");
    }
}

class CommercialPlan extends DomesticPlan {
    // @override

    public void getRate() {
        System.out.println("commercial plan");
    }

    public void test() {};
}

class RandomPlan extends CommercialPlan {
    // @override
    RandomPlan() {};
    public void getRate() {
        super.getRate();
        System.out.println("random plan");
    }

    public void test() {};
}

class InstitutionalPlan extends Plan {
    // @override
    public void getRate() {
        rate = 5.50;
    }

}