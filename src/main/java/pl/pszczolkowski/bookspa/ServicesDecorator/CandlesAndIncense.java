package pl.pszczolkowski.bookspa.ServicesDecorator;

public class CandlesAndIncense extends AdditionalServicesDecorator {

    private ServiceSheet serviceSheet;

    public CandlesAndIncense(ServiceSheet serviceSheet) {
        this.serviceSheet = serviceSheet;
    }

    @Override
    public String serviceType() {
        return serviceSheet.serviceType() + " with Candles and Incense";
    }

    @Override
    public float basePrice() {
        return serviceSheet.basePrice() + 80;
    }
}
