public class Recursions {
    // problem 1
    static void printDec(int n) {
        if (n == 0) {
            return;
        }
        System.out.print(n + " ");
        printDec(n - 1);
    }

    // problem 2
    static void printInc(int n) {
        if (n == 0) {
            return;
        }
        printInc(n - 1);
        System.out.print(n + " ");
    }

    // problem 3
    static int printFact(int n) {

        if (n == 0) {
            return 1;
        }
        return n * printFact(n - 1);
    }

    // problem 4
    static int printNthNumSum(int n) {
        if (n == 1) {
            return 1;
        }
        return n + printNthNumSum(n - 1);
    }

    // problem 5
    static int printFib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int nM1 = printFib(n - 1);
        int nM2 = printFib(n - 2);
        return nM1 + nM2;
    }

    // problem 6
    static boolean isSorted(int arr[], int i) {
        // base case
        if (i == arr.length - 1) {
            return true;
        }
        // work
        if (arr[i] > arr[i + 1]) {
            return false;
        }
        return isSorted(arr, i + 1);
    }

    // reverse String
    static String reverseString(String str, int i) {
        if (i == 0) {
            return "" + str.charAt(0);
        }
        String s = "" + str.charAt(i);
        return s + reverseString(str, i - 1);
    }

    // first occurrence
    static int firstOcc(int arr[], int i, int target) {
        // base case
        if (i == arr.length) {
            return -1;
        }
        if (arr[i] == target) {
            return i;
        }
        return firstOcc(arr, i + 1, target);
    }

    // last occurrence
    static int lastOcc(int arr[], int i, int target) {
        // base case
        if (i == -1) {
            return -1;
        }
        // work
        if (arr[i] == target) {
            return i;
        }
        // call yourself
        return lastOcc(arr, i - 1, target);
    }

    // last occurrence
    static int lastOccurrence(int arr[], int i, int key) {
        // base case
        if (i == arr.length)
            return -1;

        int isFound = lastOccurrence(arr, i + 1, key);
        if (isFound == -1 && arr[i] == key) {
            return i;
        }
        return isFound;
    }

    // print x to the power n
    static int pow(int x, int n) {
        if (n == 0) {
            return 1;
        }
        return x * pow(x, n - 1);
    }

    // optimize x to the power n
    static int pow2(int x, int n) {
        if (n == 0) {
            return 1;
        }

        int halfPow = pow2(x, n / 2);
        int halfPowSq = halfPow * halfPow;

        if (n % 2 != 0) {
            halfPowSq = x * halfPowSq;
        }
        return halfPowSq;
    }

    // tiling problem
    static int tilingProb(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        return tilingProb(n - 1) + tilingProb(n - 2);
    }

    // remove duplicates in a string
    public static String removeDuplicateString(String str, int arr[], int i) {
        if (i == -1)
            return "";

        char ch = str.charAt(i);
        int n = str.charAt(i) - 'a';

        String s = removeDuplicateString(str, arr, i - 1);
        if (arr[n] == 0) {
            arr[n] = 1;
            s += (ch + "");
        }
        return s;
    }

    // remove duplicate in a string
    public static void removeDuplicateStr(String str, int i, StringBuilder sb, boolean map[]) {
        if (i == str.length()) {
            System.out.println(sb);
            return;
        }

        if (map[str.charAt(i) - 'a'] == true) {
            removeDuplicateStr(str, i + 1, sb, map);
        } else {
            map[str.charAt(i) - 'a'] = true;
            removeDuplicateStr(str, i, sb.append(str.charAt(i)), map);
        }
    }

    // friends paring problem's
    public static int friendsPairingProblem(int n) {
        // base case
        if (n == 1 || n == 2) {
            return n;
        }

        // work
        // single choice
        // int nm1 = friendsPairingProblem(n - 1);
        // int nm2 = (n - 1) * friendsPairingProblem(n - 2);
        // return nm1 + nm2;

        return friendsPairingProblem(n - 1) + (n - 1) * friendsPairingProblem(n - 2);
    }

    // consecutive 1
    static void binaryString(int n, int lastPlace, String str) {
        // base case
        if (n == 0) {
            System.out.println(str);
            return;
        }

        binaryString(n - 1, 0, str + "0");
        if (lastPlace == 0) {
            binaryString(n - 1, 1, str + "1");
        }
    }

    // consecutive 0
    static void binaryStrings(int n, int lastPlace, String str) {
        // base case
        if (n == 0) {
            System.out.println(str);
            return;
        }

        binaryStrings(n - 1, 1, str + "1");
        if (lastPlace == 1) {
            binaryStrings(n - 1, 0, str + "0");
        }
    }

    // question 1
    static void printAllOccurrence(int arr[], int i, int target) {
        if (i == arr.length)
            return;
        if (arr[i] == target) {
            System.out.print(i + " ");
        }
        printAllOccurrence(arr, i + 1, target);
    }

    static void numberToString(int num) {
        if (num == 0)
            return;
        int lastDigit = num % 10;
        numberToString(num / 10);
        if (lastDigit == 0) {
            System.out.print("zero ");
        } else if (lastDigit == 1) {
            System.out.print("one ");
        } else if (lastDigit == 2) {
            System.out.print("two ");
        } else if (lastDigit == 3) {
            System.out.print("three ");
        } else if (lastDigit == 4) {
            System.out.print("four ");
        } else if (lastDigit == 5) {
            System.out.print("five ");
        } else if (lastDigit == 6) {
            System.out.print("six ");
        } else if (lastDigit == 7) {
            System.out.print("seven ");
        } else if (lastDigit == 8) {
            System.out.print("eight ");
        } else if (lastDigit == 9) {
            System.out.print("nine ");
        }
    }

    // Marge Sort
    public static void margeSort(int arr[], int start, int end) {
        // base case
        if (start >= end)
            return;
        int mid = start + (end - start) / 2;
        margeSort(arr, start, mid);
        margeSort(arr, mid + 1, end);
        marge(arr, start, mid, end);
    }

    public static void marge(int arr[], int start, int mid, int end) {
        // create temp arr
        int temp[] = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= end) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= end) {
            temp[k++] = arr[j++];
        }

        for (k = 0, i = start; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // quick sort
    public static void quickSort(int arr[], int si, int ei) {
        // base case
        if (si >= ei)
            return;

        // find pivot // partition
        int pInx = partition(arr, si, ei);
        quickSort(arr, si, pInx - 1);
        quickSort(arr, pInx + 1, ei);
    }

    public static int partition(int arr[], int si, int ei) {
        // pivot last
        int pivot = arr[ei];
        int i = si - 1;

        for (int j = si; j < ei; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        i++;
        int temp = arr[i];
        arr[i] = pivot;
        arr[ei] = temp;
        return i;
    }

    // sorted & rotated array
    public static int search(int arr[], int target, int si, int ei) {
        // base case
        if (si > ei)
            return -1;
        // work
        int mid = si + (ei - si) / 2;

        if (arr[mid] == target) {
            return mid;
        }

        if (arr[si] <= arr[mid]) {
            // case a
            if (arr[si] <= target && target <= arr[mid]) {
                return search(arr, target, si, mid - 1);
            } else {
                return search(arr, target, mid + 1, ei);
            }
        } else {
            if (arr[mid] <= target && target <= arr[ei]) {
                return search(arr, target, mid + 1, ei);
            } else {
                return search(arr, target, si, mid - 1);
            }
        }
    }

    // divide & conquer question
    // question 01
    public static void sortArrStr(String str[], int si, int ei) {
        // base case
        if (si >= ei)
            return;
        int mid = si + (ei - si) / 2;
        sortArrStr(str, si, mid);
        sortArrStr(str, mid + 1, ei);
        sort(str, si, mid, ei);

    }

    public static void sort(String str[], int si, int mid, int ei) {
        String temp[] = new String[ei - si + 1];
        int i = si;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= ei) {
            if (str[i].compareTo(str[j]) < 0) {
                temp[k++] = str[i++];
            } else {
                temp[k++] = str[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = str[i++];
        }

        while (j <= ei) {
            temp[k++] = str[j++];
        }

        for (k = 0, i = si; k < temp.length; k++, i++) {
            str[i] = temp[k];
        }
    }

    // majority element
    public static int majorityElement(int arr[]) {
        int n = (arr.length - 1) / 2;
        int max = 0;
        for (int num : arr) {
            max = Math.max(max, num);
        }
        int temp[] = new int[max + 1];

        for (int i = 0; i < arr.length; i++) {
            temp[arr[i]]++;
        }

        for (int i = 0; i < temp.length; i++) {
            if (temp[i] > n) {
                return i;
            }
        }
        return -1;
    }

    public static int majorityElement2(int arr[]) {
        int count = 0;
        int candidate = 0;

        for (int num : arr) {
            if (count == 0) {
                candidate = num;
            }
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }

    public static int getMejority(int arr[], int si, int ei) {

        if(si==ei) return arr[ei];

        int mid = si + (ei - si) / 2;
        int leftMejority = getMejority(arr, si, mid);
        int rightMejority = getMejority(arr, mid + 1, ei);

        if (leftMejority == rightMejority) {
            return leftMejority;
        }

        int leftCount = countInRange(arr, leftMejority, si, ei);
        int rightCount = countInRange(arr, rightMejority, si, ei);

        if (leftCount > rightCount) {
            return leftMejority;
        } else {
            return rightMejority;
        }
    }

    public static int countInRange(int arr[], int num, int si, int ei) {
        int count = 0;

        for (int i = si; i <= ei; i++) {
            if (arr[i] == num) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // printDec(10);
        // printInc(10);
        // System.out.println("Factorial: " + printFact(5));
        // System.out.println("N Natural Number sum: " + printNthNumSum(5));
        // System.out.println("Nth Fibonacci: " + printFib(2));

        // int arr[] = { 1, 2, 6, 4, 5 };
        // boolean result = isSorted(arr, 0);
        // System.out.println(result);

        // String text = "123456789";
        // String str = reverseString(text, text.length() - 1);
        // System.out.println(str);

        // int arr[] = { 2, 2, 2, 3, 4, 5, 9 };
        // System.out.println("first Occurrence: " + firstOcc(arr, 0, 9));
        // System.out.println("last Occurrence: " + lastOcc(arr, arr.length - 1, 2));
        // System.out.println("last Occurrence: " + lastOccurrence(arr, 0, 2));

        // System.out.println("X to the power n: " + pow(2, 10));
        // System.out.println("X to the power n: " + pow2(2, 10));
        // String str = "aabbcc";
        // String s = removeDuplicateString(str, new int[26], str.length() - 1);
        // System.out.println(s);
        // removeDuplicateStr("aabbcc", 0, new StringBuilder(), new boolean[26]);

        // System.out.println(friendsPairingProblem(5));
        // binaryString(2, 0, "");
        // binaryStrings(2, 1, "");

        // Question 1
        // int arr[] = { 3, 2, 4, 5, 6, 2, 7, 2, 2 };
        // int key = 2;
        // printAllOccurrence(arr, 0, key);

        // question 2
        // numberToString(1947);

        // int arr[] = { 7, 5, 9, 0 };
        // margeSort(arr, 0, arr.length - 1);
        // printArr(arr);

        // quick sort
        // int arr[] = { 1, 7, 3, 8, 2 };
        // quickSort(arr, 0, arr.length - 1);
        // printArr(arr);

        // int arr[] = { 4, 5, 1, 2, 3 };
        // int target = 10;
        // int tarInd = search(arr, target, 0, arr.length - 1);
        // System.out.println("Target Index: " + tarInd);

        // String str[] = { "sun", "earth", "mars", "mercury" };
        // sortArrStr(str, 0, str.length - 1);

        // for (String word : str) {
        // System.out.print(word + " ");
        // }

        // int arr[] = { 3, 2, 3 };
        // int arr[] = { -2, -2, 1, 1, 1, -2, -2 };
        // int me = majorityElement(arr);
        // System.out.println("majority Element: " + me);
        // System.out.println(majorityElement2(arr));
        // System.out.println(getMejority(arr, 0, arr.length - 1));
    }
}
