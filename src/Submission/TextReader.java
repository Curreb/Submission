package Submission;

import java.util.Scanner;

public class TextReader {
    private final TextCounter textCounter;

    public TextReader() {
        textCounter = new TextCounter();
    }

    public void readText() {
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("Skriv in text (skriv 'stop' för att avsluta):");

        while (true) {
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("stop")) {
                break;
            }
            textCounter.addLine(input);
        }

        scanner.close();
        printResults();
    }

    private void printResults() {
        System.out.println("Antal rader: " + textCounter.getLineCount());
        System.out.println("Antal tecken: " + textCounter.getCharacterCount());
    }
}
