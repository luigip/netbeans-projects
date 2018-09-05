package scratch;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Utility {

    public static <T> List<T> mkList(T... x) {
        List<T> r = new LinkedList<T>();
        r.addAll(Arrays.asList(x));
        return r;
    }
}
