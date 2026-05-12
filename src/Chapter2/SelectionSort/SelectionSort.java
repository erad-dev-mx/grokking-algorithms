package Chapter2.SelectionSort;

import java.util.ArrayList;
import java.util.Arrays;

public class SelectionSort {
    private int findSmallest(ArrayList<Integer> arr) {
        int smallest = arr.get(0);
        int smallestIndex = 0;

        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) < smallest) {
                smallest = arr.get(i);
                smallestIndex = i;
            }
        }

        return smallestIndex;
    }

    public ArrayList<Integer> selectionSort(ArrayList<Integer> arr) {
        ArrayList<Integer> newArr = new ArrayList<>();
        ArrayList<Integer> copiedArr = new ArrayList<>(arr);

        while (!copiedArr.isEmpty()) {
            int smallest = findSmallest(copiedArr);
            newArr.add(copiedArr.remove(smallest));
        }

        return newArr;
    }

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(5,3,6,2,10));
        System.out.println(new SelectionSort().selectionSort(numbers));
    }
}
