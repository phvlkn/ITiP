import java.util.*;

public class WarehouseThreads {

    static class Item {
        final String name;
        final int weight;

        Item(String name, int weight) {
            this.name = name;
            this.weight = weight;
        }
    }

    static class Warehouse {
        private final Deque<Item> items = new ArrayDeque<>();

        public synchronized void add(Item it) {
            items.addLast(it);
        }

        // выдем партию товаров со склада не более limit, 150
        public synchronized List<Item> takeBatch(int limit) {
            if (items.isEmpty()) return Collections.emptyList();

            List<Item> batch = new ArrayList<>();
            int total = 0;

            // берём по очереди, пока помещается
            while (!items.isEmpty()) {
                Item next = items.peekFirst();
                if (total + next.weight > limit)
                    break;
                batch.add(items.removeFirst());
                total += next.weight;
            }
            return batch;
        }

        public synchronized boolean isEmpty() {
            return items.isEmpty();
        }

        public synchronized int count() {
            return items.size();
        }
    }

    static class Loader extends Thread {
        private final Warehouse from;
        private final Warehouse to;
        private final int limit;

        Loader(String name, Warehouse from, Warehouse to, int limit) {
            super(name);
            this.from = from;
            this.to = to;
            this.limit = limit;
        }

        @Override
        public void run() {
            while (true) {
                List<Item> batch = from.takeBatch(limit);

                if (batch.isEmpty()) {
                    //если склад пуст завершаемся
                    if (from.isEmpty()) break;
                    break;
                }

                // перенос на другой склад
                for (Item it : batch) {
                    to.add(it);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//кол-во товаров

        Warehouse w1 = new Warehouse();
        Warehouse w2 = new Warehouse();

        for (int i = 0; i < n; i++) {
            String name = sc.next(); 
            int weight = sc.nextInt();
            w1.add(new Item(name, weight));
        }

        int limit = 150;

        Loader l1 = new Loader("грузчик 1", w1, w2, limit);
        Loader l2 = new Loader("грузчик 2", w1, w2, limit);
        Loader l3 = new Loader("грузчик 3", w1, w2, limit);

        l1.start();
        l2.start();
        l3.start();

        l1.join();
        l2.join();
        l3.join();

        System.out.println(w2.count());
    }
}