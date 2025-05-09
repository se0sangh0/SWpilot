package week01;

public class HelloBiodome04 {
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
                        if (check_n1(n1)&check_n2(n2)&check_n3(n3)){
                            System.out.printf("생명의 나무는 안정적인 상태입니다. 건강지수는 %.2f 입니다.",H);
                        }
                        else{
                            if (!check_n1(n1)&check_n2(n2)&check_n3(n3)){
                                System.out.print("온도값이 정상 범위를 벗어났습니다. 확인이 필요합니다.");
                            } else if (check_n1(n1)&!check_n2(n2)&check_n3(n3)) {
                                System.out.print("습도값이 정상 범위를 벗어났습니다. 확인이 필요합니다.");
                            } else if (check_n1(n1)&check_n2(n2)&!check_n3(n3)) {
                                System.out.print("산소농도값이 정상 범위를 벗어났습니다. 확인이 필요합니다.");
                            } else if (!check_n1(n1)&!check_n2(n2)&check_n3(n3)) {
                                System.out.print("온도, 습도값이 정상 범위를 벗어났습니다. 확인이 필요합니다.");
                            } else if (!check_n1(n1)&check_n2(n2)&!check_n3(n3)) {
                                System.out.print("온도, 산소농도값이 정상 범위를 벗어났습니다. 확인이 필요합니다.");
                            }
                            else if(check_n1(n1)&!check_n2(n2)&!check_n3(n3)){
                                System.out.print("습도, 산소농도값이 정상 범위를 벗어났습니다. 확인이 필요합니다.");
                            }
                            else{
                                System.out.print("""
                                        입력값 범위를 확인하세요 온도 : 10° 이상 27.5°C 미만
                                        
                                        습도 : 40% 초과 60% 미만
                                        
                                        산소 농도 : 19.5% 이상 23.5% 이하""");
                            }
                        }
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
        return HelloBiodome03.root(n2);
    }
    public static double av(double n1,double root_n2){
        return HelloBiodome03.av(n1, root_n2);
    }
    public static double healthTree(double av,double n3){
        return B*av+(n3/(pi*pi));
    }
    public static boolean check_n1(double n1){
        return n1 >= 10 && n1 < 27.5;
    }
    public static boolean check_n2(double n2){
        return n2 > 40 && n2 <60;
    }
    public static boolean check_n3(double n3){
        return n3 >= 19.5 && n3 <= 23.5;
    }
}
