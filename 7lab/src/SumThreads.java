import java.util.*;

public class SumThreads {

    static class SumThread extends Thread {
        private final int[] a;
        private final int l, r; // [l, r)
        private long sum;

        SumThread(int[] a, int l, int r) {
            this.a = a;
            this.l = l;
            this.r = r;
        }

        @Override
        public void run() {
            long s = 0;
            for (int i = l; i < r; i++) s += a[i];
            sum = s;
        }

        public long getSum() {
            return sum;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();

        int mid = n / 2;

        SumThread t1 = new SumThread(a, 0, mid);
        SumThread t2 = new SumThread(a, mid, n);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        long total = t1.getSum() + t2.getSum();
        System.out.println(total);
    }
}