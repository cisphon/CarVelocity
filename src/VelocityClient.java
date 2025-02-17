import Models.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VelocityClient {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        Account account = new Account();
        account.login();

        int choice = account.choice();
        if (choice == 1 && account.accountType == AccountType.ADMIN) // load old data
        {
            try (Stream<Path> walk = Files.walk(Paths.get("reports"))) {

                // walks through the directory "reports"
                List<String> result = walk.filter(Files::isRegularFile)
                        .map(x -> x.toString()).collect(Collectors.toList());


                int i, fileChoice = 0;
                do {
                    System.out.println("Pick a file: ");

                    // displays all the files in "reports"
                    i = 1;
                    for (String path : result) {
                        System.out.println(i++ + ". " + path);
                    }
                    System.out.println(i + ". exit");
                    fileChoice = sc.nextInt();

                    // if it's not the exit choice
                    if (fileChoice != i)
                    {
                        // returns the file indexed from the result variable.
                        String file = result.get(fileChoice - 1);
                        // reads the chosen file
                        BufferedReader br = new BufferedReader(new FileReader(file));

                        // displays the content of the chosen file
                        System.out.println("~~~~~~~~");
                        String line;
                        while ((line = br.readLine()) != null)
                        {
                            System.out.println(line);
                        }
                        System.out.println("~~~~~~~~");
                    }
                } while (fileChoice != i);


            } catch (IOException e) {
                // directory doesn't exist, make it.
                boolean mkdirs = new File("reports/").mkdirs();
            }
        } else if (choice == 2) // calc new data
        {
            VelocityCalculator vCalc = new VelocityCalculator();

            ReportBuilder reportBuilder = new ReportBuilder(vCalc.calculate(), account.currentUser());
        }

        News news = new News();
        news.printNews();
    }
}