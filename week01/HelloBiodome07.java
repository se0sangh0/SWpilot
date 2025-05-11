package week01;

import java.util.regex.*;




public class HelloBiodome07 {
    public static void main(String[] args) {
        String Vio = String.join("", args);
        Vio = Vio.toUpperCase();
        Pattern pattern = Pattern.compile(".*(A|B|D|F|G|I|K|L|M|N|O|P|Q|R|S|T|U|V|W|X|Z).*");
        String temp_count = "";
        char[]ch=Vio.toCharArray();
        if (pattern.matcher(Vio).find()) {
            System.out.print("염기서열은 C, J, H, E, Y 다섯가지로만 입력됩니다. 확인하고 다시 입력해주세요");
        }
        else if(ch.length>0){
            for(int i =0;i<Vio.length();i++){
                for(int j=i+1;j<Vio.length();j++){
                    if (ch[i]==ch[j]){
                        temp_count=temp_count+ch[j];
                        int cnt=0;
                        for (int k=0;k<temp_count.length();k++){
                            char temp = temp_count.charAt(k);
                            if (temp==ch[j]){
                                cnt++;
                            }
                            temp_count=temp_count+cnt;}
                        }
                    break;
               }
            }
            System.out.print(temp_count);
        }
    }
}