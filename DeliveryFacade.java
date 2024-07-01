import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeliveryFacade {
    private List<Delivery> deliveries;
    private Map<String, DeliveryContext> deliveryContexts;

    public DeliveryFacade() {
        deliveries = new ArrayList<>();
        deliveryContexts = new HashMap<>();
    }

    public void addDelivery(String packageId, String sender, String recipient, String address, boolean isFragile) {
        Delivery delivery = new Delivery.Builder()
                .setPackageId(packageId)
                .setSender(sender)
                .setRecipient(recipient)
                .setAddress(address)
                .setIsFragile(isFragile)
                .build();
        deliveries.add(delivery);
        deliveryContexts.put(packageId, new DeliveryContext(null, packageId));
    }

    public void removeDelivery(Delivery delivery) {
        deliveries.remove(delivery);
        deliveryContexts.remove(delivery.getPackageId());
    }

    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    public DeliveryContext getDeliveryContext(String packageId) {
        return deliveryContexts.get(packageId);
    }
}
