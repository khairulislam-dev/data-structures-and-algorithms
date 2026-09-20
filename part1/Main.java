import java.util.Scanner;
import java.util.Arrays;

public class Main {
    // array pairs
    public static void printArrPairs(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                System.out.print("(" + arr[i] + "," + arr[j] + ")");
            }
            System.out.println();
        }
    }

    public static void printSubArr(int nums[], int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(nums[k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void maxSubArrSum(int nums[], int n) {
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                System.out.println(sum);
                maxSum = Math.max(maxSum, sum);
                minSum = Math.min(minSum, sum);
            }
            System.out.println();
        }
        System.out.println("max sub arr sum: " + maxSum);
        System.out.println("min sub arr sum: " + minSum);
    }

    public static void maxSubArrSum2(int numbers[], int n) {
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;

        int prefix[] = new int[n];
        prefix[0] = numbers[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + numbers[i];
        }

        int currSum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                currSum = i == 0 ? prefix[j] : prefix[j] - prefix[i - 1];
                maxSum = Math.max(maxSum, currSum);
                minSum = Math.min(minSum, currSum);
            }
        }

        System.out.println("max sub arr sum: " + maxSum);
        System.out.println("min sub arr sum: " + minSum);
    }

    public static void msWithSubArr(int nums[]) {
        int maxSum = nums[0];
        int currSum = nums[0];
        int start = 0, end = 0;
        int tempStart = 0;

        for (int i = 1; i < nums.length; i++) {
            if (currSum + nums[i] < nums[i]) {
                currSum = nums[i];
                tempStart = i;
            } else {
                currSum = nums[i];
            }

            if (currSum > maxSum) {
                maxSum = currSum;
                start = tempStart;
                end = i;
            }
        }

        System.out.println("max sum: " + maxSum);

        for (int i = start; i <= end; i++) {
            System.out.print(nums[i] + " ");
        }

    }

    public static void msWithSubArr2(int numbers[]) {
        int ms = Integer.MIN_VALUE;
        int cs = 0;
        int start = 0;
        int end = 0;
        int tempStart = 0;
        int maxElement = Integer.MIN_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > maxElement) {
                maxElement = numbers[i];
            }

            cs += numbers[i];

            if (cs > ms) {
                ms = cs;
                start = tempStart;
                end = i;
            }

            if (cs < 0) {
                cs = 0;
                tempStart = i + 1;
            }
        }
        if (ms < 0) {
            System.out.println("max sum: " + maxElement);
            System.out.println("max subarray: " + maxElement);
        } else {
            System.out.println("max sum: " + ms);
            System.out.println("subarray: ");
            for (int i = start; i <= end; i++) {
                System.out.print(numbers[i] + " ");
            }
        }
    }

    public static void scoreValidated() {
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        int x;
        double a = 0, b = 0;
        while (true) {
            double score = sc.nextDouble();

            if (a == 0 && score >= 0 && score <= 10.1) {
                a = score;
            } else if (b == 0 && score >= 0 && score <= 10.1) {
                b = score;
                System.out.println("Media = " + (a + b) / 2);
                flag = true;
            } else {
                System.out.println("nota invalida");
            }

            while (flag) {
                System.out.println("novo calculo (1-sim 2-nao)");
                x = sc.nextInt();

                if (x == 1) {
                    flag = false;
                    a = 0;
                    b = 0;
                } else if (x == 2) {
                    return;
                }
            }
        }
    }

    // trapping rain water
    public static void trappingRainWater(int height[]) {
        int n = height.length;
        // left max bar
        int leftMax[] = new int[n];
        leftMax[0] = height[0];

        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        // right max bar
        int rightMax[] = new int[n];
        rightMax[n - 1] = height[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        System.out.println("leftmax: ");
        for (int bar : leftMax) {
            System.out.print(bar + " ");
        }
        System.out.println();
        System.out.println("right max: ");
        for (int bar : rightMax) {
            System.out.print(bar + " ");
        }
        // min(leftMax,rightMax) - height // trapping water
        int trappedWater = 0;
        for (int i = 0; i < n; i++) {
            trappedWater += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        System.out.println();
        System.out.println("Trapping water: " + trappedWater);
    }

    // stock by sell
    public static void stockBuySells(int prices[]) {
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            int currPrice = prices[i];
            if (buyPrice < currPrice) {
                int profit = currPrice - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            } else {
                buyPrice = prices[i];
            }
        }

        System.out.println("max profit: " + maxProfit);
    }

    public static boolean twiceElement(int numbers[]) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean twiceElement2(int numbers[]) {
        int maxNum = 0;
        for (int n : numbers) {
            maxNum = Math.max(maxNum, n);
        }

        int count[] = new int[maxNum];
        for (int i = 0; i < numbers.length; i++) {
            count[numbers[i]]++;
        }

        for (int n : count) {
            if (n >= 2) {
                return true;
            }
        }
        return false;
    }

    public static void triplets(int numbers[]) {
        int max = 0;
        for (int n : numbers) {
            max = Math.max(max, n);
        }
        int r[] = new int[max];
        int output[][] = new int[numbers.length][numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                for (int k = i; k <= j; k++) {
                    if ((i != j && i != k && j != k) && (numbers[i] + numbers[j] + numbers[k] == 0)) {
                        System.out.println(numbers[i] + " " + numbers[j] + " " + numbers[k]);

                    }
                }
            }
        }

    }

    public static void bubbleSort(int nums[]) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int t = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = t;
                }
            }
        }

        for (int n : nums) {
            System.out.print(n + " ");
        }
    }

    public static void bubble(int nums[]) {
        for (int i = 0; i < nums.length - 1; i++) {
            int swap = 0;
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int t = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = t;
                    swap++;
                }
            }
            if (swap == 0) {
                break;
            }
        }
    }

    public static void printArray(int arr[]) {
        for (int n : arr) {
            System.out.print(n + " ");
        }
    }

    public static void selection(int nums[]) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            int t = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = t;
        }
    }

    // insertion sort
    public static void insertion(int nums[]) {
        for (int i = 1; i < nums.length; i++) {
            int key = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }
    }

    public static void counting(int nums[]) {
        // found largest number from nums
        int largest = 0;
        for (int n : nums) {
            largest = Math.max(largest, n);
        }

        int count[] = new int[largest + 1];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        int j = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                nums[j] = i;
                j++;
                count[i]--;
            }
        }
    }

    public static void printOddEven() {
        int par[] = new int[5];
        int impar[] = new int[5];

        Scanner sc = new Scanner(System.in);
        int n;
        int even = 0;
        int odd = 0;
        int last = 0;

        for (int i = 0; i < 15; i++) {
            n = sc.nextInt();

            if (n % 2 == 0) {
                par[even] = n;
                even++;
            } else {
                impar[odd] = n;
                odd++;
            }

            if (even == 5) {
                for (int j = 0; j < even; j++) {
                    System.out.printf("par[%d] = %d\n", j, par[j]);
                    par[j] = 0;
                    last = n;
                }
                even = 0;
            }

            if (odd == 5) {
                for (int j = 0; j < odd; j++) {
                    System.out.printf("impar[%d] = %d\n", j, impar[j]);
                    impar[j] = 0;
                    last = n;
                }
                odd = 0;
            }
        }

        if (last % 2 == 0) {
            for (int i = 0; i < even; i++) {
                System.out.printf("par[%d] = %d\n", i, par[i]);
            }

            for (int j = 0; j < odd; j++) {
                System.out.printf("impar[%d] = %d\n", j, impar[j]);
                impar[j] = 0;
            }
        } else {
            for (int j = 0; j < odd; j++) {
                System.out.printf("impar[%d] = %d\n", j, impar[j]);
                impar[j] = 0;
            }
            for (int i = 0; i < even; i++) {
                System.out.printf("par[%d] = %d\n", i, par[i]);
            }
        }

    }

    public static void main(String args[]) {

        // printOddEven();
        // int nums[] = { 20, 5, 8, 33, 1, 5 };
        // counting(nums);
        // bubbleSort(nums);
        // bubble(nums);
        // selection(nums);
        // insertion(nums);
        // Arrays.sort(nums, 3, 7);
        // printArray(nums);
        // int prices[] = { 7, 6, 5, 3, 2 };
        // stockBuySells(prices);
        // scoreValidated();
        // int arr[] = { 2, 4, 6, 8, 10 };
        // int n = arr.length;

        // int arr[] = new int[] { 2, 4, 6, 8, 10 };
        // int arr[] = { -1, -4, 7, 2, -6, 4 };
        // int arr[] = {-2,5,-5,-2,4};
        // int arr[] = { -5,5,-3,5 -2, -8 };
        // int arr[] = { -9, -2, -1, -2 };

        // // printArrPairs(arr, n);
        // maxSubArrSum(arr, n);
        // maxSubArrSum2(arr, n);

        // System.out.println("ager sum bar bar clc na kra");
        // int maxSum = 0;
        // for (int i = 0; i < n; i++) {
        // int sum = 0;

        // for (int j = i; j < n; j++) {
        // sum += arr[j];
        // System.out.println(sum);

        // if (sum > maxSum)
        // maxSum = sum;
        // }
        // System.out.println();
        // }

        // System.out.println("max sum: " + maxSum);

        // msWithSubArr2(arr);
        // int height[] = { 4, 2, 0, 6, 3, 2, 5 };
        // trappingRainWater(height);
        // int numbers[] = { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };
        // boolean result = twiceElement(numbers);
        // boolean result = twiceElement(numbers);
        // System.out.println(result);
        // int numbers[] = { -1, 0, 1, 2, -1, -4 };
        // triplets(nu/mbers);

        // for(int i=1; i<=100; i++){
        // for(int j=1; j<=100; j++){
        // System.out.print(i + " ");
        // }
        // System.out.println();
        // }

        // for (int i = 1; i <= 10; i++) {
        // for (int j = 1; j <= 10; j++) {
        // System.out.print(j + " ");
        // }
        // System.out.println();
        // }

        // Scanner sc = new Scanner(System.in);
        // while (true) {
        // int n = sc.nextInt();
        // if (n == 0)
        // break;
        // n = n - 1;
        // for (int i = 0; i <= n; i++) {
        // for (int j = 0; j <= n; j++) {
        // int r = Math.abs((i - j)) + 1;
        // System.out.printf("%3d", r);
        // if (j < n)
        // System.out.print(" ");
        // }
        // System.out.println();
        // }
        // System.out.println();
        // }

        // sc.close();

        // int number = 123400;
        // int reverse = 0;
        // int firstDigit = 1;

        // while (number != 0) {
        // int digit = number % 10;
        // if (firstDigit == 1) {
        // if (digit == 0) {
        // firstDigit = digit;
        // } else {
        // firstDigit = -1;
        // }
        // }
        // reverse = (reverse * 10) + digit;
        // number = number / 10;
        // }

        // if(firstDigit == 0){
        // System.out.println(firstDigit+""+reverse);
        // }else{

        // System.out.println(reverse);
        // }

        for (int i = 0; i < 7; i++) {
            int textLen = 0;
            int flag = 1;
            for (int j = 0; j < 39; j++) {
                if (i == 0 || i == 6) {
                    System.out.print("-");
                } else if (j == 0 && i != 0 && i != 6 || j == 38 && i != 0 && i != 6) {
                    System.out.print("|");
                } else {
                    if ((i == 1 && j >= 1 && j <= 6) ||
                            (i == 3 && j >= 17 && j <= 22) ||
                            (i == 5 && j >= 32) && textLen <= 6) {
                        if (flag == 1) {
                            System.out.print("x = 35");
                            flag = 0;
                        }
                        textLen += 1;
                        continue;
                    }
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
        }

    }

}
