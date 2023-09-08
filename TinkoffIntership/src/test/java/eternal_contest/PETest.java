package eternal_contest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class PETest {
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

        final String input = "4\r\n" +
                "2  1  4  6";

        testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);

        PE.main(null);

        String output = testOut.toString().trim();

        assertEquals("-1-1", output);
    }

    @Test
    public void test2() {

        final String input = "2\r\n" +
                "1  2";

        testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);

        PE.main(null);

        String output = testOut.toString().trim();

        assertEquals("-1-1", output);
    }

    @Test
    public void test3() {

        final String input = "2\r\n" +
                "2  1";

        testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);

        PE.main(null);

        String output = testOut.toString().trim();

        assertEquals("21", output);
    }
}

