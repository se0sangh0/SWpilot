package week02;

import java.util.Objects;

public class RoadToBiodome07 {
    public static void main(String[] args) {
        int n = args.length;
        String[] arr = new String[n];
        String[] count = new String[n];
        int[] cntArr = new int[n];
        for (int i = 0; i < n; i++) {
            if (args[i].matches("\\d+")) {
                System.out.println("숫자는 입력받지 않습니다..");
                return;
            }
            arr[i] = args[i];
            count[i] = arr[i];
            cntArr[i] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (Objects.equals(arr[i], arr[j])) {
                    cntArr[i]++;
                    arr[j] = "";
                }
            }
            if (!arr[i].isEmpty()) count[i] = count[i] + cntArr[i];
            else count[i] = "";
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int numI = cnt_Number(count[i]);
                int numJ = cnt_Number(count[j]);
                if (numI < numJ) {
                    String temp = count[i];
                    count[i] = count[j];
                    count[j] = temp;
                }
            }
        }
        for (String s : count) {
            if (!s.isEmpty()) System.out.print(cnt_lWord(s)+" ");
        }
    }

    public static int cnt_Number(String s) {
        String number = s.replaceAll("[^\\d]", "");
        if (number.isEmpty()) return 0;
        return Integer.parseInt(number);
    }

    public static String cnt_lWord(String s) {
        return s.replaceAll("\\d", "");
    }
}
