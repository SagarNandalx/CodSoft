import java.util.Scanner;
public class ATMInterface {

    public static void main(String[] args) {
        double initialBalance = 1000;

        ATM atm = new ATM(initialBalance);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            atm.displayMenu();
            System.out.print("Enter your option: ");
            int option = scanner.nextInt();
            atm.processOption(option);
            System.out.println();
        }
    }    }

