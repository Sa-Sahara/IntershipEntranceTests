package internship.task1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BuyGunTest {
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
    public void testShouldBe10() {
        // Define the input for the test case
        final String input = "5 13\n" +
                "3 10 300 15 3\n";

        // Redirect standard input to the test input
        testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);

        // Call the main method of the BuyGun class
        BuyGun.main(null);

        // Capture the output
        String output = testOut.toString().trim();

        // Assert that the output matches the expected output
        assertEquals("10", output);
    }

    @Test
    public void testShouldBe0() {
        final String input = "3 4\n" +
                "5 12 10\n";

        testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);

        BuyGun.main(null);

        String output = testOut.toString().trim();

        assertEquals("0", output);
    }
}
