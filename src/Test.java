import Models.*;

import java.util.Scanner;

public class Test {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        Account account = new Account();
        account.login();

        int choice = account.choice();
        if (choice == 1) // load old data
        {
            ; //
        }
        else if (choice == 2) // calc new data
        {
            VelocityCalculator vCalc = new VelocityCalculator();

            ReportBuilder reportBuilder = new ReportBuilder(vCalc.calculate());
        }

        News news = new News();
        news.printNews();
    }
}