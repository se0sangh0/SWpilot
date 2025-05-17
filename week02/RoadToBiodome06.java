package week02;

import java.util.ArrayList;
import java.util.Arrays;

public class RoadToBiodome06 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("입력값이 없습니다.");
            return;
        }

        String input = args[0];
        String[] parts = input.split("A");

        if (parts.length != 2) {
            System.out.println("A 구분자가 정확히 한 번 포함되어야 합니다.");
            return;
        }

        // 첫 번째 부분 숫자 배열 생성 (',' 기준으로)
        ArrayList<Integer> arr = new ArrayList<>();
        for (String s : parts[0].split(",")) {
            int num = Integer.parseInt(s);
            if (num > 30) arr.add(num);
        }

        // 두 번째 부분 숫자 배열 생성 (',' 기준으로)
        ArrayList<Integer> arr2 = new ArrayList<>();
        for (String s : parts[1].split(",")) {
            int num = Integer.parseInt(s);
            if (num > 30) arr2.add(num);
        }

        // 정렬
        arr.sort(Integer::compareTo);
        arr2.sort(Integer::compareTo);

        // 합계
        int sum_arr = arr.stream().mapToInt(Integer::intValue).sum();
        int sum_arr2 = arr2.stream().mapToInt(Integer::intValue).sum();

        // 전체 평균
        int totalSize = arr.size() + arr2.size();
        double arr_mean = (totalSize == 0) ? 0.0 : (double) (sum_arr + sum_arr2) / totalSize;

        // 투포인터로 Median 찾기
        int i = 0, j = 0;
        int mid1 = -1, mid2 = -1;
        for (int count = 0; count <= totalSize / 2; count++) {
            mid1 = mid2;
            if (i < arr.size() && (j >= arr2.size() || arr.get(i) <= arr2.get(j))) {
                mid2 = arr.get(i++);
            } else {
                mid2 = arr2.get(j++);
            }
        }

        double median = (totalSize % 2 == 1) ? mid2 : (mid1 + mid2) / 2.0;

        // 결과 출력
        System.out.printf("Mean : %.2f, Median : %.2f\n", arr_mean, median);
    }
}
