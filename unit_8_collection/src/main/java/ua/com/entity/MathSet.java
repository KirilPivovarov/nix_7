package ua.com.entity;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.NoSuchElementException;

@Getter
@Setter
public class MathSet<Numb extends Number & Comparable<Numb>> {

    private static final double expandedCoefficient = 1.5d;
    private static final int CAPACITY = 10;
    private int size;
    private Numb[] mathSet;


    public MathSet() {
        mathSet = (Numb[]) new Number[CAPACITY];
        size = 0;
    }

    public MathSet(int capacity) {
        this.mathSet = (Numb[]) new Number[capacity];
        this.size = 0;
    }

    public MathSet(Numb[] numbers) {
        this.mathSet = numbers;
        this.size = numbers.length;
    }

    public MathSet(Numb[]... numbers) {
        int sizeCount = 1;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                mathSet[sizeCount] = numbers[i][j];
                sizeCount++;
            }
        }
        this.size = sizeCount;

    }

    public MathSet(MathSet numbers) {
        this.size = numbers.getSize();
        mathSet = (Numb[]) numbers.mathSet;
    }

    public MathSet(MathSet... numbers) {
        this();
        for (MathSet<Numb> nums : numbers) {
            for (int i = 0; i < nums.getSize(); i++) {
                add(nums.get(i));
            }
        }
    }

    public void add(Numb n) {
        while (true) {
            if (size + 1 <= this.mathSet.length) {
                if (notContains(n)) {
                    mathSet[size] = n;
                    size++;
                }
                break;
            } else {
                Numb[] newArray = (Numb[]) new Number[(int) (size * expandedCoefficient)];
                System.arraycopy(mathSet, 0, newArray, 0, size);
                mathSet = newArray;
            }
        }
    }

    void add(Numb... n) {
        for (Numb number : n) {
            add(number);
        }
    }

    public void join(MathSet ms) {
        for (int i = 0; i < ms.getSize(); i++) {
            add((Numb) ms.mathSet[i]);
        }
    }


    void join(MathSet... ms) {
        for (MathSet<Numb> m : ms) {
            join(m);
        }
    }

    public void intersection(MathSet ms) {
        for (int i = 0; i < ms.getSize(); i++) {
            Numb[] copy = (Numb[]) new Number[size];
            System.arraycopy(this.mathSet, 0, copy, 0, size);
            clean();
            for (Numb numb : copy) {
                if (arrayContains((Numb[]) ms.mathSet, ms.size, numb)) {
                    add(numb);
                }
            }
        }
    }


    void intersection(MathSet... ms) {
        for (MathSet m : ms) {
            intersection(m);
        }
    }

    public void sortDesc() {
        sortAsc();
        reverse(0, size - 1);
    }

    private void reverse(int from, int to) {
        Numb[] newArray = (Numb[]) new Number[mathSet.length];
        System.arraycopy(mathSet, 0, newArray, 0, size);
        int counter = 0;
        for (int i = to; i >= 0; i--) {
            newArray[counter] = mathSet[i];
            counter++;
        }
        mathSet = newArray;
    }

    public void sortDesc(int firstIndex, int lastIndex) {
        sortAsc(firstIndex, lastIndex);
        reverse(firstIndex, lastIndex);
    }

    public void sortDesc(Numb value) {
        int index = indexOf(value);
        sortDesc(0, index - 1);
        sortDesc(index + 1, size - 1);
    }

    public void sortAsc() {
        quickSort(mathSet, 0, size - 1);
    }

    public void sortAsc(int firstIndex, int lastIndex) {
        if (firstIndex > size - 1 || firstIndex > lastIndex || lastIndex > size - 1)
            throw new ArrayIndexOutOfBoundsException();
        quickSort(mathSet, firstIndex, lastIndex);
    }


    public void sortAsc(Numb value) {
        int index = indexOf(value);
        sortAsc(0, index - 1);
        sortAsc(index + 1, size - 1);
    }

    public Numb get(int index) {
        if (index > size - 1) throw new ArrayIndexOutOfBoundsException();
        return mathSet[index];
    }

    public Numb getMax() {
        Numb max = get(0);
        for (int i = 1; i < size; i++) {
            if (mathSet[i].compareTo(max) > 0) {
                max = mathSet[i];
            }
        }
        return max;
    }

    public Numb getMin() {
        Numb min = get(0);
        for (int i = 1; i < size; i++) {
            if (mathSet[i].compareTo(min) < 0) {
                min = mathSet[i];
            }
        }
        return min;
    }

    public double getAverage() {
        BigDecimal sum = BigDecimal.valueOf(mathSet[0].doubleValue());
        for (int i = 1; i < size; i++) {
            sum = sum.add(BigDecimal.valueOf(mathSet[i].doubleValue()));
        }
        sum = sum.divide(BigDecimal.valueOf(size));
        return sum.doubleValue();
    }

    public Numb getMedian() {
        return get(size / 2);
    }

    Numb[] toArray() {
        Numb[] result = (Numb[]) new Number[size];
        System.arraycopy(mathSet, 0, result, 0, size);
        return result;
    }

    Numb[] toArray(int firstIndex, int lastIndex) {
        int resultLength = lastIndex - firstIndex;
        Numb[] result = (Numb[]) new Number[resultLength];
        int resultIndex = 0;
        for (int i = firstIndex; i <= lastIndex; i++) {
            result[resultIndex] = mathSet[i];
            resultIndex++;
        }
        return result;
    }

    public MathSet cut(int firstIndex, int lastIndex) {
        Numb[] array = (Numb[]) new Number[lastIndex - firstIndex + 1];
        int arrayIterator = 0;
        for (int i = firstIndex; i <= lastIndex; i++) {
            array[arrayIterator] = mathSet[i];
            arrayIterator++;
        }
        return new MathSet<>(array);

    }

    public void clean() {
        mathSet = (Numb[]) new Number[CAPACITY];
        size = 0;
    }

    void clean(Numb[] numbers) {
        Numb[] copy = (Numb[]) new Number[size];
        System.arraycopy(this.mathSet, 0, copy, 0, size);
        clean();
        for (Numb numb : copy) {
            if (!arrayContains(numbers, numbers.length, numb)) {
                add(numb);
            }
        }
    }

    private boolean notContains(Numb number) {
        return !arrayContains(mathSet, size, number);
    }

    private boolean arrayContains(Numb[] array, int length, Numb number) {
        for (int i = 0; i < length; i++) {
            if (array[i].equals(number)) return true;
        }
        return false;
    }

    private void quickSort(Numb[] array, int low, int high) {
        array = mathSet;
        if (array.length == 0)
            return;
        if (low >= high)
            return;
        int middle = low + (high - low) / 2;
        Numb stand = array[middle];
        int i = low, j = high;
        while (i <= j) {
            while (array[i].compareTo(stand) < 0) {
                i++;
            }
            while (array[j].compareTo(stand) > 0) {
                j--;
            }
            if (i <= j) {
                Numb temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j)
            quickSort(array, low, j);
        if (high > i)
            quickSort(array, i, high);
    }

    private int indexOf(Numb value) {
        for (int i = 0; i < size; i++) {
            if (mathSet[i].equals(value)) {
                return i;
            }
        }
        throw new NoSuchElementException();
    }

    @Override
    public String toString() {
        return "MathSet{" +
                " mathSet = " + Arrays.toString(mathSet) +
                '}';
    }

}
