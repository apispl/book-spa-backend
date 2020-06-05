package pl.pszczolkowski.bookspa.produceServiceCommand;

import pl.pszczolkowski.bookspa.ServicesDecorator.Pedicure;
import pl.pszczolkowski.bookspa.ServicesDecorator.ServiceSheet;
import pl.pszczolkowski.bookspa.model.OrderRequest;

public class ProducePedicure implements Command {
    @Override
    public ServiceSheet produceSerShe(OrderRequest orderRequest) {
        Pedicure pedicure = new Pedicure();
        pedicure.setOrderId(orderRequest.getId());
        return pedicure;
    }
}
