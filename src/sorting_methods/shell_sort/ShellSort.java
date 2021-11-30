package sorting_methods.shell_sort;

//Another version of insertion sort created by Donald Shell.
//Instead of comparing each element with its next, it goes comparing elements
//between a specific distance called 'h'. This distance is decreased as the algorithm
//moves on. It is useful for moderate-size inputs giving a fast execution maybe better
//than insertion sort.
//It is sensible regarding the initial order of the input.
//It is not stable.
//Smaller elements (known as turtle elements) are handled with more efficiency than insertion sort.

public class ShellSort {
    private static long comparisons, moves;
    private static StringBuilder report;

    public static void sort(int[] numbers) {
        int h = numbers.length / 2, i, aux, j;
        while (h > 0) {
            comparisons++; //At line 18.
            i = h;
            for (; i < numbers.length; i++) {
                comparisons++; //At line 21.
                aux = numbers[i];
                moves++; //At line 23.
                j = i;
                for (; j >= h && aux < numbers[j - h]; numbers[j] = numbers[j - h], j -= h, comparisons += 2, moves++);
                comparisons += 2; //That comparisons that made this for to break.
                numbers[j] = aux;
                moves++; //At line 28.
            }
            comparisons++; //At line 21 that made that for to break.
            h /= 2; //Integer division: the result will be truncated not rounded.
        }
        comparisons++; //At line 18 that made that while to break.
        report = new StringBuilder();
        report.append("Shell Sort\n");
        report.append("Size of the input: ").append(numbers.length).append("\n");
        report.append("Comparisons: ").append(comparisons).append("\n");
        report.append("Moves: ").append(moves).append("\n");
        comparisons = 0;
        moves = 0;
    }

    public static String getReport() {
        if(report == null)
            return null;
        return report.toString();
    }

//    public static void main(String[] args) {
//        int[] numbers = new int[10000];
//        for (int i = 0; i < 10000; i++)
//            numbers[i] = 10000 - i;
//        System.out.println(Arrays.toString(numbers));
//        ShellSort.sort(numbers);
//        for (int i = 0; i < 9999; i++)
//            if (numbers[i] > numbers[i + 1])
//                System.out.println(numbers[i] + " is greater than " + numbers[i + 1]);
//        System.out.println(Arrays.toString(numbers));
//    }
}
