public class ConstructorChaining {
    public static void main(String[] args) {
        Facebook user1 = new Facebook();
        user1.createAccount("muhammad_khairul", "Muhammad", "Khairul", "12-02-2025", "12345678");
        System.out.println("--------------------------");

        System.out.println();
        user1.GetUserInformation();
        System.out.println();
        System.out.println("--------------------------");

        Facebook user2 = new Facebook();
        user2.createAccount("muhammad_imran", "Muhammad", "imran", "12-02-2008", "12345678");
        System.out.println();
        user2.GetUserInformation();
        System.out.println();
        System.out.println("--------------------------");

        Facebook user3 = new Facebook();
        user3.createAccount("muhammad_rakibul", "Muhammad", "rakibul", "22-06-2002", "12345678");
        System.out.println();
        user3.GetUserInformation();
        System.out.println();
        System.out.println("--------------------------");

        Facebook user4 = new Facebook();
        user4.createAccount("muhammad_Rabbi", "Muhammad", "Rabbi", "12-02-2026", "12345678");
        System.out.println();
        user4.GetUserInformation();
        System.out.println();
        System.out.println("--------------------------");

        Facebook user5 = new Facebook();
        user5.createAccount("muhammad_ali", "Muhammad", "ali", "12-02-2025", "12345678");
        System.out.println();
        user5.GetUserInformation();
        System.out.println();
        System.out.println("--------------------------");

        Facebook user6 = new Facebook();
        user6.createAccount("muhammad_kawsar", "Muhammad", "kawsar", "12-02-2025", "12345678");
        System.out.println();
        user6.GetUserInformation();
        System.out.println();
        System.out.println("--------------------------");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        Facebook meta = new Facebook();
        meta.metaData();
    }
}

class Facebook {
    static int userCount = 0;
    static int userId = 0;

    String username;
    String firstName;
    String lastName;
    String dateOfBirth;
    String password;

    public void createAccount(String username, String firstName, String lastName, String dateOfBirth, String password) {

        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.password = password;
        userId++;
        userCount++;
    }

    public void GetUserInformation() {
        System.out.println("serial number: K234K2L213" + userId);
        System.out.println("username: " + this.username);
        System.out.println("full name: " + firstName + " " + lastName);
        System.out.println("Date of birth: " + this.dateOfBirth);
    }

    public void metaData() {
        System.out.println("---Facebook Meta Data---");
        System.out.println("Total Account Create: " + userCount);
    }
}

class A {
    A() {
        System.out.println("A");
    }
}

class B extends A {
    B() {
        this(1);
        System.out.println("1st constructor: B");
    }

    B(int a) {
        this(2, 3);
        System.out.println("2nd constructor: A: " + a);
    }

    B(int a, int b) {
        super();
        System.out.println("3rd constructor: A: " + a + " , B: " + b);
    }
}
