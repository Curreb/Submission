package Submission;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextReaderTest {

    @Test
    public void testReadTextHandlesEmptyInput() {
        
        String simulatedInput = "\nstop\n";
        InputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        TextReader textReader = new TextReader();
        textReader.readText();

        
        TextCounter expectedTextCounter = new TextCounter();
        expectedTextCounter.addLine(""); 

        assertEquals(1, expectedTextCounter.getLineCount(), "Line count should be 1 for an empty input line");
        assertEquals(0, expectedTextCounter.getCharacterCount(), "Character count should be 0 for an empty input line");
    }

    @Test
    public void testReadTextHandlesSingleLineInput() {
        
        String simulatedInput = "Endast en rad\nstop\n";
        InputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        TextReader textReader = new TextReader();
        textReader.readText();

        
        TextCounter expectedTextCounter = new TextCounter();
        expectedTextCounter.addLine("Endast en rad");

        assertEquals(1, expectedTextCounter.getLineCount(), "Line count should be 1 for single line input");
        assertEquals(13, expectedTextCounter.getCharacterCount(), "Character count should be 13 for 'Endast en rad'");
    }

    @Test
    public void testReadTextHandlesMultipleLinesInput() {
        
        String simulatedInput = "Första raden\nAndra raden\nTredje raden\nstop\n";
        InputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        TextReader textReader = new TextReader();
        textReader.readText();

        
        TextCounter expectedTextCounter = new TextCounter();
        expectedTextCounter.addLine("Första raden");
        expectedTextCounter.addLine("Andra raden");
        expectedTextCounter.addLine("Tredje raden");

        assertEquals(3, expectedTextCounter.getLineCount(), "Line count should be 3 for three lines input");
        assertEquals(35, expectedTextCounter.getCharacterCount(), "Character count should be 35 for the three lines");
    }

     @Test
    public void testReadFromFile() throws IOException {
        
        Path tempFile = Files.createTempFile("testfile", ".txt");
        try (FileWriter writer = new FileWriter(tempFile.toFile())) {
            writer.write("This is a test.");
        }

        
        TextReader textReader = new TextReader();
        String content = textReader.readFromFile(tempFile.toString());

        
        assertEquals("This is a test.", content);
        
        
        Files.delete(tempFile);
    }
}
