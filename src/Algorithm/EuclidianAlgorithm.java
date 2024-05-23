package Algorithm;

import java.util.ArrayList;

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
    public static int greatestMultiplier(Integer first, Integer second){return (int) Math.floor((double) first /second);}

    /**
     * Method to print the result of the extended Euclidean algorithm in its natural form of representation as a table of values, due to its construction with intelligent spacing
     * @param list The list with the values to print
     */
    public static void printingValues(ArrayList<ArrayList<Integer>> list) {
        boolean isEmpty = false;
        int[] greatest = new int[5];
        var printout = new String[]{"a", "b", "q", "x", "y"};
        for(int u= 0; u< printout.length; u++){
            System.out.print(printout[u]);
            greatest[u] = greatestSpace(list, u);
            for(int k=0; k< greatest[u]; k++){
                System.out.print("\t");
            }
        }
        System.out.println(" ");

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                if (i == list.size() - 1 && j == 2) {
                    for(int l = 0; l < calcTheSpace(list.get(i).get(j), greatest[j]); l++){
                        System.out.print("\t");
                        isEmpty = true;
                    }
                }
                System.out.print(list.get(i).get(j));
                for(int l = 0; l < calcTheSpace(list.get(i).get(j), isEmpty ? greatest[j+1]: greatest[j]); l++){
                    System.out.print("\t");
                }
            }
            System.out.println(" ");
        }
        System.out.println("\n");
    }

    /**
     * Method to calculate the greatest spaces in tabs needed to format the table correctly
     * @param list The list, to iterate through the elements and get the correct spacing
     * @param index Column index, of which the amount of tabs should be calculated
     * @return Number of tabs to format the output table correctly
     */
    public static int greatestSpace(ArrayList<ArrayList<Integer>> list, int index){
        int greatest = 0;
        int len;
        for (ArrayList<Integer> integers : list) {
            for (int j = 0; j < integers.size(); j++) {
                if (j == index) {
                    len = integers.get(j).toString().length();
                    if (len > greatest) {
                        greatest = len;
                    }
                }
            }
        }
        return switch (greatest){
            case 1, 2, 3 -> 1;
            case 4, 5, 6, 7 -> 2;
            case 8, 9, 10, 11 -> 3;
            default -> 4;
        };
    }

    /**
     * Method to calculate the tabs after a value has been printed
     * @param item the Item to calculate the optimal amount of tabs for formatting
     * @param greatest The greatest amount of tabs in the specific column
     * @return Number of Tabs required for a correct spacing
     */
    public static int calcTheSpace(Integer item, Integer greatest){
        return switch (item.toString().length()) {
            case 1, 2, 3 -> greatest;
            case 4, 5, 6, 7 -> greatest - 1;
            case 8, 9, 10, 11 -> greatest - 2;
            default -> greatest - 3;
        };
    }
}