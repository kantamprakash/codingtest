import org.example.FootballCompetition;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.*;
import java.util.*;

public class FootballCompetitionTest {

    @Test
    public void testCompetition() throws Exception {
        String input = "Genmany;Spain;win\n" +
                "France;Genmany;win\n" +
                "Poland;Spain;loss\n" +
                "Spain;France;loss\n" +
                "Genmany;Poland;win\n";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        // Redirect System.in and System.out
        System.setIn(in);
        System.setOut(new PrintStream(out));

        // Create a temporary file with the input
        File tempFile = File.createTempFile("input", ".txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            writer.write(input);
        }

        // Set the path to the temporary file in the main method
        String inputFile = tempFile.getAbsolutePath();

        // Call the main method with the path to the input file
        String[] args = {inputFile};
        FootballCompetition.main(args);

        // Reset System.in and System.out
        System.setIn(System.in);
        System.setOut(System.out);

        String expectedOutput = "Team                           | MP |  W |  L |  P\n" +
                "France                         |  2 |  2 |  0 |  6\n" +
                "Genmany                        |  3 |  2 |  1 |  6\n" +
                "Spain                          |  3 |  1 |  2 |  3\n" +
                "Poland                         |  2 |  0 |  2 |  0\n";

        assertEquals(expectedOutput.trim(), out.toString().trim());
    }
}
