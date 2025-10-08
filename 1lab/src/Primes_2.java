public class Primes_2 {

    public static void main(String[] args) {
        int limit = 100;
        boolean[] isPrime = sieve(limit);

        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) {
                System.out.println(i);
            }
        }
    }

    public static boolean[] sieve(int n) {
        boolean[] prime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            prime[i] = true;
        }

        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int j = p * p; j <= n; j += p) {
                    prime[j] = false;
                }
            }
        }

        return prime;
    }
}