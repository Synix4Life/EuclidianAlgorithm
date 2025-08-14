package Algorithm;

import java.util.ArrayList;
import static Algorithm.PrintResult.printingValues;

public class EuclidianAlgorithm {
    /**
     * Method to calculate the extended Euclidean algorithm and print it to the console
     * @param value1 First value, which represents 'a' in the algorithm
     * @param value2 Second value, which represent 'b' in the algorithm
     */
    public static void algorithm(int value1, int value2) {
        var list = new ArrayList<ArrayList<Integer>>();

        int pointer = -1;
        boolean has_ggT = false;
        boolean run = true;
        ArrayList<Integer> inner;

        while (run) {
            inner = new ArrayList<>();
            pointer++;

            if (pointer == 0) {
                inner.add(value1);
                inner.add(value2);
            } else {
                inner.add(list.get(pointer - 1).get(1));
                inner.add(list.get(pointer - 1).get(0) - list.get(pointer - 1).get(1) * list.get(pointer - 1).get(2));
            }

            if (inner.get(1) == 1) {
                run = false;
                inner.add(-10);
            } else if (inner.get(1) == 0) {
                run = false;
                has_ggT = true;
                inner.add(-10);
            } else {inner.add(greatestMultiplier(inner.get(0), inner.get(1)));}

            list.add(inner);
        }

        if (has_ggT) {
            list.get(pointer).add(1);
            list.get(pointer).add(0);
        } else {
            list.get(pointer).add(0);
            list.get(pointer).add(1);
        }

        while (pointer != 0) {
            pointer--;
            list.get(pointer).add(list.get(pointer + 1).get(4));
            list.get(pointer).add(
                    list.get(pointer + 1).get(3) - list.get(pointer).get(2) * list.get(pointer + 1).get(4)
            );
        }

        list.get(list.size()-1).remove(2);
        printingValues(list);
    }

    /**
     * Method to find the greatest possible whole positive number n, so that first <= second * n
     * @param first Number, which the result multiplied with the found number should be less equal to
     * @param second Number, which multiplied with n, should be less equal to a
     * @return The greatest multiplier
     */
    private static int greatestMultiplier(Integer first, Integer second){return (int) Math.floor((double) first /second);}
}