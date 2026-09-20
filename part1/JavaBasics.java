import java.util.Scanner;

public class JavaBasics {
    public static int menuSearch(String arr[], String target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // largest number found
    public static int largestNumber(int numbers[]) {
        int maxNumber = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > maxNumber) {
                maxNumber = numbers[i];
            }
        }
        return maxNumber;
    }

    // max or min number
    public static int[] maxOrMin(int numbers[]) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        return new int[] { max, min };
    }

    // Binary Search
    public static int binarySearchEngine(int numbers[], int target) {
        int start = 0;
        int end = numbers.length - 1;
        int mid;

        while (start <= end) {
            mid = (end - start) + start / 2;
            if (numbers[mid] == target) {
                return mid;
            } else if (numbers[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    // reverse an array
    public static boolean reverseArray(int arr[]) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return true;
    }

    public static void pairArray(int numbers[]) {
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            for (int j = i + 1; j < numbers.length; j++) {
                System.out.print("(" + num + "," + numbers[j] + ")");
            }
            System.out.println();
        }
    }

    // sub array
    public static void subArr(int numbers[]) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    // System.out.print(numbers[k] + " ");
                    sum += numbers[k];
                }
                System.out.print(sum);
                max = Math.max(max, sum);
                min = Math.min(min, sum);
                sum = 0;
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("Max sub array sum: " + max);
        System.out.println("Min Sub array sum: " + min);
    }

    // max sub array sum
    public static void subArr2(int numbers[]) {
        int maxSum = Integer.MIN_VALUE;
        int preFix[] = new int[numbers.length];
        // calculate prefix
        preFix[0] = numbers[0];

        for (int i = 1; i < preFix.length; i++) {
            preFix[i] = preFix[i - 1] + numbers[i];
        }

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {
                int currSum = preFix[j] == 0 ? preFix[j] : preFix[j] - preFix[i - 1];
                maxSum = Math.max(maxSum, currSum);
            }
        }
        System.out.println("Max sum: " + maxSum);
    }

    public static void main(String[] args) {

        int numbers[] = new int[] { 2, 4, 6, 8, 10 };
        subArr(numbers);

        subArr2(numbers);
        // String menus[] = { "Porota", "singara", "Kushuli" };
        // String target = "Kishuli";
        // int index = menuSearch(menus, target);

        // if (index == -1) {
        // System.out.println("NOT Found");
        // } else {
        // System.out.println("found at index: " + index);
        // }

        // int numbers[] = { 10, 2, 3, 40, 5, 6, -7, 8 };
        // // int maxNum = largestNumber(numbers);
        // // System.out.println("Largest Number: " + maxNum);

        // int maxMin[] = maxOrMin(numbers);

        // System.out.println("Max Number: " + maxMin[0]);
        // System.out.println("Min Number: " + maxMin[1]);

        // int a = 1;
        // int b = 2;
        // int c = 3;

        // int numbers1[] = new int[] { a, b, c };
        // int numbers2[] = { a, b, c };

        // System.out.println("numbers1: " + numbers1[0]);
        // System.out.println("numbers2: " + numbers2[0]);

        // int numbers3[] = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
        // int target = 7;
        // int index = binarySearchEngine(numbers3, target);

        // if (index == -1) {
        // System.out.println("NOT FOUND :(");
        // } else {
        // System.out.println("Target found at index: " + index);
        // }

        // int arr[] = { 2, 4, 6, 8, 10 };
        // System.out.println("Before reverse Array");
        // for (int num : arr) {
        // System.out.print(num + " ");
        // }
        // System.out.println();
        // reverseArray(arr);

        // System.out.println("After reverse Array");
        // for (int num : arr) {
        // System.out.print(num + " ");
        // }

        // int numbers4[] = { 2, 4, 6, 8, 10 };
        // pairArray(numbers4);

        // // user scanner
        // Scanner sc = new Scanner(System.in);

        // // Create new array
        // int numbers[] = new int[5];

        // // store data
        // for (int i = 0; i < numbers.length; i++) {
        // numbers[i] = sc.nextInt();
        // }

        // for (int n : numbers) {
        // System.out.println(n);
        // }
        // sc.close();

        // int numbers[] = new int[5];
        // float cgpa[] = new float[5];
        // char ch[] = new char[5];
        // double d[] = new double[5];
        // String s[] = new String[5];

        // System.out.println("-" + ch[0] + "-");
        // System.out.println("-" + s[0] + "-");
        // System.out.println("-" + numbers[0] + "-");
        // System.out.println("-" + cgpa[0] + "-");
        // System.out.println("-" + d[0] + "-");

        // for (char c : ch) {
        // System.out.println("-" + c + "-");
        // }

        // int arr[] = new int[] { 1, 2, 3, 4 };

        // for (int n : arr) {
        // System.out.println(n);
        // }

        // firstPositionChange(arr);
        // System.out.println("After change first position:");
        // System.out.println("This is call by reference.");

        // for (int n : arr) {
        // System.out.println(n);
        // }

        // System.out.println("------------------------------");

        // updateArray(arr);
        // System.out.println("----------------------------------");
        // for (int n : arr) {
        // System.out.print(n + " ");
        // }

        // System.out.println();

        // int key = 4;
        // linerSearch(arr, key);

        // int numbers[] = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        // int target = 10;
        // int result = binarySearch(numbers, target);
        // System.out.println(result);
    }

}
