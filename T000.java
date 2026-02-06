public class T000 {
    static boolean isMagic(int[] p) {
        return p[0] + p[1] + p[2] == 15 &&
                p[3] + p[4] + p[5] == 15 &&
                p[6] + p[7] + p[8] == 15 &&
                p[0] + p[3] + p[6] == 15 &&
                p[1] + p[4] + p[7] == 15 &&
                p[2] + p[5] + p[8] == 15 &&
                p[0] + p[4] + p[8] == 15 &&
                p[2] + p[4] + p[6] == 15;        }
    static void permute(int[] arr, int l) {
        if (l == arr.length) {
            if (isMagic(arr)) {
                for (int i = 0; i < 9; i++) {
                    System.out.print(arr[i] + " ");
                    if (i % 3 == 2) System.out.println();       }
                System.exit(0);     }       }
        for (int i = l; i < arr.length; i++) {
            int temp = arr[l];
            arr[l] = arr[i];
            arr[i] = temp;
            permute(arr, l + 1);
            temp = arr[l];
            arr[l] = arr[i];
            arr[i] = temp;      }       }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        permute(nums, 0);       }       }