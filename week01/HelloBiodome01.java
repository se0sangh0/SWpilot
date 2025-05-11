package week01;

public class HelloBiodome01 {
    public static void main(String[] args) {
         if (args.length>0){
             String name = String.join(" ", args);
             System.out.printf("안녕하세요. %s님 환영합니다.",name);
        }
        else {
            System.out.println("재입력하세요");
        }

    }
}

