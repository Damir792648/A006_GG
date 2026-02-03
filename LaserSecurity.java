import java.util.Arrays;

public class LaserSecurity {

    static int run = 0;
    static int[] bestMatch = null;
    static int bestGravityDiff = Integer.MAX_VALUE;

    public static void main(String[] args) {

        int[] blocks = {1, 2, 3, 4, 5, 6};

        permute(blocks, 0);

        System.out.println("\n<");
        System.out.println("LASERS DEACTIVATED");
        System.out.println("FINAL KEY: " + Arrays.toString(bestMatch));
        System.out.println("Gravity difference: " + bestGravityDiff);
    }

    static void permute(int[] arr, int index) {
        if (index == arr.length) {
            evaluate(arr);
            return;
        }

        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            permute(arr, index + 1);
            swap(arr, index, i);
        }
    }

    static void evaluate(int[] arr) {
        run++;

        boolean gravity = checkGravity(arr);
        boolean connection = checkConnection(arr);
        boolean prime = checkPrime(arr);

        if (!gravity) {
            System.out.println(
                    "Run " + run + ": " + Arrays.toString(arr) +
                            " -> FAIL: Gravity (" +
                            (arr[0]+arr[1]+arr[2]) + " != " +
                            (arr[3]+arr[4]+arr[5]) + ")"
            );
        }
        else if (!connection) {
            System.out.println(
                    "Run " + run + ": " + Arrays.toString(arr) +
                            " -> FAIL: Connection (consecutive numbers touching)"
            );
        }
        else if (!prime) {
            System.out.println(
                    "Run " + run + ": " + Arrays.toString(arr) +
                            " -> TWO RULES PASSED! (Gravity & Connection)\n" +
                            "FAIL: Prime (Rule 3 requires BOTH 3rd & 4th to be prime)"
            );
        }
        else {
            System.out.println(
                    "Run " + run + ": " + Arrays.toString(arr) +
                            " -> SUCCESS: ALL RULES PASSED!"
            );
        }

        // Track closest gravity match
        int diff = Math.abs(
                (arr[0]+arr[1]+arr[2]) -
                        (arr[3]+arr[4]+arr[5])
        );

        if (diff < bestGravityDiff && connection && prime) {
            bestGravityDiff = diff;
            bestMatch = arr.clone();
        }
    }

    static boolean checkGravity(int[] a) {
        return (a[0] + a[1] + a[2]) ==
                (a[3] + a[4] + a[5]);
    }

    static boolean checkConnection(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (Math.abs(a[i] - a[i + 1]) == 1) {
                return false;
            }
        }
        return true;
    }

    static boolean checkPrime(int[] a) {
        return isPrime(a[2]) && isPrime(a[3]);
    }

    static boolean isPrime(int n) {
        return n == 2 || n == 3 || n == 5;
    }

    static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}

