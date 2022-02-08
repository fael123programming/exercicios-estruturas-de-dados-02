package exercises.prime_verifier;

public class PrimeVerifier {
    private static PrimeVerifier primeVerifier;

    private PrimeVerifier() {}

    public static PrimeVerifier getInstance() {
        if (primeVerifier == null)
            primeVerifier = new PrimeVerifier();
        return primeVerifier;
    }

    public boolean isPrime(long number) {
        if (number < 0)
            number *= -1; //Just for more ease...
        if (number == 2 || number == 3 || number == 5 || number == 7)
            return true;
        long sqrt = (long) Math.sqrt(number);
        int divisors = 1;
        for (long i = 2; i <= sqrt; i++)
            if (number % i == 0)
                divisors++;
        return divisors == 1;
    }
}
