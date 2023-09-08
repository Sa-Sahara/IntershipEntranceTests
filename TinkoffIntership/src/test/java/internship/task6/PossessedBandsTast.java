package internship.task6;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PossessedBandsTast {
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @Before
    public void setUpStreams() {
        // Redirect standard input and output
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    @After
    public void restoreStreams() {
        // Reset standard input and output
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    public void test() {
        String input = "7 13\n" +
                "2 3 1\n" +
                "3 3\n" +
                "1 2 4\n" +
                "2 1 1\n" +
                "3 4\n" +
                "2 3 4\n" +
                "1 3 4\n" +
                "3 4\n" +
                "1 7 3\n" +
                "1 1 3\n" +
                "3 7\n" +
                "3 1\n" +
                "2 7 4\n";

        // Redirect standard input to the test input
        testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);

        // Call the main method of the tested class
        PossessedBands.main(null);

        // Capture the output
        String output = testOut.toString().trim();

        // Assert that the output matches the expected output
        String expected = "NO\r\n" +
                "1\r\n" +
                "YES\r\n" +
                "2\r\n" +
                "NO\r\n" +
                "3\r\n" +
                "3\r\n" +
                "2\r\n" +
                "YES";
        assertEquals(expected, output);
    }
}
