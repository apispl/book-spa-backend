package pl.pszczolkowski.bookspa.hourObserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.pszczolkowski.bookspa.ServicesDecorator.*;
import pl.pszczolkowski.bookspa.model.OrderRequest;
import pl.pszczolkowski.bookspa.service.ObserverService;
import pl.pszczolkowski.bookspa.service.ObserverServiceImpl;


import java.util.List;

@Component
public class Observer implements CloseObserver {

    ObserverService observerService = new ObserverServiceImpl();

    @Override
    public void addEveningHour(List<String> stringList) {
        if (stringList.isEmpty()){
            stringList.add( "13:30");
            stringList.add( "14:30");
            stringList.add( "15:30");
            stringList.add( "16:30");
            stringList.add( "17:30");
        }
    }

    @Override
    public void startWhenListFull(List<OrderRequest> orderRequestList, List<String> serviceSheetList, List<String> hourList) {
        if (orderRequestList.size() == 10){
            for (OrderRequest orderRequest:orderRequestList) {
                ServiceSheet sheet = observerService.createServiceSheet(orderRequest);
                String orderString =  "Order ID:" + sheet.getOrderId() + ", " + sheet.serviceType() + ", price: " + sheet.basePrice();
                serviceSheetList.add(orderString);
            }
            hourList.clear();
        }
    }

}
