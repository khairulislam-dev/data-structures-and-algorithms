
public class SubArraySum {
    // 01. maximum Sub array sum
    public static void maxSubArrSum(int numbers[]) {
        // TC = O(n³)
        // SC = O(1)
        // calculate max sub arr sub
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {
                for (int k = i; k <= j; k++) {
                    currSum += numbers[k];
                }
                // System.out.println(currSum);
                maxSum = Math.max(maxSum, currSum);
                currSum = 0;
            }
            System.out.println();
        }

        // print max sub arr sum
        System.out.println("Maximum Sub Array Sum0: " + maxSum);
    }

    // 02. maximum Sub array sum
    public static void maxSubArrSum1(int[] numbers) {
        // TC = O(n²)
        // SC = O(n)
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        // prefixed sum
        int prefixed[] = new int[numbers.length];
        prefixed[0] = numbers[0];

        for (int i = 1; i < prefixed.length; i++) {
            prefixed[i] = prefixed[i - 1] + numbers[i];
        }

        for (int i = 0; i < prefixed.length; i++) {
            for (int j = i; j < prefixed.length; j++) {
                currSum = i == 0 ? prefixed[j] : prefixed[j] - prefixed[i - 1];
                maxSum = Math.max(maxSum, currSum);
            }
        }
        System.out.println("Maximum Sub Array Sum1: " + maxSum);
    }

    // 03. maximum Sub array sum
    public static void maxSubArrSum2(int numbers[]) {
        // TC = O(n²)
        // SC = O(1)
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            int currSum = 0;
            for (int j = i; j < numbers.length; j++) {
                currSum += numbers[j];
                maxSum = Math.max(maxSum, currSum);
            }
        }
        System.out.println("Max sum2: " + maxSum);
    }

    // 04. kadane's algorithm
    public static void kadanes(int numbers[]) {
        // TC = O(n)
        // SC = O(1)
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for (int i = 0; i < numbers.length; i++) {
            currSum += numbers[i];

            if (currSum > maxSum) {
                maxSum = currSum;
            }

            if (currSum < 0) {
                currSum = 0;
            }
        }
        System.out.println("max sum: " + maxSum);
    }

    // 05. kadane's algorithm (handle all -(negative)number)
    public static void kadanesAllNegative(int numbers[]) {
        // TC = O(n)
        // SC = O(1)
        int maxSum = numbers[0];
        int currSum = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            int n = numbers[i];
            int s = currSum + numbers[i];
            if (currSum + numbers[i] > numbers[i]) {
                currSum = currSum + numbers[i];
            } else {
                currSum = numbers[i];
            }

            if (currSum > maxSum) {
                maxSum = currSum;
            }
        }
        System.out.println("max sum: " + maxSum);
    }

    // 06. kadane's algorithm with max sum all sub arr print
    public static void kadanesWithSubArr(int numbers[]) {
        int maxSum = numbers[0];
        int currSum = numbers[0];
        int start = 0, end = 0;
        int tempStart = 0;

        for (int i = 1; i < numbers.length; i++) {
            if (currSum + numbers[i] < numbers[i]) {
                currSum = numbers[i];
                tempStart = i;
            } else {
                currSum += numbers[i];
            }

            if (currSum > maxSum) {
                maxSum = currSum;
                start = tempStart;
                end = i;
            }
        }

        System.out.println("max sum: " + maxSum);

        for (int i = start; i <= end; i++) {
            System.out.print(numbers[i] + " ");
        }
    }

    // 07. kadane's algorithm with circular sub array
    public static int maxSub(int numbers[]) {
        int maxSum = numbers[0];
        int currSum = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (currSum + numbers[i] > numbers[i]) {
                currSum = currSum + numbers[i];
            } else {
                currSum = numbers[i];
            }

            if (currSum > maxSum) {
                maxSum = currSum;
            }
        }
        return maxSum;
    }

    public static int minSub(int numbers[]) {
        int minSum = numbers[0];
        int currSum = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (currSum + numbers[i] < numbers[i]) {
                currSum = currSum + numbers[i];
            } else {
                currSum = numbers[i];
            }

            if (currSum < minSum) {
                minSum = currSum;
            }
        }
        return minSum;
    }

    public static void kadaneWithCircular(int numbers[]) {
        int maxSubSum = maxSub(numbers);
        int minSubSum = minSub(numbers);

        int totalSub = 0;
        for (int i = 0; i < numbers.length; i++) {
            totalSub += numbers[i];
        }

        int circularSum = totalSub - minSubSum;
        int finalResult = maxSubSum < 0 ? maxSubSum : Math.max(maxSubSum, circularSum);

        System.out.println("max circular sum: " + finalResult);
    }

    public static void main(String args[]) {

        // int numbers[] = new int[] { 2, 4, 6, 8, 10 };
        // int numbers[] = { -1, -4, 7, 2, -6, 4 };
        int numbers[] = {-2,5,-5,-2,4};
        // int numbers[] = { -5,5,-3,5 -2, -8 };
        // int numbers[] = { -9, -2, -1, -2 };
        // invoked max sub arr sum function
        // maxSubArrSum(numbers);
        // maxSubArrSum1(numbers);
        // maxSubArrSum2(numbers);
        // kadanes(numbers);
        kadanesAllNegative(numbers);
        // kadanesWithSubArr(numbers);
        // kadaneWithCircular(numbers);
    }
}
