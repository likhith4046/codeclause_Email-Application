import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Calendar;

public class Main {
    public Main() {
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader I = new InputStreamReader(System.in);
        BufferedReader B = new BufferedReader(I);
        System.out.print("Enter function (signUp, login, compose): ");
        String ch = B.readLine();
        InputStreamReader reader;
        BufferedReader input;
        String User;
        String User1;
        if (ch.equals("signup")) {
            reader = new InputStreamReader(System.in);
            input = new BufferedReader(reader);
            System.out.print("Username@email.com: ");
            User = input.readLine();
            System.out.print("Password: ");
            User1 = input.readLine();
            System.out.println("New ID created successfully!");
            FileWriter fout = new FileWriter(User + "@email.com");
            BufferedWriter bout = new BufferedWriter(fout);
            PrintWriter pout = new PrintWriter(bout);
            pout.println(User1);
            FileWriter fot = new FileWriter(User);
            BufferedWriter bot = new BufferedWriter(fot);
            new PrintWriter(bot);
            pout.close();
            bout.close();
            pout.close();
        } else {
            String Composed;
            String Ask;
            if (ch.equals("login")) {
                reader = new InputStreamReader(System.in);
                input = new BufferedReader(reader);
                System.out.print("Username: ");
                User = input.readLine();
                System.out.print("Password: ");
                User1 = input.readLine();
                FileReader fout = new FileReader(User + "@email.com");
                BufferedReader bout = new BufferedReader(fout);
                String data = bout.readLine();
                if (User1.equals(data)) {
                    System.out.println("Logged On!");
                    System.out.print("Do you want to go to the inbox: (yes/no)");
                    Ask = input.readLine();
                    if (Ask.equals("yes")) {
                        FileReader f = new FileReader(User);
                        BufferedReader b = new BufferedReader(f);
                        System.out.println("");
                        int i = 0;

                        while((Composed = b.readLine()) != null) {
                            ++i;
                            System.out.println(Composed);
                        }

                        System.out.println("");
                        b.close();
                        bout.close();
                    }
                } else {
                    System.out.println("Wrong password!");
                }
            } else if (ch.equals("compose")) {
                reader = new InputStreamReader(System.in);
                input = new BufferedReader(reader);
                Calendar c = Calendar.getInstance();
                System.out.print("Username: ");
                User1 = input.readLine();
                System.out.print("Password: ");
                String Pass = input.readLine();
                FileReader fout = new FileReader(User1 + "@email.com");
                BufferedReader bout = new BufferedReader(fout);
                Ask = bout.readLine();
                if (Pass.equals(Ask)) {
                    System.out.println("Logged On!");
                    System.out.print("To:   ");
                    String Users = input.readLine();
                    System.out.print("From:   ");
                    String From = input.readLine();
                    System.out.println("");
                    System.out.println("Letter Content:");
                    Composed = input.readLine();
                    FileWriter fin = new FileWriter(Users);
                    BufferedWriter bin = new BufferedWriter(fin);
                    PrintWriter pin = new PrintWriter(bin);
                    System.out.println("");
                    int var10001 = c.get(10);
                    pin.println("Time:" + var10001 + ":" + c.get(12) + " PM");
                    pin.println("From " + From + ",");
                    pin.println(Composed);
                    System.out.println("");
                    System.out.println("Mail sent!");
                    bout.close();
                    pin.close();
                    bin.close();
                    pin.close();
                } else {
                    System.out.println("Wrong password!");
                }
            } else {
                System.out.println("Wrong choice!");
            }
        }

    }
}

