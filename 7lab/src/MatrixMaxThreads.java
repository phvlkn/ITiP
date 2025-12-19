import java.util.*;

public class MatrixMaxThreads {

    static class RowMaxThread extends Thread {
        private final int[][] m;
        private final int row;
        private int rowMax;

        RowMaxThread(int[][] m, int row) {
            this.m = m;
            this.row = row;
        }

        @Override
        public void run() {
            int mx = m[row][0];
            for (int j = 1; j < m[row].length; j++) {
                if (m[row][j] > mx) mx = m[row][j];
            }
            rowMax = mx;
        }

        public int getRowMax() {
            return rowMax;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); 
        int k = sc.nextInt(); 
        int[][] m = new int[n][k];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < k; j++)
                m[i][j] = sc.nextInt();

        RowMaxThread[] threads = new RowMaxThread[n];
        for (int i = 0; i < n; i++) {
            threads[i] = new RowMaxThread(m, i);
            threads[i].start();
        }

        for (int i = 0; i < n; i++) threads[i].join();

        int globalMax = threads[0].getRowMax();
        for (int i = 1; i < n; i++) {
            if(threads[i].getRowMax() > globalMax)
                globalMax = threads[i].getRowMax(); 
        }

        System.out.println(globalMax);
    }
}