package main.datastructures.heap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HeapTest {

    Heap<Integer> heap;

    @BeforeEach
    public void setup() {
        heap = new Heap<Integer>();
    }

    @Test
    public void pushSingleElement() {
        heap.push(2);
        String str = heap.toString();
        assertEquals("[2]", str);
    }

    @Test
    public void pushMultipleElements() {
        for (int i = 0; i < 8; i++) {
            heap.push(i);
        }
        String str = heap.toString();
        assertEquals("[0, 1, 2, 3, 4, 5, 6, 7]", str);
    }

    @Test
    public void pushReordering() {
        heap.push(4);
        heap.push(2);
        String str = heap.toString();
        assertEquals("[2, 4]", str);
    }

    @Test
    public void pushReorderingMultipleLevels() {
        heap.push(2);
        heap.push(3);
        heap.push(5);
        heap.push(1);
        String str = heap.toString();
        assertEquals("[1, 2, 5, 3]", str);
    }

    @Test
    public void popSingleElement() {
        heap.push(2);
        assertEquals((Integer) 2, heap.pop());
    }

    @Test
    public void popWithSink() {
        heap.push(2);
        heap.push(3);
        heap.push(5);
        heap.push(1);
        heap.pop();
        String str = heap.toString();
        assertEquals("[2, 3, 5]", str);
    }

}