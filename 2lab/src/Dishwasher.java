public class Dishwasher extends Appliance {
    private int capacity;

    public Dishwasher(String brand, double power, double price, int capacity) {
        super(brand, power, price);
        this.capacity = capacity;
    }

    public Dishwasher() {
        super();
        this.capacity = 10;
    }

    @Override
    public void turnOn() {
        System.out.println("Посудомоечная машина запущена. Вместимость: " + capacity + " комплектов.");
    }

    @Override
    public void turnOff() {
        System.out.println("Посудомоечная машина завершила работу.");
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}