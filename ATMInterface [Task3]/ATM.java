import java.util.Scanner;
class ATM {
    private double balance;
    public ATM(double initialBalance) {
        this.balance = initialBalance;
    }
    public void displayMenu() {
        System.out.println("ATM Menu");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Exit");
    }
    public void processOption(int option) {
        if(option==1)
        {
            checkBalance();
        }
        else if(option==2)
        {
            withdraw();
        }
        else if(option==3)
        {
            deposit();
        }
        else if(option==4)
        {
            System.out.println("Exiting...");
            System.exit(0);
        }
        else {
            System.out.println("Invalid option");
        }

    }
    private void checkBalance() {
        System.out.println("Current balance: $" + balance);
    }
    private void withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to withdraw: $");
        double amount = scanner.nextDouble();
        if (amount > balance) {
            System.out.println("Insufficient balance");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. Remaining balance: $" + balance);
        }
    }
    private void deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to deposit: $");
        double amount = scanner.nextDouble();
        balance += amount;
        System.out.println("Deposit successful. Current balance: $" + balance);
    }
}

