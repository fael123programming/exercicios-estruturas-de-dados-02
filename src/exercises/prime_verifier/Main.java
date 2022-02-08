package exercises.prime_verifier;

public class Main {
    public static void main(String[] args) {
        PrimeVerifier pv = PrimeVerifier.getInstance();
        System.out.println(pv.isPrime(2147483647));
    }
}
