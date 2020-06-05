package pl.pszczolkowski.bookspa.service;

import org.junit.jupiter.api.Test;
import pl.pszczolkowski.bookspa.ServicesDecorator.*;
import pl.pszczolkowski.bookspa.model.OrderRequest;
import pl.pszczolkowski.bookspa.model.OrderRequestBuilder;

import static org.junit.jupiter.api.Assertions.*;

class ObserverTest {


    @Test
    public ServiceSheet makeServiceFromOrder(OrderRequest orderRequest) {
        if (orderRequest.getServiceType().equals("Massage")){
            return new Massage();
        }
        if (orderRequest.getServiceType().equals("Manicure")){
            return new Manicure();
        }
        if (orderRequest.getServiceType().equals("Pedicure")){
            return new Pedicure();
        }
        if (orderRequest.getServiceType().equals("Body Peeling")){
            return new BodyPeeling();
        }
        return null;
    }

    @Test
    public ServiceSheet checkAdditional(OrderRequest orderRequest, ServiceSheet serviceSheet){
        if (orderRequest.getAdditional().equals("Waitress and Wine")){
            return new WaitressAndWine(serviceSheet);
        }
        if (orderRequest.getAdditional().equals("Candles and Incense")){
            return new CandlesAndIncense(serviceSheet);
        }
        else{
            return serviceSheet;
        }
    }

    @Test
    public ServiceSheet fullCheck(OrderRequest orderRequest, ServiceSheet serviceSheet){
        return checkAdditional(orderRequest, makeServiceFromOrder(orderRequest));
    }

    @Test
    void check(){
        OrderRequest orderRequest = new OrderRequestBuilder()
                .setName("Karol")
                .setSurname("Pszczolkowski")
                .setId(1)
                .setDate("3.5.2020")
                .setAdress("Gdansk")
                .setHour("6:30")
                .setServiceType("Massage")
                .setAdditional("Waitress and Wine")
                .build();

        ServiceSheet serviceSheet = fullCheck(orderRequest, makeServiceFromOrder(orderRequest));

        assertEquals(serviceSheet.getClass(), WaitressAndWine.class);
        assertEquals(470,serviceSheet.basePrice());
    }
}
