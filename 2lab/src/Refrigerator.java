public class Refrigerator extends Appliance {
    private double temperature;

    public Refrigerator(String brand, double power, double price, double temperature) {
        super(brand, power, price);
        this.temperature = temperature;
    }

    public Refrigerator() {
        super();
        this.temperature = 4;
    }

    @Override
    public void turnOn() {
        System.out.println("Холодильник включен. Температура: " + temperature + "°C");
    }

    @Override
    public void turnOff() {
        System.out.println("Холодильник выключен.");
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}