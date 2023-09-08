package internship.task4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class RobberyTest {
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
    public void test1() {
        // Define the input for the test case
        String input = "5\n 2\n" +
                "1 2\n";

        // Redirect standard input to the test input
        testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);

        // Call the main method of the Robbery class
        Robbery.main(null);

        // Capture the output
        String output = testOut.toString().trim();

        // Assert that the output matches the expected output
        String expectedOutput = "3\r\n" +
                "1 2 2";
        assertEquals(expectedOutput, output);
    }

    @Test
    public void test2() {
        // Define the input for the test case
        String input = "7\n 2\n" +
                "1 2\n";

        testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);

        Robbery.main(null);

        String output = testOut.toString().trim();

        String expectedOutput = "-1";
        assertEquals(expectedOutput, output);
    }

    @Test
    public void test3() {
        // Define the input for the test case
        String input = "5\n 2\n" +
                "3 4\n";

        testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);

        Robbery.main(null);

        String output = testOut.toString().trim();

        String expectedOutput = "-1";
        assertEquals(expectedOutput, output);
    }
}
