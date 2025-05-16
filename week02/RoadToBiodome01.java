package week02;

import java.util.Arrays;

public class RoadToBiodome01 {
    public static void main(String[] args) {
        int n = args.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(args[i].replace(",", ""));
        }
        Arrays.sort(arr);

        int result = 0;
        for (int i = 0; i < n; ) {
            int count = 1;
            while (i + count < n && arr[i] == arr[i + count]) {
                count++;
            }
            if (count == 1) {
                result ^= arr[i];
            }
            i += count;
        }
        System.out.println(result);
    }
}
