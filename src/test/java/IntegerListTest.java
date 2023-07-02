
import org.example.IntegerList;
import org.example.StringList;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;
public class IntegerListTest {
    private final IntegerList integerList = new IntegerList();

    @Before
    public void setUp() {
        integerList.add(1);
        integerList.add(10);
        integerList.add(100);
        integerList.add(7);
        integerList.add(3);
        integerList.add(18);
        integerList.add(92);
    }

    @Test
    public void addNewElemCorrect() {
        Integer expected = 44;
        Integer expected2 = 34;
        int expextedSize = 9;
        integerList.add(expected);
        integerList.add(expected2);

        assertEquals(expected, integerList.get(7));
        assertEquals(expected2, integerList.get(8));
        assertEquals(expextedSize, integerList.size());
    }

    @Test
    public void addNewElemOnIndexPosition() {
        Integer elem1 = 44;
        Integer elem2 = 34;
        int expextedSize = 9;
        integerList.add(0, elem1);
        integerList.add(3, elem2);

        assertEquals(0, integerList.indexOf(elem1));
        assertEquals(3, integerList.indexOf(elem2));
        assertEquals(expextedSize, integerList.size());
        assertThrows(IllegalArgumentException.class, () -> integerList.add(20, 111));
    }

    @Test
    public void setElemCorrect() {
        integerList.set(1, 12);
        assertEquals((Integer) 12, integerList.get(1));
        assertNotEquals((Integer) 9, integerList.get(1));
        assertThrows(IllegalArgumentException.class, () -> integerList.add(20, 10));
    }

    @Test
    public void removeElemByValue() {
        int pastSize = integerList.size();
        integerList.remove((Integer) 10);

        assertNotEquals((Integer) 10, integerList.get(1));
        assertEquals(pastSize - 1, integerList.size());
    }

    @Test
    public void removeElemByIndex() {
        int pastSize = integerList.size();
        integerList.remove(2);

        assertNotEquals((Integer) 100, integerList.get(2));
        assertEquals(pastSize - 1, integerList.size());
        assertThrows(IllegalArgumentException.class, () -> integerList.remove(20));
    }

    @Test
    public void checkElemContains() {
        assertTrue(integerList.contains(10));
        assertFalse(integerList.contains(987543));
    }

    @Test
    public void getIndexOfCorrect() {
        int expected1 = 3;
        int expected2 = 1;

        assertEquals(expected1, integerList.indexOf(7));
        assertEquals(expected2, integerList.indexOf(10));
        assertEquals(-1, integerList.indexOf(456789));
    }

    @Test
    public void getLastIndexOfCorrect() {
        int expected1 = 3;
        int expected2 = 1;

        assertEquals(expected1, integerList.lastIndexOf(7));
        assertEquals(expected2, integerList.lastIndexOf(10));
        assertEquals(-1, integerList.lastIndexOf(90000000));
    }

    @Test
    public void getElemCorrect() {
        assertEquals((Integer) 10, integerList.get(1));
        assertThrows(IllegalArgumentException.class, () -> integerList.get(20));
    }

    @Test
    public void equalsWorksCorrect() {
        IntegerList eqIntList = new IntegerList();
        eqIntList.add(1);
        eqIntList.add(10);
        eqIntList.add(100);
        eqIntList.add(7);
        eqIntList.add(3);
        eqIntList.add(18);
        eqIntList.add(92);

        IntegerList nullIntList = null;

        assertTrue(integerList.equals(eqIntList));

        eqIntList.remove(1);
        assertFalse(integerList.equals(eqIntList));

        assertThrows(IllegalArgumentException.class, () -> integerList.equals(nullIntList));
    }

    @Test
    public void returnsCorrectSize() {
        int expected = 7;
        assertEquals(expected, integerList.size());
    }

    @Test
    public void isEmptyWorksCorrect() {
        IntegerList emptyList = new IntegerList();
        assertFalse(integerList.isEmpty());
        assertTrue(emptyList.isEmpty());
    }

    @Test
    public void clearWorksCorrect() {
        integerList.clear();

        assertEquals(0, integerList.size());
    }

    @Test
    public void toArrayWorksCorrect() {
        Integer[] expected = new Integer[]{1, 10, 100, 7, 3, 18, 92};
        assertEquals(expected, integerList.toArray());
    }

    @Test
    public void containsWorksCorrect() {
        assertTrue(integerList.contains(100));
        assertFalse(integerList.contains(19000));
    }

    @Test
    public void sortWorksCorrect() {
        IntegerList expected = new IntegerList();
        expected.add(1);
        expected.add(3);
        expected.add(7);
        expected.add(10);
        expected.add(18);
        expected.add(92);
        expected.add(100);

        IntegerList actual = integerList.sort(integerList);

        assertArrayEquals(expected.toArray(), actual.toArray());
    }
}
