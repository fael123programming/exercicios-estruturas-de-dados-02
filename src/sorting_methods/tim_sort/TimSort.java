package sorting_methods.tim_sort;

//The main idea of this algorithm is the following:
//-> We break our input down into smaller pieces of data sets that are with a good percentage of order;
//-> After, we apply Insertion Sort (or a similar algorithm like Bubble Sort) on these groups of data;
//-> Finally, Merge Sort is used to merge all those sets together making our input array sorted.
//Main principles:
//-> Use two sorting algorithms on their most optimized versions. They are, namely,
//Insertion Sort and Merge Sort;
//-> Divide your input array into smaller chunks of numbers;
//Here there is a point: these chunks must be of size 32 up to 64 (2 ^ 5 up to 2 ^ 6);
//Why? Insertion Sort works better with arrays of this size!

public class TimSort {
    public static void sort(int[] numbers) {

    }
}
