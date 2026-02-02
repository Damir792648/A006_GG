public class SecurityVault {

    static String SECRET_CODE = "4321";
    static int attempt = 0;

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4};
        permute(numbers, 0);
    }

    static void permute(int[] arr, int index) {
        if (index == arr.length) {
            checkCode(arr);
            return;
        }

        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            permute(arr, index + 1);
            swap(arr, index, i);
        }
    }

    static void checkCode(int[] arr) {
        attempt++;

        try {
            Thread.sleep(100); // Security Delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        StringBuilder code = new StringBuilder();
        for (int num : arr) {
            code.append(num);
        }

        if (code.toString().equals(SECRET_CODE)) {
            System.out.println(
                    "Attempt " + attempt + ":  " +
                            java.util.Arrays.toString(arr) +
                            "CORRECT (100ms delay)"
            );
            System.exit(0);
        } else {
            System.out.println(
                    "Attempt " + attempt + ":  " +
                            java.util.Arrays.toString(arr) +
                            "WRONG (100ms delay)"
            );
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
