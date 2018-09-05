package topcoder.set1;

public class FountainOfLife {
    public double elixirOfDeath(int elixir, int poison, int pool){
        if(elixir >= poison) return -1.0;
        
        
        
        return (0.5 * pool) / (poison - 0.5 *(elixir + poison));
    }
            
}
