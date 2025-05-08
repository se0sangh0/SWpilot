package week01;

public class HelloBiodome03 {
    static final double pi = 3.14;
    static final double B = 0.415;
    public static void main(String[] args) {
        if (args.length==3){
            if (args[0].matches("\\d+(\\.\\d+)?") &&
                    args[1].matches("\\d+(\\.\\d+)?") &&
                    args[2].matches("\\d+(\\.\\d+)?")){
                double n1 = Double.parseDouble(args[0]);
                double n2 = Double.parseDouble(args[1]);
                double n3 = Double.parseDouble(args[2]);

                double root_n2 = root(n2);
            double av = av(n1, root_n2);
            double H = healthTree(av, n3);
            System.out.printf("생명지수 H = %.3f",H);
        }
            else{
                System.out.println("입력된 값이 올바르지 않습니다. [온도][습도][산소농도] 순서 대로 숫자 값을 입력해주세요");
            }
    }
        else{
            System.out.println("입력된 값이 올바르지 않습니다. [온도][습도][산소농도] 순서 대로 숫자 값을 입력해주세요");
        }
    }

    public static double root(double n2){
        double root_n2 = n2/2.0;
        for(int i=0;i<20;i++){
            root_n2=(root_n2+n2/root_n2)/2.0;
            }
        return root_n2;
    }
    public static double av(double n1,double root_n2){
        double av = root_n2-n1;
        return av>0?av:-av;
    }
    public static double healthTree(double av,double n3){
        return B*av+(n3/(pi*pi));
    }
}
