package internship.task5;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GhostTest {
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
    public void testExpect5() {
        String input = "5 6\n" +
                "1 2 8\n" +
                "2 3 6\n" +
                "2 3 2\n" +
                "3 1 4\n" +
                "5 4 1\n" +
                "4 5 8\n";

        // Redirect standard input to the test input
        testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);

        // Call the main method of the tested class
        Ghost.main(null);

        // Capture the output
        String output = testOut.toString().trim();

        // Assert that the output matches the expected output
        assertEquals("5", output);
    }

    @Test
    public void testExpect8() {
        String input = "2 2\n" +
                "1 2 6\n" +
                "2 1 9\n";

        testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);

        Ghost.main(null);

        String output = testOut.toString().trim();

        assertEquals("8", output);
    }
}
