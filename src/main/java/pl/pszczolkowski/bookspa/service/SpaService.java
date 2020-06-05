package pl.pszczolkowski.bookspa.service;

import pl.pszczolkowski.bookspa.model.OrderRequest;

import java.util.List;

public interface SpaService {
    List<OrderRequest> getOrderList();
    OrderRequest addOrder(OrderRequest orderRequest);
    Long findFreeId();
    List<String> getAvaliableHours();
    void bookHour(OrderRequest orderRequest);
    List<String> getServicesList();
    void clearLists();
    void addMorningHours();

}
