import java.util.ArrayList;
import java.util.Collections;

public class ArrList {

    public static void printReverse(ArrayList<Integer> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }

    }

    public static void swop(ArrayList<Integer> list, int i, int j) {
        Integer temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    // Container with most water
    public static void containerMostWater(ArrayList<Integer> height) {

        int totalWater = 0;
        for (int i = 0; i < height.size(); i++) {
            for (int j = i + 1; j < height.size(); j++) {
                int waterLevel = Math.min(height.get(i), height.get(j));
                int width = j - i;
                int water = waterLevel * width;
                totalWater = Math.max(totalWater, water);
            }
        }
        System.out.println("Total Max Water: " + totalWater);
    }

    public static void containerMostWater2(ArrayList<Integer> height) {
        int maxWater = 0;
        int left = 0;
        int right = height.size() - 1;

        while (left < right) {
            int waterLevel = Math.min(height.get(left), height.get(right));
            int width = right - left;
            int currWater = waterLevel * width;
            maxWater = Math.max(maxWater, currWater);
            if (height.get(left) < height.get(right)) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println("Max Water: " + maxWater);
    }

    // pair sum
    public static boolean pairSum(ArrayList<Integer> nums, int target) {
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                if (nums.get(i) + nums.get(j) == target) {
                    return true;
                }
            }
        }
        return false;
    }

    // 2 pointer approach
    public static boolean pairSum2(ArrayList<Integer> numbers, int target) {
        int left = 0;
        int right = numbers.size() - 1;

        while (left < right) {
            if (numbers.get(left) + numbers.get(right) == target) {
                return true;
            }
            if (numbers.get(left) + numbers.get(right) < target) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    // pair sum sorted & rotated arraylist (2 pointer approach)
    public static boolean pairSum3(ArrayList<Integer> numbers, int target) {
        int pivot = 0;
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i - 1) > numbers.get(i)) {
                pivot = i;
                break;
            }
        }

        int left = pivot;
        int right = pivot - 1;

        while (left != right) {
            if (numbers.get(left) + numbers.get(right) == target) {
                return true;
            } else if (numbers.get(left) + numbers.get(right) > target) {
                right = (numbers.size() + right - 1) % numbers.size();
            } else {
                left = (left + 1) % numbers.size();
            }
        }
        return false;
    }

    public static boolean isMonotonic(ArrayList<Integer> list) {
        if (list.get(0) < list.get(1)) {
            // left to right ascending order
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i - 1) > list.get(i)) {
                    return false;
                }
            }
        } else {
            // left to right descending order
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i - 1) < list.get(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isMonotonic2(ArrayList<Integer> list) {

        boolean asce = true;
        boolean desc = true;

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) < list.get(i)) {
                desc = false;
            }

            if (list.get(i - 1) > list.get(i)) {
                asce = false;
            }
        }

        return asce || desc;
    }

    public static ArrayList<Integer> isLonely(ArrayList<Integer> list) {
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (list.contains(list.get(i) - 1) || list.contains(list.get(i) + 1)) {
                continue;
            } else {
                int n = list.remove(i);
                if (!list.contains(n)) {
                    ans.add(n);
                }
            }
        }
        return ans;
    }

    // problem no: 03
    // Most Frequent Number following key
    public static int mostFrequentNum(ArrayList<Integer> list, int key) {
        ArrayList<Integer> temp = new ArrayList<>();
        // case 1:
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) == key) {
                temp.add(list.get(i));
            }
        }
        // case 2: sorted ascending order
        Collections.sort(temp);

        // case 3: count max occur number
        int num = 0;
        int count = 0;
        int tempNum = temp.get(0);
        int tempCount = 0;

        for (int i = 0; i < temp.size(); i++) {
            if (temp.get(i) == tempNum) {
                if (num == 0) {
                    num = tempNum;
                }
                tempCount++;
            } else {
                if (count < tempCount) {
                    num = tempNum;
                    count = tempCount;
                    tempNum = temp.get(i);
                    tempCount = 1;
                }
            }
        }
        if (count < tempCount) {
            num = tempNum;
        }
        return num;
    }

    public int mostFrequent(ArrayList<Integer> nums, int key) {
        int[] result = new int[1000];
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) == key) {
                result[nums.get(i + 1) - 1]++;
            }
        }
        int max = Integer.MIN_VALUE;
        int ans = 0;
        for (int i = 0; i < 1000; i++) {
            if (result[i] > max) {
                max = result[i];
                ans = i + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // ArrayList<Integer> list = new ArrayList<>();
        // list.add(1);
        // list.add(2);
        // list.add(3);
        // list.add(4);

        // System.out.println(list);
        // list.addFirst(99);
        // list.addLast(11);
        // System.out.println(list);
        // System.out.println(list.contains(99));
        // System.out.println("remove value: " + list.remove(Integer.valueOf(4)));
        // System.out.println("remove value: " + list.remove(Integer.valueOf(99)));
        // System.out.println("remove value: " + list.remove(Integer.valueOf(11)));
        // System.out.println(list);
        // ArrayList<Integer> list = new ArrayList<>();
        // list.add(4);
        // list.add(3);
        // list.add(2);
        // list.add(1);
        // System.out.println(list);
        // // printReverse(list);
        // swop(list, 0, 3);
        // System.out.println(list);
        // Collections.sort(list);
        // System.out.println(list);
        // Collections.sort(list, Collections.reverseOrder());
        // System.out.println(list);

        // ArrayList<String> list = new ArrayList<>(5);

        // list.add("Khairul");
        // list.add("Imran");
        // list.add("Rayhan");
        // list.add("Kawsar");
        // list.add("Razzak");
        // list.add("Rakib");
        // list.add("Naim");

        // System.out.println(list);

        // 2D ArrayList
        // ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        // list.add(new ArrayList<>());
        // list.add(new ArrayList<>());
        // list.add(new ArrayList<>());

        // list.get(0).add(1);
        // list.get(0).add(2);
        // list.get(0).add(3);

        // list.get(1).add(1);
        // list.get(1).add(2);
        // list.get(1).add(3);

        // list.get(2).add(1);
        // list.get(2).add(2);
        // list.get(2).add(3);

        // System.out.println(list);
        // System.out.println(list.get(0).get(0));

        // ArrayList<ArrayList<ArrayList<Integer>>> threeDim = new ArrayList<>();
        // ArrayList<ArrayList<Integer>> twoDim = new ArrayList<>();
        // twoDim.add(new ArrayList<>());
        // twoDim.add(new ArrayList<>());
        // twoDim.add(new ArrayList<>());

        // twoDim.get(0).add(1);
        // twoDim.get(0).add(1);
        // twoDim.get(0).add(1);

        // twoDim.get(1).add(1);
        // twoDim.get(1).add(1);
        // twoDim.get(1).add(1);

        // twoDim.get(2).add(1);
        // twoDim.get(2).add(1);
        // twoDim.get(2).add(1);

        // threeDim.add(twoDim);

        // System.out.println(threeDim);
        // System.out.println();
        // System.out.println(twoDim);

        // ArrayList<Integer> height = new ArrayList<>();
        // height.add(1);
        // height.add(8);
        // height.add(6);
        // height.add(2);
        // height.add(5);
        // height.add(4);
        // height.add(8);
        // height.add(3);
        // height.add(7);
        // containerMostWater(height);
        // containerMostWater2(height);

        // int target = 17;
        // ArrayList<Integer> nums = new ArrayList<>();
        // nums.add(7);
        // nums.add(8);
        // nums.add(9);
        // nums.add(1);
        // nums.add(2);
        // nums.add(3);
        // nums.add(4);

        // System.out.println(pairSum3(nums, target));

        // ArrayList<Integer> list = new ArrayList<>();
        // list.add(2);
        // list.add(3);
        // list.add(1);

        // System.out.println(isMonotonic(list));
        // System.out.println(isMonotonic2(list));

        // ArrayList<Integer> list = new ArrayList<>();
        // list.add(10);
        // list.add(6);
        // list.add(5);
        // list.add(8);

        // list.add(1);
        // list.add(3);
        // list.add(5);
        // list.add(3);
        // System.out.println(isLonely(list));

        int key = 1;
        ArrayList<Integer> list = new ArrayList<>();
        // 1,100,200,1,100
        list.add(1);
        list.add(100);
        list.add(200);
        list.add(1);
        list.add(100);

        list.add(1);
        list.add(6);

        list.add(1);
        list.add(6);

        list.add(1);
        list.add(6);
        list.add(60);

        list.add(1);
        list.add(99);

        list.add(1);
        list.add(99);

        list.add(1);
        list.add(99);

        list.add(1);
        list.add(99);
        System.out.print(mostFrequentNum(list, key));
    }
}
