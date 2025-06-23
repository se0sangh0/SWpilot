package week06;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class EnergyDistributor{
    private HashMap<String, Integer> options;
    private int energy;

    public EnergyDistributor(int startEnergy){
        this.options = new HashMap<>();
        this.energy = startEnergy;
    }

    public int getEnergy(){
        return energy;
    }

    public void insertEnergy(String area,int areaEnergy){
        if (areaEnergy<0){
            System.out.println("에너지 할당량은 음수가 될 수 없습니다.");
            return;
        }
        if (areaEnergy>=energy){
            System.out.println("할당 가능한 에너지를 초과했습니다.");
            return;
        }
        energy -= areaEnergy;
        options.put(area, options.getOrDefault(area,0)+areaEnergy);
        System.out.print(area + "에 " + areaEnergy + "의 에너지가 할당했습니다.");
        System.out.println("남은 전체 에너지 : "+energy);
    }

    public void printArea(){
        if(options.isEmpty()){
            System.out.println("아직 할당된 에너지가 없습니다.");
        } else {
            for (Map.Entry<String, Integer> entry : options.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }
    }
}

public class RunBiodome02 {
    static Scanner sc = new Scanner(System.in);
    static EnergyDistributor distributor = new EnergyDistributor(50000);
    public static void main(String[] args) {
        menu();

        if (distributor.getEnergy() <= 1000) {
            System.out.println("에너지 총량이 기준치 이하가 되었습니다.");
        }
        sc.close();
    }

    static void menu() {
        System.out.println("바이오도메 에너지 관리 시스템에 오신 것을 환영합니다.\n" +
                "1. 전체 에너지 조회하기\n" +
                "2. 특정 구역 에너지 할당하기\n" +
                "3. 구역별 에너지 조회하기\n" +
                "4. 종료하기");
        while (true) {
            System.out.println("메뉴를 선택해주세요.");
            int check = sc.nextInt();
            switch (check) {
                case 1:
                    print();
                    break;
                case 2:
                    insert();
                    break;
                case 3:
                    search();
                    break;
                case 4:
                    System.out.println("바이오도메 에너지 관리 시스템을 종료합니다. 감사합니다.");
                    return;
                default:
                    System.out.println("입력 메뉴가 잘못되었습니다 다시 입력해주세요");
            }
        }
    }

    static void insert() {
        System.out.print("할당하려는 구역 이름을 입력하세요 : ");
        String name = sc.next();
        System.out.print("\n");
        System.out.print("할당하려는 에너지량을 입력하세요 : ");
        int p_energy = sc.nextInt();
        System.out.print("\n");
        distributor.insertEnergy(name,p_energy);
    }

    static void print() {
        System.out.printf("남은 전체 에너지: %d\n", distributor.getEnergy());
    }

    static void search() {
        System.out.println("구역별 에너지 조회");
        distributor.printArea();
    }
}
