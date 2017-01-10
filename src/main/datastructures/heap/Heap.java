package main.datastructures.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * This class implements a heap. For the purposes of this exercise, it will be a min-heap, but implementing a max-heap
 * would be almost an identical process.
 *
 * We are using a list to represent the heap, as it is quite efficient in terms of memory. To reach the children nodes
 * of the node at index n, use the following formulas:
 *
 * Left child: n * 2 + 1
 * Right child: n * 2 + 2
 *
 * Conversely, to get a node's parent, use the following formula when on an odd index (which are always left children):
 *
 * (n - 1) / 2
 *
 * And the following when on an even index (which are always right children):
 *
 * (n - 2) / 2
 *
 * @param <T> The data type to be stored in the heap.
 */

public class Heap<T extends Comparable<T>> {

    private List<T> data;

    public Heap() {
        data = new ArrayList<>();
    }

    /**
     * Since this is a min-heap, a node must be less than its two children. This is accomplished by adding the new
     * element to the end of the list representing the heap, and then "bubbling" it up until it is in an appropriate
     * position.
     */

    public void push(T item) {
        data.add(item);

        int indexOfItem = data.size() - 1;
        int indexOfParent = getParentIndex(indexOfItem);
        if (indexOfParent < 0) {
            return ;
        }
        T valOfParent = data.get(indexOfParent);
        boolean isLessThanOrEqualToParent = item.compareTo(valOfParent) <= 0;

        while (isLessThanOrEqualToParent) {
            data.set(indexOfParent, item);
            data.set(indexOfItem, valOfParent);
            indexOfItem = indexOfParent;
            indexOfParent = getParentIndex(indexOfItem);
            if (indexOfParent < 0) {
                break;
            }
            valOfParent = data.get(indexOfParent);
            isLessThanOrEqualToParent = item.compareTo(valOfParent) <= 0;
        }
    }

    public void pop() {

    }

    @Override
    public String toString() {
        return data.toString();
    }

    private int getParentIndex(int childIndex) {
        boolean isEven = childIndex % 2 == 0;
        if (isEven) {
            return (childIndex - 2) / 2;
        } else {
            return (childIndex - 1) / 2;
        }
    }

    private int getLeftChildIndex(int parentIndex) {
        return parentIndex * 2 + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return parentIndex * 2 + 2;
    }

}
