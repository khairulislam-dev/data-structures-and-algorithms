public class Loop {
    // bubble sort
    public static void bubble(int nums[]) {
        System.out.println("Bubble function execute successfully.");
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int t = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = t;
                }
            }
        }
    }

    // selection sort
    public static void selection(int nums[]) {
        System.out.println("selection function execute successfully.");
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            int t = nums[min];
            nums[min] = nums[i];
            nums[i] = t;
        }
    }

    // insertion sort
    public static void insertion(int nums[]) {
        System.out.println("insertion function execute successfully.");
        for (int i = 1; i < nums.length - 1; i++) {
            int key = nums[i];
            int j = i - 1;

            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }
    }

    // counting sort
    public static void counting(int nums[]) {
        System.out.println("counting function execute successfully.");
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

    public static void main(String args[]) {
        int nums[] = { 2, 4, 6, 7, 8 };
        // bubble(nums);
        // selection(nums);
        // insertion(nums);
        counting(nums);
        for (int n : nums) {
            System.out.print(n + " ");
        }
    }
}