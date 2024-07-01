public class DeliveryContext {
    private DeliveryState currentState;
    private String packageId;

    public DeliveryContext(DeliveryState state, String packageId) {
        this.currentState = state;
        this.packageId = packageId;

        if (state == null) {
            this.currentState = new OrderedState();
        }
    }
    
    //Встановлює поточний стан доставки.
    public void setState(DeliveryState state) {
        this.currentState = state;
    }
    //Переміщує стан доставки до наступного стану.
    public void next() {
        currentState.next(this);
    }

    //Переміщує стан доставки до попереднього стану.
    public void prev() {
        currentState.prev(this);
    }

    public void printStatus() {
        currentState.printStatus();
    }

    public String getPackageId() {
        return packageId;
    }
}
