package week01;

public class HelloBiodome09 {
    public static void main(String[] args) {
        if (args[0].matches("\\d+")){
            int step=Integer.parseInt(args[0]);
            System.out.println();
            for (int i=1;i<=step;i++){
                for (int j=0;j<step-i;j++){
                    System.out.print(" ");
                }
                for (int j=0;j<2*i-1;j++){
                    if (j==i-1){
                        System.out.print(args[1]);
                    }
                    else {
                        System.out.print("*");
                    }

                }
                if (i == step){
                    System.out.println();
                    for(int k=0;k<step;k++){
                        if(k==step-1){
                            System.out.print("|");
                        }
                        else{
                            System.out.print(" ");
                        }
                    }
                }

                else {
                    System.out.println();
                }
            }
        }
        else{
            System.out.println("잘못된 입력입니다.");

    }
}
}
