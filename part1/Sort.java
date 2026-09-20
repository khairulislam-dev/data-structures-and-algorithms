import java.util.Arrays;
import java.util.Collections;

public class Sort {
    public static void bubbleSort(int nums[]) {
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int t = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = t;
                }
            }
        }

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void selectionSort(int nums[]) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIdx]) {
                    minIdx = j;
                }
            }
            int t = nums[minIdx];
            nums[minIdx] = nums[i];
            nums[i] = t;
        }

        for (int n : nums) {
            System.out.print(n + " ");
        }
    }

    // insertion sort
    // 3, 2, 1
    // 1, 2, 3
    public static void insertionSort(int nums[]) {
        for (int i = 1; i < nums.length; i++) {
            int key = nums[i];
            int j = i - 1;
            // finding out the correct pos to insert
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }
            // insertion
            nums[j + 1] = key;
        }
    }

    // counting sort
    public static void countingSort(int nums[]) {
        int largest = 0;
        for (int i = 0; i < nums.length; i++) {
            largest = Math.max(largest, nums[i]);
        }

        int counting[] = new int[largest + 1];
        for (int i = 0; i < nums.length; i++) {
            counting[nums[i]]++;
        }

        int j = 0;
        for (int i = 0; i < counting.length; i++) {
            while (counting[i] > 0) {
                nums[j] = i;
                j++;
                counting[i]--;
            }
        }
    }

    // main class (Program execute start main class)
    public static void main(String[] args) {
        int nums[] = { 4, 7, 3, 1, 11 };
        // bubbleSort(nums); // sorting ascending order
        // selectionSort(nums);
        // insertionSort(nums);

        // Arrays.sort(nums, Collections.reverseOrder());
        // Arrays.sort(nums, 3,7); // tc= O(n log n)

        countingSort(nums);

        for (int n : nums) {
            System.out.print(n + " ");
        }
    }
}
