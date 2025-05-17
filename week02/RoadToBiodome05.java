package week02;

import java.util.Arrays;

public class RoadToBiodome05 {
    public static void main(String[] args) {
        try{
            int []arr=ParseIntArray(args);
            for (int n : arr) {
                if (n < 0 || n > 100) {
                    System.out.println("잘못된 입력입니다. 0~100 사이의 숫자를 입력하세요");
                    return;
                }
            }
            quickSort(arr);
            System.out.println(Arrays.toString(arr));
        }catch (NumberFormatException e) {
            System.out.println("잘못된 입력입니다. 숫자를 입력하세요");
        }

    }

    private static int[] ParseIntArray(String[] args) {
        StringBuilder sb = new StringBuilder();
        for(String s : args){
            sb.append(s).append(" ");
        }
        String fitter = sb.toString().replaceAll("[,\\[\\]\\s]+", " ").trim();
        String []temp_arr = fitter.split(" ");
        int[]result=new int[temp_arr.length];
        for(int i=0;i<temp_arr.length;i++){
            result[i]=Integer.parseInt(temp_arr[i]);
        }
        return result;
    }

    public static void quickSort(int[] arr){
        int stackSize=arr.length;
        int[] stack=new int[stackSize*2];
        int top=-1;
        stack[++top]=0;
        stack[++top]=stackSize-1;
        for (; top >= 0;) {
            int hi = stack[top--];
            int lo = stack[top--];
            if (lo >= hi) continue;
            int piv_idx = partition(arr, lo, hi);
            if (piv_idx + 1 < hi) {
                stack[++top] = piv_idx + 1;
                stack[++top] = hi;
            }
            if (piv_idx - 1 > lo) {
                stack[++top] = lo;
                stack[++top] = piv_idx - 1;
            }
        }
    }
    private static int partition(int[] arr, int lo, int hi) {
        int piv = arr[hi];
        int idx = lo - 1;
        for (int i = lo; i < hi; i++) {
            if (arr[i] <= piv) {
                idx++;
                swap(arr, i, idx);
            }
        }
        swap(arr, idx + 1, hi);  // 꼭 필요!
        return idx + 1;
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
