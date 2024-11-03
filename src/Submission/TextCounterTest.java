package Submission;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TextCounterTest {
    private TextCounter textCounter;

    @BeforeEach
    public void setUp() {
        textCounter = new TextCounter();
    }

    @Test
    public void testAddLineIncreasesLineCount() {
        textCounter.addLine("First line");
        textCounter.addLine("Second line");

        assertEquals(2, textCounter.getLineCount(), "Line count should be 2 after adding two lines");
    }

    @Test
    public void testAddLineIncreasesCharacterCount() {
        textCounter.addLine("Hello");
        textCounter.addLine("World");

        assertEquals(10, textCounter.getCharacterCount(), "Character count should be 10 after adding 'Hello' and 'World'");
    }

    @Test
    public void testInitialCountsAreZero() {
        assertEquals(0, textCounter.getLineCount(), "Initial line count should be 0");
        assertEquals(0, textCounter.getCharacterCount(), "Initial character count should be 0");
    }
}