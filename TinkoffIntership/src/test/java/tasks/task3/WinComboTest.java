package tasks.task3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import tasks.task3.WinCombo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class WinComboTest {
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
    public void testExpectNo1() {
        // Define the input for the test case
        String input = "5\n" +
                "1 4 2 2 4\n" +
                "1 4 4 2 2\n";

        // Redirect standard input to the test input
        testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);

        // Call the main method of the WinCombo class
        WinCombo.main(null);

        // Capture the output
        String output = testOut.toString().trim();

        // Assert that the output matches the expected output
        assertEquals("NO", output);
    }

    @Test
    public void testExpectNo2() {
        String input = "3\n" +
                "4 1 2\n" +
                "1 4 7\n";

        testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);

        WinCombo.main(null);

        String output = testOut.toString().trim();

        assertEquals("NO", output);
    }

    @Test
    public void testExpectYes() {
        String input = "6\n" +
                "5 1 2 5 3 5\n" +
                "5 1 2 3 5 5\n";

        testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);

        WinCombo.main(null);

        String output = testOut.toString().trim();

        assertEquals("YES", output);
    }
}
