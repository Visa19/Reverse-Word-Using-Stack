import java.util.Scanner;
import java.util.Stack;

public class ReverseWords {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a word to reverse:");
        String inputSentence = scanner.nextLine();

        String reversedSentence = reverseWords(inputSentence);

        System.out.println("Reversed word : " + reversedSentence);
    }

    private static String reverseWords(String sentence) {
        Stack<Character> stack = new Stack<>();

        StringBuilder reversedWord = new StringBuilder();
        StringBuilder reversedSentence = new StringBuilder();

        for (char c : sentence.toCharArray()) {
            if (c != ' ') {
                stack.push(c);
            } else {
                while (!stack.isEmpty()) {
                    reversedWord.append(stack.pop());
                }
                reversedSentence.append(reversedWord).append(" ");
                reversedWord.setLength(0); // Clear the StringBuilder for the next word
            }
        }

        // Reverse the last word (if any)
        while (!stack.isEmpty()) {
            reversedWord.append(stack.pop());
        }
        reversedSentence.append(reversedWord);

        return reversedSentence.toString();
    }
}
