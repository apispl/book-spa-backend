package pl.pszczolkowski.bookspa.produceServiceCommand;

import pl.pszczolkowski.bookspa.ServicesDecorator.Manicure;
import pl.pszczolkowski.bookspa.ServicesDecorator.ServiceSheet;
import pl.pszczolkowski.bookspa.model.OrderRequest;

public class ProduceManicure implements Command {

    @Override
    public ServiceSheet produceSerShe(OrderRequest orderRequest) {
        Manicure manicure = new Manicure();
        manicure.setOrderId(orderRequest.getId());
        return manicure;
    }
}
