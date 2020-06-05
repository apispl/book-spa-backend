package pl.pszczolkowski.bookspa.ServicesDecorator;

public abstract class ServiceSheet {

    private long orderId;
    public abstract String serviceType();
    public abstract float basePrice();

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }
}
