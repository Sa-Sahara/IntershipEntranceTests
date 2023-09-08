package internship.task2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class SheriffLettersTest {
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
        // Reset standard input and output streams
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    public void testShouldBe2() {
        // Define the input for the test case
        final String input = "fheriherffazfszkisrrs";

        // Redirect standard input to the test input
        testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);

        // Call the main method of the SheriffLetters class
        SheriffLetters.main(null);

        // Capture the output
        String output = testOut.toString().trim();

        // Assert that the output matches the expected output
        assertEquals("2", output);
    }

    @Test
    public void testShouldBe1() {
        final String input = "rifftratatashe";

        testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);

        SheriffLetters.main(null);

        String output = testOut.toString().trim();

        assertEquals("1", output);
    }

    @Test
    public void testShouldBe0() {
        final String input = "thjLHNLlkx";

        testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);

        SheriffLetters.main(null);

        String output = testOut.toString().trim();

        assertEquals("0", output);
    }
}
