package pl.pszczolkowski.bookspa.ServicesDecorator;

public class Pedicure extends ServiceSheet {

    @Override
    public String serviceType() {
        return "Pedicure";
    }

    @Override
    public float basePrice() {
        return 80;
    }
}
