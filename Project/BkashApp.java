package Project;

public class BkashApp {

    public static void main(String[] args) {
        // Bkash owner
        Bkash.bkashCompany(159753);
        System.out.println();

        Bkash user1 = new Bkash(1317098194, "Muhammad Khairul", 135496857, "12-02-2004", 1234);
        user1.showOwnerData(1234);
        user1.addMoney(500);
        user1.addMoney(1000);
        user1.showOwnerData(1234);

        Bkash user2 = new Bkash(1794307736, "Md. Nazmul Islam", 356987536, "14-07-1975", 654321);
        user2.showOwnerData(654321);
        user1.sendMoney(user2, 1794307736, 500, 1234);
        user2.showOwnerData(654321);

        user2.sendMoney(user1, 1317098194, 100, 654321);

        // Bkash owner
        System.out.println();
        Bkash.bkashCompany(159753);
        System.out.println();
        user1.showOwnerData(1234);
        user2.showOwnerData(654321);
    }
}

class Bkash {
    private static int totalBalance = 2000;
    private int accountNumber;
    private String fullName;
    private int nidNumber;
    private String dateOfBirth;
    private int balance;
    private int pinNumber;

    public static void bkashCompany(int securityKey) {
        if (securityKey == 159753) {
            System.out.println("---------Bkash Company----------");
            System.out.println("Total Balance: " + Bkash.totalBalance + "$");
        }
    }

    Bkash(int accountNumber, String fullName, int nidNumber, String dateOfBirth, int pinNumber) {
        this.accountNumber = accountNumber;
        this.fullName = fullName;
        this.nidNumber = nidNumber;
        this.dateOfBirth = dateOfBirth;
        this.balance = 0;
        this.pinNumber = pinNumber;
    }

    public void addMoney(int balance) {
        if (Bkash.totalBalance != 0 && Bkash.totalBalance >= balance) {
            this.balance += balance;
            Bkash.totalBalance -= balance;
            System.out.println(balance + "$ add money successful.");
            System.out.println("Total Balance: " + this.balance);
        }
    }

    public void cashOut(int balance) {
        if (this.balance >= balance) {
            this.balance -= balance;
            System.out.println(balance + "$ CashOut Successful.");
            System.out.println("New balance: " + this.balance);
        } else {
            System.out.println("Insuffition Balance");
        }
    }

    public void sendMoney(Bkash acc1, int accountNumber, int balance, int pinNumber) {
        if (acc1.accountNumber == accountNumber && this.balance >= balance && this.pinNumber == pinNumber) {
            acc1.balance += balance;
            this.balance -= balance;
            System.out.println("-" + balance + "$ to " + acc1.accountNumber + " " + " Send Money successful.");
            System.out.println("Your current balance: " + this.balance);
        } else {
            System.out.println("Trangaction Fail.\nInsuffition balance");
        }
    }

    public void showOwnerData(int pinNumber) {
        if (this.pinNumber == pinNumber) {
            System.out.println("---------------------------");
            System.out.println("Account Owner Information.");
            System.out.println("Account Number: " + this.accountNumber);
            System.out.println("Name: " + this.fullName);
            System.out.println("Balance: " + this.balance);
            System.out.println("---------------------------");
        } else {
            System.out.println("Wrong Password...");
        }
    }
}