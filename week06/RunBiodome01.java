package week06;

import java.util.*;
import java.util.stream.Collectors;

class Member {
    String type;
    String name;

    public Member(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return type + " " + name;
    }
}

public class RunBiodome01 {
    static Scanner sc = new Scanner(System.in);
    static List<Member> m_list = new ArrayList<>();

    public static void main(String[] args) {
        insert();
        // --- groupingBy를 사용하여 멤버들을 분류합니다. ---
        Map<String, List<Member>> category = member_type();

        // 분류된 Map에서 "신입" 그룹과 "운영진" 또는 "멤버" 그룹을 가져옵니다.
        // 이때, '운영진'과 '멤버'는 같은 '일반 멤버' 그룹으로 묶여야 하므로,
        // Map에서 해당 키들을 가진 리스트를 합쳐야 합니다.
        List<Member> newMembers = category.getOrDefault("신입", Collections.emptyList());
        // '운영진'과 '멤버' 타입의 리스트를 합쳐서 'oldMembers'로 만듭니다.
        List<Member> oldMembers = new ArrayList<>();
        oldMembers.addAll(category.getOrDefault("운영진", Collections.emptyList()));
        oldMembers.addAll(category.getOrDefault("멤버", Collections.emptyList()));
        // 이름만 추출하여 출력 메소드에 전달합니다.
        print(oldMembers.stream().map(Member::getName).collect(Collectors.toList()),
                newMembers.stream().map(Member::getName).collect(Collectors.toList()));
    }


    public static void insert() {
        System.out.print("멤버 리스트를 입력하세요 (type name). exit를 입력하면 입력 종료: ");
        while (true) {
            String input = sc.nextLine();
            if (input.equals("exit")) {
                break;
            }


            String[] parts = input.split(" ", 2);
            if (parts.length == 2) {
                String type = parts[0];
                String name = parts[1];
                m_list.add(new Member(type, name));
            } else {
                System.out.println("잘못된 형식입니다. '타입 이름' 형식으로 입력해주세요.");
            }
        }
    }

    // --- groupingBy를 사용하여 멤버들을 타입별로 분류하는 메소드 ---
    public static Map<String, List<Member>> member_type() {
        return m_list.stream()
                .collect(Collectors.groupingBy(Member::getType)); // Member 객체의 getType()을 기준으로 그룹화
    }
    public static void print(List<String> old_member, List<String> new_member) {
        System.out.print("일반 멤버 : [");
        for (int i = 0; i < old_member.size(); i++) {
            System.out.print(old_member.get(i));
            if (i != (old_member.size() - 1)) {
                System.out.print(", "); //
            }
        }
        System.out.println("]");
        System.out.print("신입 멤버 : [");
        for (int i = 0; i < new_member.size(); i++) {
            System.out.print(new_member.get(i));
            if (i != (new_member.size() - 1)) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}