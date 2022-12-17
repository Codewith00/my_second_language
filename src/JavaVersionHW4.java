import java.util.Stack;

public class JavaVersionHW4 {
    public static void main(String[] args) {
        String message = "F2p)v\"y233{0->c}ttelciFc";

        String firstHalf = message.substring(0, message.length() / 2);
        String secondHalf = message.substring(message.length() / 2);

        System.out.println(first(firstHalf) + second(secondHalf));
    }

    static String shift(String mess, int a) {
        char[] mess1 = mess.toCharArray();
        int[] mess2 = new int[mess.length()];
        int i = 0;
        for (int j : mess1) {
            mess2[i] = j + a;
            i++;
        }
        StringBuilder finalWord = new StringBuilder();
        for (int wordInt : mess2) {
            char wordChar = (char) wordInt;
            finalWord.append(wordChar);
        }
        return finalWord.toString();
    }

    static String first(String mess) {
        String stepOne = shift(mess, 1)
                .replace("5", "s")
                .replace("4", "u");
        return shift(stepOne, -3)
                .replace("0", "o");
    }

    static String second(String mess) {
        return shift(reverse(mess), -4).replace("_", " ");
    }

    static String reverse(String mess) {
        if (mess == null || mess.equals("")) {
            return null;
        }
        Stack<Character> stack = new Stack<>();
        int i = 0;
        char[] charArray = mess.toCharArray();
        for (int j = 0; j < mess.length(); j++) {
            stack.add(j, charArray[j]);
        }
        while (!stack.isEmpty()) {
            charArray[i++] = stack.pop();
        }
        return String.copyValueOf(charArray);
    }
}

