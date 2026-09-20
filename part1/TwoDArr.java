import java.util.Scanner;

public class TwoDArr {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // int numbers[][] = new int[3][3]; // total element = 3*3 = 9
        // System.out.println("input total (3x3) number");
        // for (int i = 0; i < numbers.length; i++) {
        // for (int j = 0; j < numbers[0].length; j++) {
        // numbers[i][j] = sc.nextInt();
        // }
        // }

        // System.out.println("total element are: ");
        // for (int i = 0; i < numbers.length; i++) {
        // for (int j = 0; j < numbers[i].length; j++) {
        // System.out.print(numbers[i][j] + " ");
        // }
        // System.out.println();
        // }

        // int min = 0;
        // int max = 0;
        // System.out.println("found min or max number: ");

        // for (int i = 0; i < numbers.length; i++) {
        // for (int j = 0; j < numbers[0].length; j++) {
        // if (numbers[i][j] < min) {
        // min = numbers[i][j];
        // }

        // if (numbers[i][j] > max) {
        // max = numbers[i][j];
        // }
        // }
        // }

        // System.out.println("Minimum number: " + min);
        // System.out.println("Maximum number: " + max);

        // System.out.println("row = " + numbers.length);
        // System.out.println("column = " + numbers[0].length);

        // spiral matrix ----------------------------------------------------
        // int num[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14,
        // 15, 16 } };

        // int num[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        // int num[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        // for (int i = 0; i < num.length; i++) {
        // for (int j = 0; j < num[0].length; j++) {
        // System.out.print(num[i][j] + " ");
        // }
        // System.out.println();
        // }
        // System.out.println();

        // int startRow = 0;
        // int endRow = num.length - 1;
        // int startCol = 0;
        // int endCol = num[0].length - 1;

        // while (startRow <= endRow && startCol <= endCol) {
        // // left to right
        // for (int j = startCol; j < endCol; j++) {
        // System.out.print(num[startRow][j] + " ");
        // }

        // // top to bottom
        // for (int i = startRow; i < endRow; i++) {
        // System.out.print(num[i][endCol] + " ");
        // }

        // // right to left
        // for (int j = endCol; j >= startCol; j--) {
        // System.out.print(num[endRow][j] + " ");
        // }

        // // bottom to top
        // for (int i = endRow - 1; i >= startRow + 1; i--) {
        // System.out.print(num[i][startCol] + " ");
        // }
        // startRow++;
        // endRow--;
        // startCol++;
        // endCol--;
        // }

        // diogonal sum ---------------------------------------------------

        // int num[][] = {
        // { 1, 2, 3, 4 },
        // { 5, 6, 7, 8 },
        // { 9, 10, 11, 12 },
        // { 13, 14, 15, 16 } };

        // int num[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        // int sum = 0;

        // for (int i = 0; i < num.length; i++) {
        // for (int j = 0; j < num[0].length; j++) {
        // if (i == j) {
        // sum += num[i][j];
        // }
        // if (i + j == num.length - 1) {
        // sum += num[i][j];
        // }
        // }
        // }
        // System.out.println("Digonal sum: " + sum);

        // int sum2 = 0;
        // for (int i = 0; i < num.length; i++) {
        // sum2 += num[i][i];

        // if (i != num.length - i - 1) {
        // sum2 += num[i][num.length - i - 1];
        // }
        // }
        // System.out.println("O(n): sum2: " + sum2);

        // find key from row ways or col ways sorted array-----------
        // int numbers[][] = {
        // { 10, 20, 30, 40 },
        // { 15, 25, 35, 45 },
        // { 27, 29, 37, 48 },
        // { 32, 33, 39, 50 }
        // };
        // int key = 33;
        // boolean r = staircaseSearch(numbers, key);

        // --------------------------------------------------------
        // 2D array question
        // Q1.
        // int nums[][] = { {4,7,8},{8,8,7} };
        // int key = 7;

        // int count = 0;
        // for(int i=0; i<nums.length; i++){
        // for(int j=0; j<nums[0].length; j++){
        // if(nums[i][j] == key){
        // count++;
        // }
        // }
        // }
        // System.out.println(count);
        // Q2.
        // int nums[][] = { { 1, 4, 9 }, { 11, 4, 3 }, { 2, 2, 3 } };
        // int sum = 0;

        // for(int i=0; i<nums[1].length; i++){
        // sum += nums[1][i];
        // }

        // System.out.println("sum: " + sum);

        // Q3.

        int nums[][] = { { 11, 12, 13 }, { 21, 22, 23 } };
        System.out.println("Original matrix: ");
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();


        int nums2[][] = new int[nums[0].length][nums.length];

        System.out.println("Transform matrix: ");
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                nums2[j][i] = nums[i][j];
            }
        }

        for(int i=0; i<nums2.length; i++){
            for(int j=0; j<nums2[0].length; j++){
                System.out.print(nums2[i][j] + " ");
            }
            System.out.println();            
        }

        // ----------------------------------------------

    }

    // binary search or staircase Search on 2D array
    public static boolean staircaseSearch(int numbers[][], int key) {
        int row = 0;
        int col = numbers.length - 1;

        while (row < numbers.length && col >= 0) {
            if (numbers[row][col] == key) {
                System.out.printf("key found at index: (%d,%d)", row, col);
                return true;
            } else if (key < numbers[row][col]) {
                col--;
            } else {
                row++;
            }
        }
        System.out.println("key not found");
        return false;
    }
}