package week01;

public class HelloBiodome05 {
    public static void main(String[] args) {
        int[] result = find();  // find의 결과를 받아서
        int res = 0;

        if (result != null) {
            int g = result[0];
            int h = result[1];
            res = res(g, h);
        }
        System.out.println(res);
    }

    public static int[] find() {
        for (int g = 0; g < 16; g++) {
            for (int h = 0; h < 16; h++) {
                int Q1 = g & 1 >> g << 2 | h + g ^ h;
                int Q2 = g % 2 << h >> g | 1 & 0 ^ 0;
                if (Q1 == 1 && Q2 == 2) {
                    return new int[]{g,h};
                }
            }
        }
        return null;
    }
    public static int res(int g, int h){
        int res=(h*h+g)*(h<<h)+(g<<g);
        return res;
    }
}

