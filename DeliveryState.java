public interface DeliveryState {
    void next(DeliveryContext ctx);
    void prev(DeliveryContext ctx);
    void printStatus();
}

class OrderedState implements DeliveryState {
    @Override
    public void next(DeliveryContext ctx) {
        ctx.setState(new ShippedState());
    }

    @Override
    public void prev(DeliveryContext ctx) {
        System.out.println("The package is in its root state.");
    }

    @Override
    public void printStatus() {
        System.out.println("Package ordered, not shipped yet.");
    }
}

class ShippedState implements DeliveryState {
    @Override
    public void next(DeliveryContext ctx) {
        ctx.setState(new DeliveredState());
    }

    @Override
    public void prev(DeliveryContext ctx) {
        ctx.setState(new OrderedState());
    }

    @Override
    public void printStatus() {
        System.out.println("Package shipped.");
    }
}

class DeliveredState implements DeliveryState {
    @Override
    public void next(DeliveryContext ctx) {
        System.out.println("This package is already delivered.");
    }

    @Override
    public void prev(DeliveryContext ctx) {
        ctx.setState(new ShippedState());
    }

    @Override
    public void printStatus() {
        System.out.println("Package delivered.");
    }
}
