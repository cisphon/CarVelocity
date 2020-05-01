import Models.*;

import java.util.Scanner;

public class Test {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        Account account = new Account();
        account.login();
        account.choice();

        News news = new News();
        news.printNews();
    }
}