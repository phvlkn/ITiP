public abstract class Appliance {
    private String brand;
    private double power;
    private double price;
    private static int count = 0;

    public Appliance(String brand, double power, double price) {
        this.brand = brand;
        this.power = power;
        this.price = price;
        count++;
    }

    public Appliance() {
        this("Неизвестно", 0, 0);
    }

    public abstract void turnOn();
    public abstract void turnOff();

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static int getCount() {
        return count;
    }
}