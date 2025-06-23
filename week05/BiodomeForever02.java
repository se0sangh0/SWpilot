package week05;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class BiodomeForever02 {

    private static final DateTimeFormatter SRC_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
    private static final DateTimeFormatter TARGET_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private static final String BASE_DIRECTORY = "D:\\SWpilot\\week05\\";

    public static void main(String[] args) {
        // 1. 입력 인자 유효성 검사
        if (!isValidArgs(args)) {
            return;
        }
        String fullFileName = args[0];
        try {// 2. 파일 이름에서 날짜 문자열 추출
            String dateString = extractDateString(fullFileName);
            if (dateString == null) { // 추출 실패 시 종료
                return;
            }
            // 3. 날짜 문자열 형식 변환 및 출력
            String convertedDate = convertAndPrintDate(dateString);
            if (convertedDate == null) { // 변환 실패 시 종료
                return;
            }
            // 4. 파일 내용 처리 (setting 및 print)
            processFileContent(fullFileName);
        } catch (Exception e) {
            handleException(e);
        }
    }

    private static boolean isValidArgs(String[] args) {
        if (args.length == 0) {
            System.err.println("사용법: java BiodomeForever02 <파일이름>");
            return false;
        }
        return true;
    }

    private static String extractDateString(String fullFileName) {
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
        if (dateStringFromFile.length() != 12) {
            System.err.println("추출된 날짜 문자열의 길이가 올바르지 않습니다: " + dateStringFromFile + ". (기대값: 12자리)");
            return null;
        }
        return dateStringFromFile;
    }

    private static String convertAndPrintDate(String dateString) {
        try {
            LocalDateTime dateTime = LocalDateTime.parse(dateString, SRC_FORMATTER);
            String convertedDateString = dateTime.format(TARGET_FORMATTER);
            System.out.print(convertedDateString);
            return convertedDateString;
        } catch (DateTimeParseException e) {
            System.err.println("날짜 문자열 파싱 오류: " + dateString + " -> " + e.getMessage());
            return null;
        }
    }

    private static void processFileContent(String fullFileName) throws IOException {
        String absoluteFilePath = BASE_DIRECTORY + fullFileName;
        setting(absoluteFilePath);
    }

    public static void setting(String directory) throws IOException {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(directory), StandardCharsets.UTF_8
                ))) {
            print(reader);
        }
    }

    public static void print(BufferedReader reader) throws IOException {
        BiodomeForever01.print(reader);
    }

    private static void handleException(Exception e) {
        if (e instanceof IOException) {
            System.err.println("파일 처리 중 오류가 발생했습니다: " + e.getMessage());
        } else if (e instanceof DateTimeParseException) {
            System.err.println("날짜 파싱 중 오류가 발생했습니다. 입력 형식을 확인해주세요: " + e.getMessage());
        } else {
            System.err.println("예기치 않은 오류가 발생했습니다: " + e.getMessage());
        }
        e.printStackTrace();
    }
}