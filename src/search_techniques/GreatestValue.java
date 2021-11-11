package search_techniques;

public class GreatestValue {
    public static int greatest(int n, int...input) {
        return n == 0 ? input[0] : gr(greatest(n - 1, input), input[n - 1]);
    }

    private static int gr(int a, int b) {
        return a > b ? a : b;
    }
}
