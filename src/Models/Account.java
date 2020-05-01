package Models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Account {
    private static Scanner sc = new Scanner(System.in);
    private static int adminKey = 123;

    public Account() {

    }

    public void login() throws Exception {
        //login block
        //creates the scanner, file(if doesn't already exist), bufferedreader, filewriter, and filereader
        File loginDatabase = new File("src/loginDatabase");
        loginDatabase.createNewFile();
        FileWriter writer = new FileWriter(loginDatabase, true);
        FileReader file_reader = new FileReader(loginDatabase);
        BufferedReader br = new BufferedReader(file_reader);

        //asks for username
        System.out.println("Please enter login information: ");
        System.out.print("Username: ");
        String uName = sc.next();

        //checks database to see if username already exists in database
        int sCase = 0;
        String line = br.readLine();
        while (line != null) {
            if (line.contains(uName)) {
                sCase = 1;
                break;
            }
            line = br.readLine();
        }

        String password, privilege, updated;
        int key = 0;
        boolean valid = false;

        //prompts user to create a new account if non existent or simply enter password to continue
        switch (sCase) {
            case 0:
                System.out.println("Username not found!");
                System.out.println("Enter a password to create an account with username '" + uName + "'");
                System.out.print("Password: ");
                password = sc.next();

                // choose a privilege and must have the admin key to create an admin account.
                do {
                    System.out.print("Choose privilege (user or admin): ");
                    privilege = sc.next();

                    if (privilege.equalsIgnoreCase("admin"))
                    {
                        for (int i = 3; i >= 1; --i) // three tries
                        {
                            System.out.printf("Input the adminKey for approval (%d tries left): ", i);
                            key = sc.nextInt();
                            if (key == adminKey)
                                break;
                        }
                    } else if (privilege.equalsIgnoreCase("user"))
                    {
                        break;
                    }
                } while (key != adminKey);

                updated = uName + "," + password + "," + privilege;
                writer.write(updated + System.lineSeparator());
                writer.close();
                System.out.println("New account created!");
                break;

            case 1:
                while (valid != true) {
                    System.out.print("Password: ");
                    password = sc.next();
                    String[] temp = line.split(",");
                    if (temp[1].contains(password)) {
                        System.out.println("Access Granted");
                        valid = true;
                    } else {
                        System.out.println("Incorrect password, try again");
                    }
                }
        }
        br.close();
        //login block ends
    }
}