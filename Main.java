import java.util.List;

public class Main {
    public static void main(String[] args) {
        DeliveryFacade deliveryFacade = new DeliveryFacade();

        deliveryFacade.addDelivery("PKG001", "Alice", "Bob", "123 Main St", true);
        deliveryFacade.addDelivery("PKG002", "Charlie", "Dave", "456 Elm St", false);
        deliveryFacade.addDelivery("PKG003", "Lily", "Frank", "789 Oak St", true);
        deliveryFacade.addDelivery("PKG004", "Linda", "Dave", "150 Main St", false);
        deliveryFacade.addDelivery("PKG005", "Ben", "Bob", "9 Oak St", true);

        List<Delivery> deliveries = deliveryFacade.getDeliveries();

        for (Delivery delivery : deliveries) {
            System.out.println(delivery);
            DeliveryContext ctx = deliveryFacade.getDeliveryContext(delivery.getPackageId());
            ctx.printStatus();
            ctx.next();
            ctx.printStatus();
            if (!ctx.getPackageId().equals("PKG002")) { 
                ctx.next();
                ctx.printStatus();
            }
        }
    }
}
