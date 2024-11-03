package Submission;

public class TextCounter {
    private int lineCount;
    private int characterCount;

    public TextCounter() {
        lineCount = 0;
        characterCount = 0;
    }

    public void addLine(String line) {
        lineCount++;
        characterCount += line.length();
    }

    public int getLineCount() {
        return lineCount;
    }

    public int getCharacterCount() {
        return characterCount;
    }
}
