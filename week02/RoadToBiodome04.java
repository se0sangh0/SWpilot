package week02;

public class RoadToBiodome04 {
    public static void main(String[] args) {
        int n = args.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(args[i].replace(", ", ""));
        }
        for(int i=0 ; i<arr.length ; i++){

            int idx = i;
            int tmp;

            for(int j=i+1 ; j<arr.length ; j++){
                if(arr[idx] > arr[j]) idx = j;
            }

            tmp = arr[idx];
            arr[idx] = arr[i];
            arr[i] = tmp;
        }
        double avg = 0;
        for (int i=0;i<n;i++){
            avg+=arr[i];}
        avg/=n;
        double arr1= (double) (arr[n / 2] + arr[n / 2 - 1]) /2;
        double arr2=arr[n/2];
        if (n%2==0)
            System.out.printf("평균값 : %.2f 중앙값 : %.2f",avg,arr1);
        else
            System.out.printf("평균값 : %.2f 중앙값 : %.2f",avg,arr2);
    }
}
