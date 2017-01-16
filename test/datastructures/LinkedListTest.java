package datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    LinkedList<Integer> ll;

    @BeforeEach
    void setUp() {
        ll = new LinkedList<>();
    }

    @Test
    void addOne() {
        ll.add(1);
        String expected = "[1, ]";
        String actual = ll.toString();
        assertEquals(expected, actual);
    }

    @Test
    void addMany() {
        for (int i = 0; i < 10; i++) {
            ll.add(i);
        }
        String expected = "[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, ]";
        String actual = ll.toString();
        assertEquals(expected, actual);
    }

    @Test
    void addAtIndex() {
        for (int i = 0; i < 10; i++) {
            ll.add(i);
        }
        ll.addAtIndex(42, 5);
        String expected = "[0, 1, 2, 3, 4, 42, 5, 6, 7, 8, 9, ]";
        String actual = ll.toString();
        assertEquals(expected, actual);
    }

    @Test
    void addAtStart() {
        for (int i = 0; i < 10; i++) {
            ll.add(i);
        }
        ll.addAtIndex(42, 0);
        String expected = "[42, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, ]";
        String actual = ll.toString();
        assertEquals(expected, actual);
    }

    @Test
    void removeAtIndex() {
        for (int i = 0; i < 10; i++) {
            ll.add(i);
        }
        ll.removeAtIndex(5);
        String expected = "[0, 1, 2, 3, 4, 6, 7, 8, 9, ]";
        String actual = ll.toString();
        assertEquals(expected, actual);
    }

    @Test
    void removeAtStart() {
        for (int i = 0; i < 10; i++) {
            ll.add(i);
        }
        ll.removeAtIndex(0);
        String expected = "[1, 2, 3, 4, 5, 6, 7, 8, 9, ]";
        String actual = ll.toString();
        assertEquals(expected, actual);
    }

}