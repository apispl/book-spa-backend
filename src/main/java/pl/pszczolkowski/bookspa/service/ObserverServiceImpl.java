package pl.pszczolkowski.bookspa.service;

import org.springframework.stereotype.Service;
import pl.pszczolkowski.bookspa.ServicesDecorator.*;
import pl.pszczolkowski.bookspa.model.OrderRequest;
import pl.pszczolkowski.bookspa.produceServiceCommand.*;

import java.util.HashMap;
import java.util.Map;

@Service
public class ObserverServiceImpl implements ObserverService {

    @Override
    public ServiceSheet makeServiceFromOrder(OrderRequest orderRequest) {
        Map<String, Command> commandMap = new HashMap<>();
        commandMap.put("Massage", new ProduceMassage());
        commandMap.put("Manicure", new ProduceManicure());
        commandMap.put("Pedicure", new ProducePedicure());
        commandMap.put("Body Peeling", new ProduceBodyPeeling());

        return commandMap.get(orderRequest.getServiceType()).produceSerShe(orderRequest);
    }

    @Override
    public ServiceSheet checkAdditional(OrderRequest orderRequest, ServiceSheet serviceSheet) {
        if (orderRequest.getAdditional().equals("Waitress and Wine")){
            WaitressAndWine waitressAndWine = new WaitressAndWine(serviceSheet);
            waitressAndWine.setOrderId(serviceSheet.getOrderId());
            return waitressAndWine;
        }
        if (orderRequest.getAdditional().equals("Candles and Incense")){
            CandlesAndIncense candlesAndIncense = new CandlesAndIncense(serviceSheet);
            candlesAndIncense.setOrderId(serviceSheet.getOrderId());
            return candlesAndIncense;
        }
        else{
            return serviceSheet;
        }
    }

    @Override
    public ServiceSheet createServiceSheet(OrderRequest orderRequest) {
        return checkAdditional(orderRequest, makeServiceFromOrder(orderRequest));
    }
}
