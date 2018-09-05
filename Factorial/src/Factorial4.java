import java.math.BigInteger;
import java.util.ArrayList;

class Factorial4 {
  protected static ArrayList table = new ArrayList(); // create cache
  static { // Initialize the first element of the cache with !0 = 1.
    table.add(BigInteger.valueOf(1));
  }

  /** The factorial() method, using BigIntegers cached in a ArrayList */
  public static synchronized BigInteger factorial(int x) {
    if (x < 0)
      throw new IllegalArgumentException("x must be non-negative.");
    for (int size = table.size(); size <= x; size++) {
      BigInteger lastfact = (BigInteger) table.get(size - 1);
      BigInteger nextfact = lastfact.multiply(BigInteger.valueOf(size));
      table.add(nextfact);
    }
    return (BigInteger) table.get(x);
  }

  /**
   * A simple main() method that we can use as a standalone test program for
   * our factorial() method.
   */
  public static void main(String[] args) {
    for (int i = 0; i <= 300; i++){
      BigInteger b = factorial(i);
      System.out.printf(i + "! = " + "(" + b.toString().length() + " chars) "+ "%,d \n", b);
      }
  }
}