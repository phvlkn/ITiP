public class VacuumCleaner extends Appliance {
    private String type;

    public VacuumCleaner(String brand, double power, double price, String type) {
        super(brand, power, price);
        this.type = type;
    }

    public VacuumCleaner() {
        super();
        this.type = "Вертикальный";
    }

    @Override
    public void turnOn() {
        System.out.println("Пылесос включен. Тип: " + type);
    }

    @Override
    public void turnOff() {
        System.out.println("Пылесос выключен.");
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}