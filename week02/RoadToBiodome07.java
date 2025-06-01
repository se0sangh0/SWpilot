package week02;

import java.util.*;

public class RoadToBiodome07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        input=input.replaceAll("[^가-힣,]", "");
        String[] arr = input.split(",");
        Map<String, Integer> freq = new HashMap<>();
        counting(arr,freq);
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(freq.entrySet());
        sort(entryList);
        print(entryList);
        sc.close();
        }


    public static void sort(List<Map.Entry<String, Integer>> entryList) {
        int n = entryList.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                // 두 Map.Entry 객체 비교 로직
                // compareEntries 메서드를 통해 커스텀 정렬 기준을 적용
                if (compare(entryList.get(j), entryList.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            // 가장 "작은" (즉, 가장 높은 우선순위) 요소를 찾았으면 현재 위치(i)와 교환
            Map.Entry<String, Integer> temp = entryList.get(i);
            entryList.set(i, entryList.get(minIndex));
            entryList.set(minIndex, temp);
        }
    }
    public static int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
       int freqcompare=e2.getValue().compareTo(e1.getValue());
       if(freqcompare==0){
           return e1.getKey().compareTo(e2.getKey());
       }
       else{
           return freqcompare;
       }
    }
    public static void counting(String[] arr,Map<String,Integer> freq){
        for (String s : arr) {
            s = s.trim(); // 혹시 모를 공백 제거
            if (!s.isEmpty()) { // 빈 문자열은 스킵
                freq.put(s, freq.getOrDefault(s, 0) + 1);
            }
        }
    }
    public static void print(List<Map.Entry<String, Integer>> entryList) {
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : entryList) {
            result.add(entry.getKey());
        }
        System.out.println(String.join(",", result));
    }
}

