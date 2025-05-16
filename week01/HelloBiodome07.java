package week01;

import java.util.regex.*;




public class HelloBiodome07 {
    public static void main(String[] args) {
        String Vio = String.join("", args);
        Vio = Vio.toUpperCase();
        Pattern pattern = Pattern.compile(".*(A|B|D|F|G|I|K|L|M|N|O|P|Q|R|S|T|U|V|W|X|Z).*");
        char[] ch = Vio.toCharArray();
        if (pattern.matcher(Vio).find()) {
            System.out.print("염기서열은 C, J, H, E, Y 다섯가지로만 입력됩니다. 확인하고 다시 입력해주세요");
        } else if (ch.length > 0) {
            char[] res;
            res=check(ch);
            System.out.println(res);
        }
    }
    public static char[] check(char[] ch) {
        boolean[] vis = new boolean[ch.length];
        char[] result = new char[ch.length * 2];
        int idx = 0;
        for (int i = 0; i < ch.length; i++) {
            if (vis[i]) continue;
            char c = ch[i];
            int count = 1;
            for (int j = i + 1; j < ch.length; j++) {
                if (c == ch[j]) {
                    count++;
                    vis[j] = true;
                }
            }
            result[idx++] = c;
            result[idx++] = (char)(count + '0');
        }
        char[] res = new char[idx];
        System.arraycopy(result, 0, res, 0, idx);
        return res;
    }

}