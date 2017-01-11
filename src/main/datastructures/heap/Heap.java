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
     *
     * This is done by continously comparing the inserted node against its parent. If it is less than the parent, swap
     * the two nodes. Keep going until the added element is greater than its parent.
     */

    public void push(T item) {
        data.add(item);
        if (data.size() == 1) {
            return;
        }

        int indexOfItem = data.size() - 1;
        boolean isLessThanOrEqualToParent;
        int indexOfParent;
        T valOfParent;

        do {
            indexOfParent = getParentIndex(indexOfItem);
            valOfParent = data.get(indexOfParent);
            isLessThanOrEqualToParent = item.compareTo(valOfParent) <= 0;
            if (isLessThanOrEqualToParent) {
                data.set(indexOfParent, item);
                data.set(indexOfItem, valOfParent);
                indexOfItem = indexOfParent;
            }
        } while (isLessThanOrEqualToParent && indexOfItem != 0);
    }

    /**
     * Popping an element off the heap is first done by swapping the root of the heap with the last element. The
     * now-last element can now safely be removed, but the swapped element probably made our heap not so heapy.
     *
     * We fix this by sinking the root down by continously swapping it out with the lesser of its two children. Continue
     * until the element is less than both of its children.
     */

    public T pop() {
        T popped = data.get(0);
        int lastIndex = data.size() - 1;
        T lastElement = data.get(data.size() - 1);
        data.set(0, lastElement);

        int currentIndex = 0;
        T currentValue;
        T lesserChildValue;

        int lesserChildIndex = getLesserChildIndex(currentIndex);

        // begin sink
        if (data.size() == 1) {
            data.remove(0);
        } else {
            do {
                currentValue = data.get(currentIndex);
                lesserChildValue = data.get(lesserChildIndex);
                data.set(lesserChildIndex, currentValue);
                data.set(currentIndex, lesserChildValue);
                currentIndex = lesserChildIndex;
                lesserChildIndex = getLesserChildIndex(currentIndex);
            } while (lesserChildIndex != -1);
            data.remove(lastIndex);
        }

        return popped;
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

    private int getLesserChildIndex(int parentIndex) {
        int leftChildIndex = getLeftChildIndex(0);
        int rightChildIndex = getRightChildIndex(0);

        T parentValue = data.get(parentIndex);
        T leftChildValue = leftChildIndex < data.size() ? data.get(leftChildIndex) : null;
        T rightChildValue = rightChildIndex < data.size() ? data.get(rightChildIndex) : null;

        if ((leftChildValue == null && rightChildValue == null) ||
                (parentValue.compareTo(leftChildValue) <= 0 && parentValue.compareTo(rightChildValue) <= 0)) {
            return -1; //sentinel value used to indicate the parent is less than its children, or has no children
        } else if (leftChildValue.compareTo(rightChildValue) <= 0 || rightChildValue == null) {
            return leftChildIndex;
        } else {
            return rightChildIndex;
        }
    }

}
