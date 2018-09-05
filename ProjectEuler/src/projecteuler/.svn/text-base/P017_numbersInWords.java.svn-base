package projecteuler;

public class P017_numbersInWords implements Runnable{
    public void run(){

        int chars1to1000 = 0;
        int chars1to99 = 0;
        for (int i = 1; i <= 99; i++) {
            chars1to99 += lengthNoSpaces(i);
        }
        System.out.println("1 to 99: " + chars1to99);

        //"hundreds"
        //"hundred and" has 10 chars; miss out "and" for zero
        int chars100s = 0;
        for (int i = 1; i <= 9; i++) {
            chars100s += (lengthNoSpaces(i) + 10 ) * 100  - 3;
            chars100s += chars1to99;
        }
        chars1to1000 = chars1to99 + chars100s + 11;
        System.out.println("1 to 1000: " + chars1to1000);
    }

    public static int lengthNoSpaces(int i){
        String s = NumberToWords.numberToWords(i);
        int length = s.length();
        for (char c : s.toCharArray()){
            if (Character.toString(c).equals(" ")) length -= 1;
        }
        return length;
    }
}


class NumberToWords {

	private static final String[] ONES = {
		"Zero", "One", "Two", "Three", "Four", "Five",
		"Six", "Seven", "Eight", "Nine" };
	private static final String[] TEENS = {
		"Ten", "Eleven", "Twelve", "Thirteen", null, "Fifteen",
		null, null, "Eighteen", null };
	private static final String[] TENS = {
		null, null, "Twenty", "Thirty", "Forty", "Fifty",
		"Sixty", "Seventy", "Eighty", "Ninety" };

	public static String numberToWords(int number) {
		if (number<10) {
			return ONES[number];
		} else if (number<20) {
			int n = number - 10;
			String words = TEENS[n];
			return words==null ? ONES[n]+"teen" : TEENS[n];
		} else {
			int n = number % 10;
			return TENS[number/10] +
				(n==0 ? "" : (" " + numberToWords(n)));
		}
	}

	public static void main(String[] args) {
		for (int i=0; i<100; i++) {
			System.out.println(i+" "+numberToWords(i));
		}
            new P017_numbersInWords().run();
	}
}
