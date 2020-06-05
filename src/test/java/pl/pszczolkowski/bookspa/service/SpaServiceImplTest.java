package pl.pszczolkowski.bookspa.service;

import org.junit.jupiter.api.Test;
import pl.pszczolkowski.bookspa.model.OrderRequest;
import pl.pszczolkowski.bookspa.model.OrderRequestBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

class SpaServiceImplTest {

    @Test
    long findFreeIdTestMethod() {
        List<OrderRequest> orderRequestList = new ArrayList<>();
        OrderRequest orderRequest = new OrderRequestBuilder()
                .setId(1)
                .build();

        orderRequestList.add(orderRequest);
        OrderRequest orderRequest1 = new OrderRequestBuilder()
                .setId(4)
                .build();

        orderRequestList.add(orderRequest1);
        OrderRequest orderRequest2 = new OrderRequestBuilder()
                .setId(2)
                .build();
        orderRequestList.add(orderRequest2);

        OrderRequest orderRequest3 = new OrderRequestBuilder()
                .setId(3)
                .build();
        orderRequestList.add(orderRequest3);

        List<Long> temp = new ArrayList<>();
        Iterator<OrderRequest> iterator = orderRequestList.iterator();
        while (iterator.hasNext()){
            temp.add(iterator.next().getId());
        }

        List<Long> pattern = new ArrayList<>();
        for (int i = 1; i < temp.size()+1; i++) {
            pattern.add((long) i);
        }

        List<Long> myTemp = new ArrayList<>();
        temp.stream().sorted().forEach(myTemp::add);
        myTemp.forEach(System.out::println);

        for (int i = 0; i < temp.size(); i++) {
            if (myTemp.isEmpty()){
                return 1L;
            }
            if (!myTemp.get(i).equals(pattern.get(i))){
                return i+1L;
            }
        }
        return temp.size()+1L;
    }

    @Test
    void findFreeIdTest(){
        assertEquals(5L, findFreeIdTestMethod());
    }
}
