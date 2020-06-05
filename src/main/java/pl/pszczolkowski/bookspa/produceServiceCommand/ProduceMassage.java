package pl.pszczolkowski.bookspa.produceServiceCommand;

import pl.pszczolkowski.bookspa.ServicesDecorator.AdditionalServicesDecorator;
import pl.pszczolkowski.bookspa.ServicesDecorator.Massage;
import pl.pszczolkowski.bookspa.ServicesDecorator.ServiceSheet;
import pl.pszczolkowski.bookspa.model.OrderRequest;

public class ProduceMassage implements Command {
    @Override
    public ServiceSheet produceSerShe(OrderRequest orderRequest) {
        Massage massage = new Massage();
        massage.setOrderId(orderRequest.getId());
        return massage;
    }
}
