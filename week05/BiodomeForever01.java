package week05;

import java.io.*;
import java.nio.charset.Charset;

public class BiodomeForever01 {
    public static void main(String[] args) throws IOException{
        String file_name = args[0];
        String temp = "D:\\SWpilot\\week05\\";
        String directory=temp+file_name;
        setting(directory);
    }
    public static void setting(String directory) throws IOException {
        BufferedReader reader=null;

         try{
             reader = new BufferedReader(
                     new InputStreamReader(
                             new FileInputStream(directory),
                             Charset.forName("UTF-8")
                     )
             );

             print(reader);
         }
         catch (FileNotFoundException e) {
             System.out.println("존재하지 않는 파일입니다. 파일 이름을 다시 확인해주세요.");
         } catch (IOException e) {
             System.out.println("파일을 읽는 도중 오류 발생: " + e.getMessage());
        }
         finally{
             if(reader!=null)
                 reader.close();
        }

     }
     public static void print(BufferedReader reader) throws IOException {
        int ch;
        while((ch=reader.read())!=-1){
            System.out.print((char)ch);
         }
     }
}
