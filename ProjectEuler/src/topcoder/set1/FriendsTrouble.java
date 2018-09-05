package topcoder.set1;

public class FriendsTrouble {

    public int divide(String[] names, String[] friends) {
        int n = names.length;
        int[] group = new int[n];
        for (int i = 0; i < n; i++) {
            group[i] = i;
        }
        for(String s : friends){
            String[] fr = s.split(" ");
            int[] index = new int[2];
            for (int i = 0; i < n; i++) {
                if(names[i].equals(fr[0])) index[0] = i;
                if(names[i].equals(fr[1])) index[1] = i;
            }
            int newGroup = group[index[0]], oldGroup = group[index[1]];
            for (int i = 0; i < n; i++) {
                if(group[i] == oldGroup) group[i] = newGroup;
            }
        }
        boolean[] groups = new boolean[n];
        int count = 0;
        for(int i : group){
            if(!groups[i]) count++;
            groups[i] = true;
        }
        return count;
    }

    public static void main(String[] args) {
        FriendsTrouble f = new FriendsTrouble();
        String[] s1 = {"AA", "AB", "AC", "AD", "AE", "AF", "AG", "AH", "AI", "AJ", "AK", "AL", "AM", "AN", "AO", "AP", "AQ", "AR", "AS", "AT", "AU", "AV", "AW", "AX", "AY", "BA", "BB", "BC", "BD", "BE", "BF", "BG", "BH", "BI", "BJ", "BK", "BL", "BM", "BN", "BO", "BP", "BQ", "BR", "BS", "BT", "BU", "BV", "BW", "BX", "BY"};
        String[] s2 = {"AA AD", "AB AE", "AC AF", "AD AG", "AE AH", "AF AI", "AG AJ", "AH AK", "AI AL", "AJ AM", "AK AN", "AL AO", "AM AP", "AN AQ", "AO AR", "AP AS", "AQ AT", "AR AU", "AS AV", "AT AW", "AU AX", "AV AY", "AW BA", "AX BB", "AY BC", "BA BD", "BB BE", "BC BF", "BD BG", "BE BH", "BF BI", "BG BJ", "BH BK", "BI BL", "BJ BM", "BK BN", "BL BO", "BM BP", "BN BQ", "BO BR", "BP BS", "BQ BT", "BR BU", "BS BV", "BT BW", "BU BX", "BV BY", "BW AA", "BX AB", "BY AC"};

        System.out.println(f.divide(s1, s2));
    }
}
