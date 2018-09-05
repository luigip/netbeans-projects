package experiments;

import java.util.Arrays;

public class ArrayCopySpeedTest implements Runnable {

    interface Sarr {

        public String[] get();
    }

    public void run() {
        long ts, tc, ta;
        String[] s = new Sarr() {

            public String[] get() {
                String[] ret = new String[1000];
                for (int i = 0; i < 1000; i++) {
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < 10; j++) {
                        sb.append((char) (Math.random() * 26 + 'a'));
                    }
                    ret[i] = sb.toString();
                }
                return ret;
            }
        }.get();
//        System.out.println(Arrays.toString(s));

        int reps = 1000000;
        ts = System.nanoTime();
        for (int i = 0; i < reps; i++) {
            sys(s);
        }
        System.out.println((System.nanoTime() - ts) / 1000000d);
        System.gc();
        
        ts = System.nanoTime();
        for (int i = 0; i < reps; i++) {
            arr(s);
        }
        System.out.println((System.nanoTime() - ts) / 1000000d);
        System.gc();
        
        ts = System.nanoTime();
        for (int i = 0; i < reps; i++) {
            clo(s);
        }
        System.out.println((System.nanoTime() - ts) / 1000000d);
    }

    private void sys(String[] s) {
        String[] c = new String[s.length];
        System.arraycopy(s, 0, c, 0, c.length);
    }

    private void clo(String[] s) {
        String[] c = s.clone();
    }

    private void arr(String[] s) {
        String[] c = Arrays.copyOf(s, s.length);
    }

    public static void main(String[] args) {
        new ArrayCopySpeedTest().run();
    }
}
