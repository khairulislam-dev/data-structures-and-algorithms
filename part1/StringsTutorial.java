public class StringsTutorial {

    public static String wordFirstLetterUppercase(String str) {
        StringBuilder sb = new StringBuilder("");
        sb.append(Character.toUpperCase(str.charAt(0)));
        // first character convert to uppercase
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i - 1) == ' ') {
                sb.append(Character.toUpperCase(str.charAt(i)));
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    // String compression
    public static void stringCompression(String str) {
        int count = 1;
        StringBuilder sb = new StringBuilder("");
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i - 1) == str.charAt(i)) {
                count++;
            } else if (count == 1) {
                sb.append(str.charAt(i - 1));
            } else {
                sb.append(str.charAt(i - 1));
                sb.append(count);
                count = 1;
            }
        }

        if (count != 1) {
            sb.append(str.charAt(str.length() - 1)).append(count);
            sb.append(count);
        } else {
            sb.append(str.charAt(str.length() - 1));
        }
        System.out.print(sb.toString());
    }

    public static void main(String[] args) {
        // String str = "i love you so much and i miss you always";
        // String newStr = wordFirstLetterUppercase(str);
        // System.out.println(newStr);
        String str = "abbcccde";
        stringCompression(str);
        // String str = "madam";
        // palindrome(str);

        // System.out.println(str.length());
        // System.out.println("is palindrome: " + isPalindrome(str));
        // String directions = "WNEENESENNN";
        // String directions = "NS";
        // shortestPath(directions);

        // String s1 = "khokon";
        // String s2 = "khokon";
        // String s3 = new String("khokon");

        // if(s1 == s2){
        // System.out.println("string are equals");
        // }else{
        // System.out.println("string are not equals");
        // }

        // if(s1 == s3){
        // System.out.println("string are equals");
        // }else{
        // System.out.println("string are not equal");
        // }

        // System.out.println(s1.equals(s3));
        // System.out.println(s1.substring(0,3));

        // String fruits[] = { "apple", "mango", "banana" };
        // String largest = fruits[0];

        // for (int i = 1; i < fruits.length; i++) {
        // if (fruits[i].compareToIgnoreCase(largest) > 0) {
        // largest = fruits[i];
        // }
        // }
        // System.out.println("largest fruits: " + largest);
    }

    public static void palindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        boolean isPalindrome = true;
        while (left <= right) {
            if (str.charAt(left) != str.charAt(right)) {
                isPalindrome = false;
            }
            left++;
            right--;
        }
        if (isPalindrome) {
            System.out.println(str + " is palindrome");
        } else {
            System.out.println(str + " is not palindrome");
        }
    }

    public static boolean isPalindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static double shortestPath(String directions) {
        int x = 0;
        int y = 0;

        for (int i = 0; i < directions.length(); i++) {
            if (directions.charAt(i) == 'W') {
                x--;
            } else if (directions.charAt(i) == 'E') {
                x++;
            } else if (directions.charAt(i) == 'N') {
                y++;
            } else if (directions.charAt(i) == 'S') {
                y--;
            }
        }

        double path = Math.sqrt(Math.pow((x), 2) + Math.pow((y), 2));
        System.out.println(path);
        return path;
    }

}
