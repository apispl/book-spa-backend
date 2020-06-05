package pl.pszczolkowski.bookspa.service;

import pl.pszczolkowski.bookspa.ServicesDecorator.ServiceSheet;
import pl.pszczolkowski.bookspa.model.OrderRequest;

public interface ObserverService {
    ServiceSheet makeServiceFromOrder(OrderRequest orderRequest);
    ServiceSheet checkAdditional(OrderRequest orderRequest, ServiceSheet serviceSheet);
    ServiceSheet createServiceSheet(OrderRequest orderRequest);
}
