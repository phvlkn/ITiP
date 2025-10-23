public class Main {
    public static void main(String[] args) {
        Refrigerator fridge = new Refrigerator("LG", 250, 45000, 3.5);
        Dishwasher washer = new Dishwasher("Bosch", 1800, 60000, 12);
        VacuumCleaner vacuum = new VacuumCleaner("Dyson", 900, 70000, "Беспроводной");
        fridge.setBrand("Liebherr");
        Dishwasher appl = new Dishwasher();
        System.out.println(appl.getBrand());

        fridge.turnOn();
        washer.turnOn();
        vacuum.turnOn();

        System.out.println("Всего создано объектов: " + Appliance.getCount());
    }
}