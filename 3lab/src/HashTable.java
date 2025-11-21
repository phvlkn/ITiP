import java.util.LinkedList;

public class HashTable<K, V> {
    // внутренний класс пара ключ-значение
    private static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() { return key; }
        public V getValue() { return value; }
        public void setValue(V value) { this.value = value; }

        @Override
        public String toString() {
            return key + " = " + value;
        }
    }

    // массив списков
    private LinkedList<Entry<K, V>>[] table;
    private int size;

    public HashTable(int capacity) {
        table = new LinkedList[capacity];
        size = 0;
    }

    // хэш функция, получаем индекс
    private int hash(K key) {
        return Math.abs(key.hashCode() % table.length);
    }

    // добавить или обновить
    public void put(K key, V value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }

        // проверка на наличие ключа
        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value); // обновляем значение
                return;
            }
        }

        // добавление нового
        table[index].add(new Entry<>(key, value));
        size++;
    }

    // получаю значение по ключу
    public V get(K key) {
        int index = hash(key);
        if (table[index] != null) {
            for (Entry<K, V> entry : table[index]) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
        }
        return null; // если не нашли
    }

    // удалить по ключу
    public void remove(K key) {
        int index = hash(key);
        if (table[index] != null) {
            for (Entry<K, V> entry : table[index]) {
                if (entry.getKey().equals(key)) {
                    table[index].remove(entry);
                    size--;
                    return;
                }
            }
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // печать всей таблицы
    public void printTable() {
        for (int i = 0; i < table.length; i++) {
            System.out.print("Index " + i + ": ");
            if (table[i] != null) {
                for (Entry<K, V> entry : table[i]) {
                    System.out.print(entry);
                }
                System.out.println();
            } else {
                System.out.println("пусто");
            }
        }
    }
}