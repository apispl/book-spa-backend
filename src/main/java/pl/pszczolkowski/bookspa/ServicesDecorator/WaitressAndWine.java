package pl.pszczolkowski.bookspa.ServicesDecorator;

public class WaitressAndWine extends AdditionalServicesDecorator {

    private ServiceSheet serviceSheet;

    public ServiceSheet getServiceSheet() {
        return serviceSheet;
    }

    public void setServiceSheet(ServiceSheet serviceSheet) {
        this.serviceSheet = serviceSheet;
    }

    public WaitressAndWine(ServiceSheet serviceSheet) {
        this.serviceSheet = serviceSheet;
    }

    @Override
    public String serviceType() {
        return serviceSheet.serviceType() + " with Waitress and Wine";
    }

    @Override
    public float basePrice() {
        return serviceSheet.basePrice() + 250;
    }
}
