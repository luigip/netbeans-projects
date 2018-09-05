package projecteuler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class Common {

    @Deprecated
    static ArrayList<Integer> getPrimesList(long upto) {
        //Much slower than sieve
        ArrayList<Integer> primes = new ArrayList<Integer>();
        primes.add(2);
        int i = 1;
        while (i < upto - 2) {
            i += 2;
            if (checkPrime(i, primes)) {
                primes.add(i);
            }
        }
        return primes;
    }

    static boolean checkPrime(int num, List<Integer> primeList) {
        int sqr = (int) Math.sqrt(num) + 1;
        for (Integer prime : primeList) {
            if (prime > sqr) {
                return true;
            }
            if (num % prime == 0) {
                return false;
            }
        }
        return true;
    }

    @Deprecated
    static boolean[] getPrimesSieve(int upto) {
        boolean[] sieve = new boolean[upto + 1];
        Arrays.fill(sieve, true);
        sieve[0] = sieve[1] = false;
        for (int i = 2; i < sieve.length; i++) {
            if (sieve[i]) {
                for (int j = i + i; j < sieve.length; j += i) {
                    sieve[j] = false;
                }
            }
        }
        return sieve;
    }

    @Deprecated
    static ArrayList<Integer> getPrimesListSieve(int upto) {
        ArrayList<Integer> primes = new ArrayList<Integer>();
        boolean[] sieve = new boolean[upto + 1];
        Arrays.fill(sieve, true);
        sieve[0] = sieve[1] = false;
        for (int i = 2; i < sieve.length; i++) {
            if (sieve[i]) {
                primes.add(i);
                for (int j = i + i; j < sieve.length; j += i) {
                    sieve[j] = false;
                }
            }
        }
        return primes;
    }

    @Deprecated
    static ArrayList<Integer> getPrimesListSieveV2(int upto) {
        ArrayList<Integer> primes = new ArrayList<Integer>();
        boolean[] sieve = new boolean[upto + 1];
        sieve[2] = true;
        primes.add(2);
        for (int i = 3; i < sieve.length; i += 2) {
            sieve[i] = true;
        }
        sieve[0] = sieve[1] = false;
        for (int i = 3; i < sieve.length; i += 2) {
            if (sieve[i]) {
                primes.add(i);
                for (int j = i + i; j < sieve.length; j += i) {
                    sieve[j] = false;
                }
            }
        }
        return primes;
    }

    static ArrayList<Integer> getPrimesListSieveV3(int upto) {
        ArrayList<Integer> primes = new ArrayList<Integer>();
        boolean[] sieve = new boolean[upto + 1];
        sieve[2] = true;
        primes.add(2);
        for (int i = 3; i < sieve.length; i += 2) {
            sieve[i] = true;
        }
        int sqrt = (int) Math.sqrt(sieve.length);
        for (int i = 3; i <= sqrt; i += 2) {
            if (sieve[i]) {
                for (int j = 3 * i; j < sieve.length; j += 2 * i) {
                    sieve[j] = false;
                }
            }
        }
        for (int i = 3; i < sieve.length; i += 2) {
            if (sieve[i]) {
                primes.add(i);
            }
        }
        return primes;
    }

    static boolean[] getPrimesSieveV3(int upto) {
        boolean[] sieve = new boolean[upto + 1];
        int sqrt = (int) Math.sqrt(sieve.length);
        sieve[2] = true;
        for (int i = 3; i < sieve.length; i += 2) {
            sieve[i] = true;
        }
        for (int i = 3; i <= sqrt; i += 2) {
            if (sieve[i]) {
                for (int j = 3 * i; j < sieve.length; j += 2 * i) {
                    sieve[j] = false;
                }
            }
        }
        return sieve;
    }

    @Deprecated
    static ArrayList<Integer> getPrimesListEuler(int upto) {
        //Don't use - slow!!
        TreeSet<Integer> possPrimes = new TreeSet<Integer>();
        ArrayList<Integer> primes = new ArrayList<Integer>();
        boolean[] sieve = new boolean[upto + 1];
        sieve[2] = true;
        primes.add(2);
        for (int i = 3; i < sieve.length; i += 2) {
            sieve[i] = true;
            possPrimes.add(i);
        }
        for (int i = 3; i < sieve.length; i += 2) {
            if (sieve[i]) {
                primes.add(i);
                if (i <= Math.sqrt(upto)) {
                    ArrayList<Integer> primesThisIter = new ArrayList<Integer>();
                    for (int p : possPrimes) {
                        if (i * p < sieve.length) {
                            sieve[i * p] = false;
                            primesThisIter.add(Integer.valueOf(i * p));
                        } else {
                            break;
                        }
                    }
                    possPrimes.remove(i);
                    for (Integer p : primesThisIter) {
                        possPrimes.remove(p);
                    }
                }
            }
        }
        return primes;
    }

    public static void main(String[] args) {
        final int upto = 500;
        ArrayList<Integer> pr = getPrimesListSieveV2(upto);
        ArrayList<Integer> prS = getPrimesListSieveV3(upto);
        Iterator<Integer> its = prS.iterator();
        for (int p : pr) {
            System.out.print(p + " ");
            if (its.hasNext()) {
                System.out.println(its.next());
            }
        }
        System.out.println("Total primes: " + pr.size());
        System.out.println("Check: " + prS.size());
    }

    public static void main2(String[] args) {
        testBiggestSieve();
    }

    static void testBiggestSieve() {
        int max = 150000000;
        boolean[] a = getPrimesSieveV3(max);
    }
}
