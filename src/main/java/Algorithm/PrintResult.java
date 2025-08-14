package Algorithm;

import java.util.ArrayList;

public class PrintResult{
    /**
     * Method to print the result of the extended Euclidean algorithm in its natural form of representation as a table of values
     * @param list The list with the values to print
     */
    public static void printingValues(ArrayList<ArrayList<Integer>> list){
        int len = list.size();
        System.out.printf("%10s %10s %10s %10s %10s%n", "a", "b", "q", "x", "y");
        for(int i=0; i<len-1; i++) {
            System.out.printf(
                    "%10d %10d %10d %10d %10d%n",
                    list.get(i).get(0), list.get(i).get(1), list.get(i).get(2), list.get(i).get(3), list.get(i).get(4)
            );
        }
        System.out.printf(
                "%10d %10d %10s %10d %10d%n%n",
                list.get(len-1).get(0), list.get(len-1).get(1), " ", list.get(len-1).get(2), list.get(len-1).get(3)
        );
    }
}