package library;

import javax.swing.plaf.TreeUI;
import java.util.Arrays;

public class Alist implements IList {

    int[] values;
    int size;

    public Alist() {
        values = new int[10];
        size = 0;
    }

    public Alist(int capacity) {
        this.values = new int[capacity + (capacity * 2 / 3)];
        size = capacity;
    }

    public Alist(int[] values) {

        int length = values.length + (values.length * 2 / 3);
        if (length < 10) {
            length = 10;
        }

        this.values = new int[length];
        for (int i = 0; i < values.length; i++) {
            this.values[i] = values[i];
        }
        size = values.length;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int get(int index) {
        return values[index];
    }

    @Override
    public boolean add(int value) {
        if (size == values.length) {
            int[] tmpArr = new int[values.length + (values.length * 2 / 3)];

            for (int i = 0; i < size; i++) {
                tmpArr[i] = values[i];
            }
            values = tmpArr;
        }

        values[size++] = value;

        return true;
    }

    @Override
    public boolean add(int index, int value) {
        if (index < 0) {
            return false;
        }

        int[] tmpArr;
        if (index >= values.length) {
            int maxLength= index + 1;
            int newLength =  maxLength+ (maxLength * 2 / 3);

            tmpArr = new int[newLength];
            for (int i = 0; i < size; i++) {
                tmpArr[i] = values[i];
            }
            tmpArr[index] = value;

            size = index + 1;
        } else if (index > size) {

            tmpArr = new int[values.length];
            for (int i = 0; i < size; i++) {
                tmpArr[i] = values[i];
            }

            tmpArr[index] = value;

            size = index + 1;
        } else {
            tmpArr = new int[values.length];

            for (int i = 0; i < index; i++) {
                tmpArr[i] = values[i];
            }

            tmpArr[index] = value;
            ++size;
            int continueIndex = index == 0 ? 1 : index + 1;
            for (int i = continueIndex; i < size; i++) {
                tmpArr[i] = values[i - 1];
            }
        }
        values = tmpArr;

        return true;
    }

    @Override
    public int remove(int number) {
        int countRemoved = 0;
        int[] tmpArr = new int[values.length];

        int oldSize = size;
        for (int i = 0, j = 0; i < oldSize; i++) {
            int currentNumber = values[i];
            if (currentNumber == number) {
                countRemoved++;
                size--;
                continue;
            }

            tmpArr[j++] = values[i];
        }

        values = tmpArr;
        return countRemoved;
    }

    @Override
    public int removeByIndex(int index) {
        if (index > size - 1) {
            return 0;
        }

        if (index < 0) {
            return 0;
        }
        int[] tmpArr = new int[values.length];

        for (int i = 0; i < index; i++) {
            tmpArr[i] = values[i];
        }

        for (int i = index + 1; i < size; i++) {
            tmpArr[i - 1] = values[i];
        }

        size--;
        values = tmpArr;

        return 1;
    }

    @Override
    public boolean contains(int value) {
        for (int i = 0; i < size; i++) {
            if (values[i] == value) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean set(int index, int value) {
        if (index > size - 1) {
            return false;
        }

        if (index < 0) {
            return false;
        }

        values[index] = value;

        return true;
    }

    @Override
    public void print() {
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            System.out.print(values[i]);
            if (i + 1 < size) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    @Override
    public int[] toArray() {
        return values;
    }

    @Override
    public boolean removeAll(int[] arr) {

        int[] tmpArr = new int[values.length];

        int oldSize = size;
        for (int i = 0, j = 0; i < oldSize; i++) {
            int currentNumber = values[i];

            goodToDelete:
            {
                for (int q = 0; q < arr.length; q++) {
                    int numberToDelete = arr[q];

                    if (currentNumber == numberToDelete) {
                        size--;
                        break goodToDelete;
                    }
                }

                tmpArr[j++] = values[i];
            }
        }

        values = tmpArr;
        return true;
    }
}
