import org.example.StringList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringListTest {
    private final StringList stringList = new StringList();

    @Before
    public void setUp() {
        stringList.add("aaa");
        stringList.add("bbb");
        stringList.add("ccc");
        stringList.add("ddd");
    }


    @Test
    public void addNewElemCorrect() {
        String expected = "eee";
        String expected2 = "fff";
        int expextedSize = 6;
        stringList.add(expected);
        stringList.add(expected2);

        assertEquals(expected, stringList.get(4));
        assertEquals(expected2, stringList.get(5));
        assertEquals(expextedSize, stringList.size());
    }

    @Test
    public void addNewElemOnIndexPosition() {
        String elem1 = "eee";
        String elem2 = "fff";
        int expextedSize = 6;
        stringList.add(0, elem1);
        stringList.add(3, elem2);

        assertEquals(0, stringList.indexOf(elem1));
        assertEquals(3, stringList.indexOf(elem2));
        assertEquals(expextedSize, stringList.size());
        assertThrows(IllegalArgumentException.class, () -> stringList.add(20, "ccc"));
    }

    @Test
    public void setElemCorrect() {
        stringList.set(1, "zzz");
        assertEquals("zzz", stringList.get(1));
        assertNotEquals("bbb", stringList.get(1));
        assertThrows(IllegalArgumentException.class, () -> stringList.add(20, "ccc"));
    }

    @Test
    public void removeElemByValue() {
        int pastSize = stringList.size();
        stringList.remove("aaa");

        assertNotEquals("aaa", stringList.get(0));
        assertEquals(pastSize - 1, stringList.size());
    }

    @Test
    public void removeElemByIndex() {
        int pastSize = stringList.size();
        stringList.remove(2);

        assertNotEquals("ccc", stringList.get(2));
        assertEquals(pastSize - 1, stringList.size());
        assertThrows(IllegalArgumentException.class, () -> stringList.remove(20));
    }

    @Test
    public void checkElemContains() {
        assertTrue(stringList.contains("aaa"));
        assertFalse(stringList.contains("gfhhdfjfdj"));
    }

    @Test
    public void getIndexOfCorrect() {
        int expected1 = 3;
        int expected2 = 1;

        assertEquals(expected1, stringList.indexOf("ddd"));
        assertEquals(expected2, stringList.indexOf("bbb"));
        assertEquals(-1, stringList.indexOf("dffdf"));
    }

    @Test
    public void getLastIndexOfCorrect() {
        int expected1 = 3;
        int expected2 = 1;

        assertEquals(expected1, stringList.lastIndexOf("ddd"));
        assertEquals(expected2, stringList.lastIndexOf("bbb"));
        assertEquals(-1, stringList.lastIndexOf("dffdf"));
    }

    @Test
    public void getElemCorrect() {
        assertEquals("bbb", stringList.get(1));
        assertThrows(IllegalArgumentException.class, () -> stringList.get(20));
    }

    @Test
    public void equalsWorksCorrect() {
        StringList eqStrList = new StringList();
        eqStrList.add("aaa");
        eqStrList.add("bbb");
        eqStrList.add("ccc");
        eqStrList.add("ddd");

        StringList nullStrList = null;

        assertTrue(stringList.equals(eqStrList));

        eqStrList.remove(1);
        assertFalse(stringList.equals(eqStrList));

        assertThrows(IllegalArgumentException.class, () -> stringList.equals(nullStrList));
    }

    @Test
    public void returnsCorrectSize() {
        int expected = 4;
        assertEquals(expected, stringList.size());
    }

    @Test
    public void isEmptyWorksCorrect() {
        StringList emptyList = new StringList();
        assertFalse(stringList.isEmpty());
        assertTrue(emptyList.isEmpty());
    }

    @Test
    public void clearWorksCorrect() {
        stringList.clear();

        assertEquals(0, stringList.size());
    }

    @Test
    public void toArrayWorksCorrect() {
        String[] expected = new String[]{"aaa", "bbb", "ccc", "ddd"};
        assertEquals(expected, stringList.toArray());
    }
}
