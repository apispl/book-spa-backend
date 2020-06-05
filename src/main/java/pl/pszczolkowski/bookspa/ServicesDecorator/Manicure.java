package pl.pszczolkowski.bookspa.ServicesDecorator;

public class Manicure extends ServiceSheet {

    @Override
    public String serviceType() {
        return "Manicure";
    }

    @Override
    public float basePrice() {
        return 50;
    }
}
