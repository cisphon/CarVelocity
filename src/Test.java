import Models.*;

public class Test {
    public static void main(String[] args) throws Exception {
        Account account = new Account();
        account.login();

        VelocityCalculator vCalc = new VelocityCalculator();
        vCalc.calculate();

        News news = new News();
        news.printNews();
    }
}

