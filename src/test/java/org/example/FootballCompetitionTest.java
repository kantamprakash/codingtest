package org.example;

import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FootballCompetitionTest {

    @Test
    public void testCompetition() {
        String input = "Genmany;Spain;win\n" +
                       "France;Genmany;win\n" +
                       "Poland;Spain;loss\n" +
                       "Spain;France;loss\n" +
                       "Genmany;Poland;win\n";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        System.setIn(in);
        System.setOut(new PrintStream(out));

        FootballCompetition.main(new String[]{});

        String expectedOutput = "Team                           | MP |  W |  L |  P\n" +
                                "France                         |  2 |  2 |  0 |  6\n" +
                                "Genmany                        |  3 |  2 |  1 |  6\n" +
                                "Spain                          |  3 |  1 |  2 |  3\n" +
                                "Poland                         |  2 |  0 |  2 |  0\n";

        assertEquals(expectedOutput, out.toString().trim());
    }
}
