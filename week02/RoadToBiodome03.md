보고서 제목 시간복잡도 계산

작성자명 서상호

목차

시간 복잡도의 정의와 필요성

Big O 표기법의 개념과 상황별 예시

문제01 코드의 시간 복잡도 분석

문제02 코드의 시간 복잡도 분석

병목 현상 분석 및 최적화 방안




시간 복잡도의 정의와 필요성

시간복잡도란 ? 함수의 실행 시간을 표현한것
필요성 : 같은 결과물을 얻어내는데 최소한의 자원을 얻을 수 있는 알고리즘의 성능을 설명하는 것

Big O 표기법의 개념과 상황별 예시
BIG O 표기법이란? 해당 알고리즘 동작에 최악의 경우를 기반으로 계산하여 평균치를 예측하는 방법
주요 예시 :
1. O(1) : 스택에서 Push, Pop
2. O(log n) : 이진트리
3. O(n) : for 문
4. O(n log n) : 퀵 정렬(quick sort), 병합정렬(merge sort), 힙 정렬(heap Sort)
5. O(): 이중 for 문, 삽입정렬(insertion sort), 거품정렬(bubble sort), 선택정렬(selection sort)
6. O() : 피보나치 수열
   출처: https://noahlogs.tistory.com/27 [지푸라기 개발자:티스토리]

문제01 코드의 시간 복잡도 분석
입력 처리: O(n) =>
입력 변환 (for 루프)
for (int i = 0; i < n; i++) {
arr[i] = Integer.parseInt(args[i].replace(",", ""));}
n개의 문자열을 숫자로 변환.
각 문자열에 대해 replace(",", "") → O(L) (L은 문자열 길이, 일반적으로 제한적이라 O(1)로 간주 가능).
총 시간 복잡도: O(n)

정렬: O(n log n) =>
Arrays.sort(arr);
Arrays.sort()는 Dual-Pivot QuickSort (int 배열일 경우).
시간 복잡도: O(n log n)

XOR 및 중복 체크: O(n) =>
for (int i = 0; i < n; ) {
int count = 1;
while (i + count < n && arr[i] == arr[i + count]) {
count++;}
if (count == 1)
result ^= arr[i];
i += count;
}
while 루프는 정렬된 배열에서 중복된 값을 한번에 처리.
전체 i는 n까지 증가.
실질적으로 O(n) (한 번씩만 체크하기 때문).
시간 복잡도: O(n)

따라서 총 시간 복잡도: O(n log n)

문제02 코드의 시간 복잡도 분석

입력 처리: O(n)  = >
입력부 : String text = String.join(" ", args);
args를 " "(공백)으로 연결.
시간 복잡도: O(n) (n은 args 전체 문자열의 길이 합)
검증부 : if (text.isBlank())
문자열이 비어있거나 공백만 있는 경우 체크.
시간 복잡도: O(n)
스택 사용 : O(n) =>
stack stack = new stack();
for (char c : text.toCharArray())
stack.push(c);
while (!stack.isEmpty())
System.out.print(stack.pop());
push: O(n) (ArrayList의 add는 amortized O(1))
pop: O(n) (remove(size - 1)는 O(1))
시간복잡도 :  O(n)

병목 현상 분석 및 최적화 방안
Q1 = 정렬과정에서 사용하는 Arrays.sort는 삽입 정렬 방식으로 O(n log n)의 시간 복잡도를 가지고 있음
이를 HashMap 라이브러리를 사용하여 처리하게 될 경우 정렬을 거치지 않기 때문에 O(n)의 시간복잡도를 가지도록 개선이 가능함(제약사항으로 인하여 실 적용 x)
Q2 = O(n) 이기에 없음