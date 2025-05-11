package week01;

public class HelloBiodome06 {
    public static void main(String[] args) {
        double len1=0;
        int check=0;
        double len2=0;
        if (args.length == 2) {
            String V1 = args[0];
            String V2 = args[1];
            char[] arr_v1 = V1.toCharArray();
            char[] arr_v2 = V2.toCharArray();
            len1 = arr_v1.length;
            len2 = arr_v2.length;
            int i = 0;
            while (i < len1) {
                int j = 0;
                while (j < len2) {
                    if (arr_v1[i] == arr_v2[j]) {
                        check++;
                        break;
                    }
                    j++;
                }
                i++;
            }
        
        if (check != 0) {
            System.out.print("부분적으로 포함됩니다.");
        } else if ((len1 == len2) && (check == len1)) {

            System.out.print("동일한 유전자 코드입니다.");
        } else {
            System.out.print("일치하지 않습니다.");
        }}
        else{
            System.out.print("2개의 유전자 코드를 입력해주세요.");
        }
    }
}
