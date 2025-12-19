import java.util.*;

public class SalesApp {
    static class Sale {
        private String product;
        private int quantity;
        private double price;

        public Sale(String product, int quantity, double price){
            this.product = product;
            this.quantity = quantity;
            this.price = price;
        }

        public String getProduct(){
            return product;
        }
        public int getQuantity(){
            return quantity;
        }
        public double getPrice(){
            return price;   
        }
        public double getTotal(){
            return quantity * price;
        }

        @Override
        public String toString(){
            return "Product: " + product + ", Quantity: " + quantity + ", Price: " + price + ", Total: " + getTotal();
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Sale> sales = new ArrayList<>();

        while(true){
            System.out.println("Учет продаж на arraylist\n 1. Добавить продажу\n 2. Показать все продажи\n 3. Показать общую сумму продаж\n 4. Самый популярный товар\n 0. Выход\n Выбор:");
            int choice = sc.nextInt();
            sc.nextLine();
            if(choice == 0){
                break;
            }
            switch(choice){
                case 1:
                    System.out.print("Название товара: ");
                    String product = sc.nextLine().trim();
                    System.out.print("Количество: ");
                    int qty = sc.nextInt();
                    System.out.print("Цена за единицу: ");
                    double price = sc.nextDouble();
                    sales.add(new Sale(product, qty, price));
                    break;
                case 2:
                    if (sales.isEmpty()) {
                        System.out.println("Нет записей о продажах.");
                    } else {
                        for (Sale s : sales) {
                            System.out.println(s.toString());
                        }
                    }   
                    break;
                case 3:
                    double total = 0;
                    for (Sale s : sales) {
                        total += s.getTotal();
                    }
                    System.out.println("Общая сумма продаж: " + total);
                    break;
                case 4:
                    if (sales.isEmpty()) {
                        System.out.println("Нет записей о продажах.");
                    } else {
                        Map<String, Integer> productCount = new HashMap<>();
                        for (Sale s : sales) {
                            productCount.put(s.getProduct().toLowerCase(), productCount.getOrDefault(s.getProduct().toLowerCase(), 0) + s.getQuantity());
                        }
                        String bestProduct = "";
                        int maxCount = 0;
                        for (Map.Entry<String, Integer> entry : productCount.entrySet()) {
                            if (entry.getValue() > maxCount) {
                                maxCount = entry.getValue();
                                bestProduct = entry.getKey();
                            }
                        }
                        System.out.println("Самый популярный товар: " + bestProduct + " (Продано: " + maxCount + ")");
                    }
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }
}