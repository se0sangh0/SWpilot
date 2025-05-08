package week01;

public class HelloBiodome02 {
    public static void main(String[] args) {
        if (args.length==3){
            double n1 = Integer.parseInt(args[0]);
            double n2 = Integer.parseInt(args[1]);
            double n3 = Integer.parseInt(args[2]);
            if (n1<0|n2<0|n3<0){
                System.out.println("입력값을 확인하세요");
            }
            else{System.out.println(n1+" "+n2+" "+n3);
                final double sum = n1+n2+n3;
                double sun = (n1/sum)*100;
                double wind = (n2/sum)*100;
                double gP = (n3/sum)*100;
                System.out.println("총 에너지 사용량은 "+sum+"입니다.");
                System.out.println("태양광 "+sun+"%, 풍력 "+wind+"%, 지열"+gP+"%");}

        }
        else {
            System.out.println("입력값을 확인하세요");
        }

    }
}
