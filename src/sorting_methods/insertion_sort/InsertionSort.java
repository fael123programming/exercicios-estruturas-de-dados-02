package sorting_methods.insertion_sort;

import time_measurement.Time;

public class InsertionSort {
    private String info;

    public void order(int[] numbers) {
        long numberOfComparisons = 0, numberOfMoves = 0;
        Time.startCounting();
        int aux, j;
        numberOfComparisons++;
        for (int i = 1; i < numbers.length; i++) {
            aux = numbers[i];
            numberOfMoves++; //To count the line above.
            numberOfComparisons += 2;
            for (j = i; j > 0 && aux < numbers[j - 1]; j--) {
                numbers[j] = numbers[j - 1];
                numberOfMoves++; //To count the line above.
                numberOfComparisons += 2;
            }
            numbers[j] = aux;
            numberOfMoves++; //To count the line above.
            numberOfComparisons++;
        }
        Time.finishCounting();
        this.info = "Number of moves: " + numberOfMoves + "\nNumber of comparisons: " + numberOfComparisons + "\nTime spent: " + Time.getTime();
    }

    public String getInfo(){
        return this.info;
    }
}
