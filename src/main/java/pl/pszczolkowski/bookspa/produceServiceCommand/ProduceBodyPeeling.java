package pl.pszczolkowski.bookspa.produceServiceCommand;

import pl.pszczolkowski.bookspa.ServicesDecorator.BodyPeeling;
import pl.pszczolkowski.bookspa.ServicesDecorator.ServiceSheet;
import pl.pszczolkowski.bookspa.model.OrderRequest;

public class ProduceBodyPeeling implements Command {
    @Override
    public ServiceSheet produceSerShe(OrderRequest orderRequest) {
        BodyPeeling bodyPeeling = new BodyPeeling();
        bodyPeeling.setOrderId(orderRequest.getId());
        return bodyPeeling;
    }
}
