package experiments;


import java.util.ArrayList;

public class StringNumbersAdder {

    enum Nums{
        ABC(1),
        DEF(2),
        GHI(3),
        JKL(4),
        MNO(5),
        PQR(6),
        STU(7),
        VWX(8),
        YZ(9);

        int number;
        private Nums(int number){
            this.number = number;
        }
    }

    public static void main(String []args) {
        getResult("raj");
    }
    public static void getResult(String input){
        ArrayList<Integer> numbers = getNumbers(input);
        System.out.println(numbers);
        Integer i = 0;
        for(Integer n : numbers) {
            i = i + n;
        }
        while(i.toString().length() > 1){
            i = addCharacters(i);
        }
        System.out.println("Result = " + i);
    }

    public static Integer addCharacters(Integer i){
        int sum = 0;
        for(char j: i.toString().toCharArray()){
            sum = sum + Character.getNumericValue(j);
        }
        return sum;
    }

    public static ArrayList<Integer> getNumbers(String input){
        ArrayList<Integer> list = new ArrayList<Integer>();
        input = input.toUpperCase();
        for (char c: input.toCharArray()){
            for(Nums n:Nums.values()){
                for(char nc: n.toString().toCharArray()){
                    if(nc == c) list.add(n.number);
                }
            }
        }
        return list;

    }
}
