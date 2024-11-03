package Submission;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextReaderTest {

    @Test
    public void testReadTextHandlesEmptyInput() {
        // Simulera tom inmatning och avsluta med "stop"
        String simulatedInput = "\nstop\n";
        InputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        TextReader textReader = new TextReader();
        textReader.readText();

        // Förväntat resultat: 1 rad (tom) och 0 tecken
        TextCounter expectedTextCounter = new TextCounter();
        expectedTextCounter.addLine(""); // En tom rad

        assertEquals(1, expectedTextCounter.getLineCount(), "Line count should be 1 for an empty input line");
        assertEquals(0, expectedTextCounter.getCharacterCount(), "Character count should be 0 for an empty input line");
    }

    @Test
    public void testReadTextHandlesSingleLineInput() {
        // Simulera en enda rad inmatning
        String simulatedInput = "Endast en rad\nstop\n";
        InputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        TextReader textReader = new TextReader();
        textReader.readText();

        // Förväntat resultat: 1 rad och 15 tecken (med blanksteg)
        TextCounter expectedTextCounter = new TextCounter();
        expectedTextCounter.addLine("Endast en rad");

        assertEquals(1, expectedTextCounter.getLineCount(), "Line count should be 1 for single line input");
        assertEquals(13, expectedTextCounter.getCharacterCount(), "Character count should be 13 for 'Endast en rad'");
    }

    @Test
    public void testReadTextHandlesMultipleLinesInput() {
        // Simulera flera rader inmatning
        String simulatedInput = "Första raden\nAndra raden\nTredje raden\nstop\n";
        InputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        TextReader textReader = new TextReader();
        textReader.readText();

        // Förväntat resultat: 3 rader och 41 tecken
        TextCounter expectedTextCounter = new TextCounter();
        expectedTextCounter.addLine("Första raden");
        expectedTextCounter.addLine("Andra raden");
        expectedTextCounter.addLine("Tredje raden");

        assertEquals(3, expectedTextCounter.getLineCount(), "Line count should be 3 for three lines input");
        assertEquals(35, expectedTextCounter.getCharacterCount(), "Character count should be 35 for the three lines");
    }
}
