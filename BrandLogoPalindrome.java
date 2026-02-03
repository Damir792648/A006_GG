import java.util.*;

public class BrandLogoPalindrome {

    static int run = 0;
    static int palindromeCount = 0;
    static Set<String> uniquePalindromes = new LinkedHashSet<>();

    public static void main(String[] args) {

        char[] symbols = {'*', '*', '*', '.', '.', '.'};

        System.out.println("Generating brand logo patterns...");
        permute(symbols, 0);

        System.out.println("DESIGN REPORT:");
        System.out.println("Total permutations checked: " + run);
        System.out.println("Total palindrome designs found: " + palindromeCount);
        System.out.println("Unique symmetrical layouts: " + uniquePalindromes.size());
        System.out.println(uniquePalindromes);
    }

    static void permute(char[] arr, int index) {
        if (index == arr.length) {
            checkPattern(arr);
            return;
        }

        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            permute(arr, index + 1);
            swap(arr, index, i);
        }
    }

    static void checkPattern(char[] arr) {
        run++;

        String pattern = new String(arr);

        if (isPalindrome(pattern)) {
            palindromeCount++;
            uniquePalindromes.add(pattern);
            System.out.println(
                    "Run " + run + ": " + pattern +
                            " [!] MATCH: PALINDROME FOUND!"
            );
        } else {
            System.out.println(
                    "Run " + run + ": " + pattern +
                            " [X] ASYMMETRIC"
            );
        }
    }

    static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}