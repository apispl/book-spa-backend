package pl.pszczolkowski.bookspa.ServicesDecorator;

public class BodyPeeling extends ServiceSheet {

    @Override
    public String serviceType() {
        return "BodyPeeling";
    }

    @Override
    public float basePrice() {
        return 120;
    }
}
