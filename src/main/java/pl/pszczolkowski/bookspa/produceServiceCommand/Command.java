package pl.pszczolkowski.bookspa.produceServiceCommand;

import pl.pszczolkowski.bookspa.ServicesDecorator.ServiceSheet;
import pl.pszczolkowski.bookspa.model.OrderRequest;

public interface Command {
    ServiceSheet produceSerShe(OrderRequest orderRequest);
}
