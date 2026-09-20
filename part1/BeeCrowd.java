import java.util.Scanner;

public class BeeCrowd {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // problem 2060 -------------------
        // int n = sc.nextInt();
        // int n1 = 0;
        // int n2 = 0;
        // int n3 = 0;
        // int n4 = 0;
        // for (int i = 0; i < n; i++) {
        //     int number = sc.nextInt();
        //     if (number % 2 == 0) {
        //         n1++;
        //     }
        //     if (number % 3 == 0) {
        //         n2++;
        //     }
        //     if (number % 4 == 0) {
        //         n3++;
        //     }
        //     if (number % 5 == 0) {
        //         n4++;
        //     }
        // }

        // System.out.println(n1 + " Multiplo(s) de 2");
        // System.out.println(n2 + " Multiplo(s) de 3");
        // System.out.println(n3 + " Multiplo(s) de 4");
        // System.out.println(n4 + " Multiplo(s) de 5");

        // problem 2126 -------------------
        int m = sc.nextInt();
        int d = sc.nextInt();

        int months[] = {31,29,31,30,31,30,31,31,30,31,30,31};
        int day = 0;

        int total = 0;
        for(int i=0; i<12; i++){
            total += months[i];
        }

        for(int i=0; i<m; i++){
            day += months[i];
        }

        day += d;
        System.out.println("days" + (total- d));

        sc.close();
    }
}
