package eternal_contest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class InternetTest {
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

        final String input = "100 10 12 15";

        testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);

        Internet.main(null);

        String output = testOut.toString().trim();

        assertEquals("160", output);
    }

    @Test
    public void test2() {

        final String input = "100  10  12  1";

        testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);

        Internet.main(null);

        String output = testOut.toString().trim();

        assertEquals("100", output);
    }
}
