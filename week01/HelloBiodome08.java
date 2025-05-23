package week01;

import static java.util.Arrays.sort;

public class HelloBiodome08 {
    public static void main(String[] args) {
        String[] codex_kr = {"안녕하세요", "새로운", "나무를", "발견했습니다", "신속한", "지원", "감사합니다", "당신의", "도움이", "필요합니다"};
        // 단어 길이 순으로 내림차순 정렬 (긴 단어부터 먼저 찾기 위해)
        sort(codex_kr, (s1, s2) -> s2.length() - s1.length());

        // args를 하나의 문자열로 합침
        String input = String.join("", args);

        StringBuilder answer = new StringBuilder();

        int index = 0;
        while (index < input.length()) {
            boolean matched = false;
            for (String word : codex_kr) {
                // 현재 위치부터 word 길이만큼 자른 문자열과 비교
                if (index + word.length() <= input.length()) {
                    String sub = input.substring(index, index + word.length());
                    if (sub.equals(word)) {
                        answer.append(word).append(" ");
                        index += word.length();
                        matched = true;
                        break;  // 단어 찾았으면 다음 위치로 이동
                    }
                }
            }
            if (!matched) {
                // codex_kr에 없는 단어가 나오면 한 글자씩 넘기면서 처리
                answer.append(input.charAt(index));
                index++;
            }
        }
        if (answer.charAt(answer.length() - 1)!=('?'|'.')){
            answer.append('.');
        }
        System.out.println(answer.toString().trim());
    }
}
