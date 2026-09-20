public class sortingQs {
    // bubble sort
    public static void bubble(int nums[]) {
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

    // selection
    public static void selection(int nums[]) {
        for (int i = 0; i < nums.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[min]) {
                    min = j;
                }
            }
            int t = nums[min];
            nums[min] = nums[i];
            nums[i] = t;
        }

        for (int n : nums) {
            System.out.print(n + " ");
        }
    }

    // insertion
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

        for (int n : nums) {
            System.out.print(n + " ");
        }
    }

    // counting
    public static void counting(int nums[]) {
        int largest = 0;
        for (int n : nums) {
            largest = Math.max(largest, n);
        }

        int count[] = new int[largest + 1];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        int j = 0;
        for (int i = count.length-1; i>=0; i--) {
            while (count[i] > 0) {
                nums[j] = i;
                j++;
                count[i]--;
            }
        }

        for (int n : nums) {
            System.out.print(n + " ");
        }
    }

    public static void main(String[] args) {
        int nums[] = { 3, 6, 2, 1, 8, 7, 4, 5, 3, 1 };
        bubble(nums);
        System.out.println();
        selection(nums);
        System.out.println();
        insertion(nums);
        System.out.println();
        counting(nums);
        System.out.println();
    }
}
