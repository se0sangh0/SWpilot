package week05;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class BiodomeForever02 {
    public static void main(String[] args) {
        DateTimeFormatter srcFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
        DateTimeFormatter targetFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        try {
            if (args.length == 0) {
                return;
            }
            String fullFileName = args[0];
            String dateStringFromFile;
            int separatorIndex = -1;

            if (fullFileName.contains("_")) {
                separatorIndex = fullFileName.indexOf('_');
            } else if (fullFileName.contains(".")) {
                separatorIndex = fullFileName.indexOf('.');
            }

            if (separatorIndex != -1) {
                dateStringFromFile = fullFileName.substring(0, separatorIndex);
            } else {
                dateStringFromFile = fullFileName;
            }

            // 추출된 날짜 문자열이 올바른 길이인지 간단히 확인
            if (dateStringFromFile.length() != 12) {
                System.err.println("추출된 값: " + dateStringFromFile);
                return;
            }

            // 3. 추출된 날짜 문자열을 LocalDateTime 객체로 파싱
            LocalDateTime dateTime = LocalDateTime.parse(dateStringFromFile, srcFormatter);

            // 4. LocalDateTime 객체를 원하는 형식으로 포맷팅
            String convertedDateString = dateTime.format(targetFormatter);

            // 5. 출력 순서에 맞춰 출력
            System.out.print(convertedDateString);

            // 6. setting 메서드를 호출하여 파일 내용 출력
            String baseDirectory = "D:\\SWpilot\\week05\\";
            String absoluteFilePath = baseDirectory + fullFileName;
            setting(absoluteFilePath);

        } catch (ArrayIndexOutOfBoundsException | DateTimeParseException | IOException e) {
            e.printStackTrace();
        } catch (Exception e) { // 그 외 예상치 못한 모든 예외
            e.printStackTrace();
        }
    }

    public static void setting(String directory) throws IOException {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(directory),
                            StandardCharsets.UTF_8
                    )
            );
            print(reader);
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    public static void print(BufferedReader reader) throws IOException {
        int ch;
        while ((ch = reader.read()) != -1) {
            System.out.print((char) ch);
        }
    }
}