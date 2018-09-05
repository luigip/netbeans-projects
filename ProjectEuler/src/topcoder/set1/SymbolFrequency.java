package topcoder.set1;

public class SymbolFrequency {

    public double language(String[] frequencies, String[] text) {
        double devsMin = -1;
        String allText = "";
        for (String s : text) {
            allText += s.replace(" ", "");
        }
        int[] count = new int[26];
        for (char c : allText.toCharArray()) {
            count[c - 'a']++;
        }
        for (int fset = 0; fset < frequencies.length; fset++) {

            double[] expected = new double[26];
            for (int i = 0; i < frequencies[fset].length(); i += 3) {
                char letter = frequencies[fset].charAt(i);

                double freq = Double.parseDouble(frequencies[fset].substring(i + 1, i + 3)) / 100;
                expected[letter - 'a'] = freq;
            }
            double deviation = 0;
            for (int i = 0; i < expected.length; i++) {
                double expectedCount = expected[i] * allText.length();
                deviation += Math.pow(expectedCount - count[i], 2);
            }
            if (deviation < devsMin || devsMin == -1) {
                devsMin = deviation;
            }
        }
        return devsMin;
    }

    public static void main(String[] args) {
        SymbolFrequency s = new SymbolFrequency();

        String[] f3 = {"a09b01c03d05e20g01h01i08l06n08o06r07s09t08u07x01", "a14b02c05d06e15g01h01i07l05n07o10r08s09t05u04x01"};
        String[] t3 = {"this text is in english", "the letter counts should be close to", "that in the table"};
        String[] f0 = {"a30b30c40", "a20b40c40"};
        String[] t0 = {"aa bbbb cccc"};

        double d = s.language(f3, t3);
        System.out.println(d);
    }
}
