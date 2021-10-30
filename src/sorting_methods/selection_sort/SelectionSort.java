package sorting_methods.selection_sort;

import time_measurement.Time;

public class SelectionSort {
    private String info;

    public void order(int[] numbers) {
        long numberOfMoves = 0, numberOfComparisons = 0;
        Time.startCounting();
        int aux, posMin;
        numberOfComparisons++;
        for (int i = 0; i < numbers.length - 1; i++) {
            posMin = i;
            numberOfComparisons++;
            for (int j = i + 1; j < numbers.length; j++) {
                numberOfComparisons++;
                if (numbers[j] < numbers[posMin]) {
                    posMin = j;
                }
                numberOfComparisons++;
            }
            numberOfComparisons++;
            if (i != posMin) {
                aux = numbers[i];
                numbers[i] = numbers[posMin];
                numbers[posMin] = aux;
                numberOfMoves += 3;
            }
            numberOfComparisons++;
        }
        Time.finishCounting();
        this.info = "Number of moves: " + numberOfMoves + "\nNumber of comparisons: " + numberOfComparisons + "\nTime spent: " + Time.getTime();
    }

    public String getInfo(){
        return this.info;
    }
}
