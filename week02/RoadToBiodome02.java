package week02;

import java.util.ArrayList;

class stack {
    private ArrayList<Character> stack;

    public stack() {
        stack = new ArrayList<>();
    }

    public void push(char c) {
        stack.add(c);
    }

    public char pop() {
        if (!isEmpty()) {
            return stack.remove(stack.size() - 1);
        } else {
            throw new RuntimeException("스택이 비어있습니다.");
        }
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}

public class RoadToBiodome02 {
    public static void main(String[] args) {
        String text = String.join(" ", args);

        if (text.isBlank()) {
            System.out.println("입력된 메시지가 올바르지 않습니다. 다시 한번 확인해주세요.");
            return;
        }
        stack stack = new stack();
        for (char c : text.toCharArray()) {
            stack.push(c);
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
