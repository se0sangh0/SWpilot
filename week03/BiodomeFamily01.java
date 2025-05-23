package week03;

import java.util.*;

public class BiodomeFamily01 {

    static Scanner sc = new Scanner(System.in);
    private static List<String[]> list_animal = new ArrayList<>();
    private static List<String[]> list_plant = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
        System.out.println("메뉴를 선택하세요 1 : 입력하기 2 : 수정하기, 3: 삭제하기 4: 출력하기 5: 검색하기 6: 종료하기");
        int menu = sc.nextInt();
        sc.nextLine(); // 개행 문자 제거
        switch (menu){
            case 1:
                System.out.println("1번 메뉴 선택");
                insert();
                break;
            case 2:
                System.out.println("2번 메뉴 선택");
                update();
                break;
                case 3:
                System.out.println("3번 메뉴 선택");
                delete();
                    break;
            case 4:
                System.out.println("4번 메뉴 선택");
                print();
                break;
                case 5:
                System.out.println("5번 메뉴 선택");
                search();
                    break;
            case 6:
                System.out.println("종료하기");
                return;
                default:
                System.out.println("잘못된 메뉴입니다. 다시 입력해주세요.");

        }
    }
    }


    public static void insert() {
        Scanner sc = new Scanner(System.in);
        System.out.println("4가지 동식물 정보를 입력하세요 (이름,분류(동물/식물),사는곳)");
        String[][] infoArray = new String[4][3]; // 4개의 생물 정보, 각각 이름/분류/사는곳
        for (int i = 0; i < 4; i++) {
            System.out.print((i + 1) + "번째 입력: ");
            String input = sc.nextLine();
            String[] split = input.split(",");
            if (split.length != 3) {
                System.out.println("입력 형식이 잘못되었습니다. (예: 고양이,동물,도시) 다시 입력해주세요.");
                i--; // 다시 입력 받기 위해 인덱스 유지
                continue;
            }
            if (!(split[1].trim().equals("동물") || split[1].trim().equals("식물"))) {
                System.out.println("잘못된 값이 입력되었습니다 (분류는 '동물' 또는 '식물'이어야 합니다)");
                i--; // 다시 입력 받기 위해 인덱스 유지
                continue;
            }
            infoArray[i] = split;
        }
        save(infoArray); // 2차원 배열 통째로 전달
    }


    public static void save(String[][] infoArray) {
        for (String[] info : infoArray) {
            String type = info[1].trim(); // 분류
            if (type.equals("동물")) list_animal.add(info);
            else list_plant.add(info);
        }
    }

    public static void print() {
        System.out.println("\n[객체 정보 보기]");
        if (list_animal.isEmpty()||list_plant.isEmpty()) {
            System.out.println("등록된 정보가 없습니다.");
            return;
        }
        System.out.println("동물 정보");
        for (String[] info : list_animal) {
            System.out.println("이름: " + info[0].trim() + ", 사는곳: " + info[2].trim());
        }
        System.out.println("식물 정보");
        for (String[] info : list_plant) {
            System.out.println("이름: " + info[0].trim() + ", 사는곳: " + info[2].trim());
        }
    }


    public static void update() {
        System.out.print("수정할 분류를 입력하세요 (동물/식물): ");
        String category = sc.nextLine().trim();
        if (!category.equals("동물") && !category.equals("식물")) {
            System.out.println("입력값이 잘못되었습니다.");
            return;
        }
        System.out.print("수정할 이름을 입력하세요: ");
        String name = sc.nextLine().trim();
        List<String[]> targetList = category.equals("동물") ? getAnimals() : getPlants();
        boolean found = false;
        for (String[] item : targetList) {
            if (item[0].trim().equals(name)) {
                System.out.print("새 이름: ");
                String newName = sc.nextLine().trim();
                System.out.print("새 사는 곳: ");
                String newPlace = sc.nextLine().trim();
                item[0] = newName;
                item[2] = newPlace;
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("해당 이름의 " + category + "이(가) 없습니다.");
            return;
        }
        // 리스트 전체를 다시 하나의 배열로 합치고 저장
        List<String[]> merge = new ArrayList<>();
        merge.addAll(getAnimals());
        merge.addAll(getPlants());

        String[][] newInfoArray = new String[merge.size()][3];
        for (int i = 0; i < merge.size(); i++) {
            newInfoArray[i] = merge.get(i);
        }

        save(newInfoArray);
    }

    private static List<String[]> getAnimals() {
        return list_animal;
    }
    private static List<String[]> getPlants() {
        return list_plant;
    }


    public static void delete() {
        System.out.println("삭제할 객체의 분류를 입력하세요.");
        String filed = sc.nextLine();
        if (filed.equals("동물")){
            System.out.println("삭제할 객체의 이름을 입력하세요.");
            String value = sc.nextLine();
            for (int i=0;i< list_animal.size();i++){
                if(list_animal.get(i)[0].equals(value)){
                    list_animal.remove(i);
                    i--; // 삭제 후 인덱스 조정
                }
            }
        }
        else if (filed.equals("식물")){
            System.out.println("삭제할 객체의 이름을 입력하세요.");
            String value = sc.nextLine();
            for (int i=0;i< list_plant.size();i++){
                if(list_plant.get(i)[0].equals(value)){
                    list_plant.remove(i);
                    i--; // 삭제 후 인덱스 조정
                }
            }
        }
    }

    public static void search() {
        System.out.println("검색할 객체의 이름을 입력하세요.");
        String value = sc.nextLine();
        List<String[]> mergedList = new ArrayList<>();
        mergedList.addAll(list_animal);
        mergedList.addAll(list_plant);
        boolean found = false;
        for (String[] info : mergedList) {
            if (info[0].trim().equals(value)) {
                System.out.printf("%s는 %s이며 %s에 서식합니다. ",info[0],info[1],info[2] );
                found = true;
                break;  // 하나만 찾고 끝내려면 break
            }
        }
        if (!found) {
            System.out.println("해당 이름의 객체가 없습니다.");
        }
    }

}
