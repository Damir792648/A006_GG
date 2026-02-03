import java.util.Arrays;

public class CinemaSeating {

    static int runCount = 0;
    static int safeCount = 0;
    static int argumentCount = 0;

    public static void main(String[] args) {

        int[] people = {1, 2, 3, 4};

        System.out.println("Scanning movie theater seating arrangements...");
        System.out.println("----------------------------------------------");

        permute(people, 0);

        System.out.println("----------------------------------------------");
        System.out.println("SEARCH COMPLETE:");
        System.out.println("Total possible arrangements: " + runCount);
        System.out.println("Total safe arrangements: " + safeCount);
        System.out.println("Total arguments prevented: " + safeCount);
    }

    static void permute(int[] arr, int index) {
        if (index == arr.length) {
            checkArrangement(arr);
            return;
        }

        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            permute(arr, index + 1);
            swap(arr, index, i);
        }
    }

    static void checkArrangement(int[] arr) {
        runCount++;

        int posAlice = -1;
        int posBob = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) posAlice = i;
            if (arr[i] == 2) posBob = i;
        }

        if (Math.abs(posAlice - posBob) == 1) {
            argumentCount++;
            System.out.println(
                    "Run " + runCount + ": " +
                            Arrays.toString(arr) +
                            " -> ARGUMENT! (Alice & Bob next to each other)"
            );
        } else {
            safeCount++;
            System.out.println(
                    "Run " + runCount + ": " +
                            Arrays.toString(arr) +
                            " -> SAFE (Alice & Bob separated)"
            );
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
