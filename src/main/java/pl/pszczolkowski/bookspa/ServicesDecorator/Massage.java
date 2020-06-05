package pl.pszczolkowski.bookspa.ServicesDecorator;

public class Massage extends ServiceSheet {

    @Override
    public String serviceType() {
        return "Massage";
    }

    @Override
    public float basePrice() {
        return 220;
    }
}
