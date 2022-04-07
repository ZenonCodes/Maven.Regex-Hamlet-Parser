import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        String expected = hamletText.replaceAll("Hamlet","Leon");
        String actual = hamletParser.ChangeHamletToLeon();

        assertEquals(expected, actual);

    }

    @Test
    public void testChangeHoratioToTariq() {
        String expected = hamletText.replaceAll("Horatio","Tariq");
        String actual = hamletParser.ChangeHoratioToTariq();

        assertEquals(expected, actual);

    }

    @Test
    public void testFindHoratio1() {
        String text = "Horatio says 'tis but our fantasy";
        boolean expected = true;
        boolean actual = hamletParser.FindHoratio(text);

        assertEquals(actual,expected);
    }

    @Test
    public void testFindHoratio2(){
        String text = "HORATIO Well, sit we down";
        boolean expected = false;
        boolean actual = hamletParser.FindHoratio(text);

        assertEquals(actual,expected);
    }

    @Test
    public void testFindHamlet1() {
        String text = "The Tragedy of Hamlet, Prince of Denmark";
        boolean expected = true;
        boolean actual = hamletParser.FindHamlet(text);

        assertEquals(actual,expected);
    }

    @Test
    public void testFindHamlet2() {
        String text = "Shakespeare homepage | Hamlet | Entire play";
        boolean expected = true;
        boolean actual = hamletParser.FindHamlet(text);

        assertEquals(actual,expected);
    }

    @Test
    public void testFindHamlet3() {
        String text = "Shakespeare homepage | HAMLET  | Entire play";
        boolean expected = false;
        boolean actual = hamletParser.FindHamlet(text);

        assertEquals(actual,expected);
    }

}