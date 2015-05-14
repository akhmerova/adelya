package ru.kpfu.itis.group11403.akhmerova.Stack;

import java.util.Scanner;

/**
 * Created by Adelya on 10.04.2015.
 */

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter brackets");
        String a = scanner.nextLine();

        MyStack<Character> stack = new MyStack<Character>();

        boolean rightBrackets = true;
        char symbol = a.charAt(0);
        if (symbol == ')' || symbol == '}' || symbol == ']') {

            rightBrackets = false;

        } else {
            for (int i = 0; i < a.length(); i++) {
                symbol = a.charAt(i);

                switch (symbol) {
                    case '(':
                        stack.add(new Character('('));
                        break;
                    case '{':
                        stack.add(new Character('{'));
                        break;
                    case '[':
                        stack.add(new Character('['));
                        break;
                    case ')':
                        if (stack.peek() == '(') {
                            stack.delete();
                        } else {
                            rightBrackets = false;
                        }
                        break;
                    case '}':
                        if (stack.peek() == '{') {
                            stack.delete();
                        } else {
                            rightBrackets = false;
                        }
                        break;
                    case ']':
                        if (stack.peek() == '[') {
                            stack.delete();
                        } else {
                            rightBrackets = false;
                        }
                        break;
                    default:
                        break;
                }
            }

            if (!stack.isEmpty()) {
                rightBrackets = false;
            }
        }
        System.out.println(rightBrackets);
    }
}
