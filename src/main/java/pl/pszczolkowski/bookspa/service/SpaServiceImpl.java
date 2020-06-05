package pl.pszczolkowski.bookspa.service;

import org.springframework.stereotype.Service;
import pl.pszczolkowski.bookspa.hourObserver.CloseObserver;
import pl.pszczolkowski.bookspa.hourObserver.Observer;
import pl.pszczolkowski.bookspa.model.OrderRequest;
import pl.pszczolkowski.bookspa.model.OrderRequestBuilder;
import java.util.*;

@Service
public class SpaServiceImpl implements SpaService {

    List<OrderRequest> orderRequestList = new ArrayList<>();
    List<String> hourList = new ArrayList<>();
    List<CloseObserver> closeObservers = new ArrayList<>();
    List<String> serviceSheetList = new ArrayList<>();
    Observer observer = new Observer();

    public void subscribe(CloseObserver closeObserver){
        this.closeObservers.add(closeObserver);
    }

    public SpaServiceImpl() {
        addMorningHours();
    }

    @Override
    public List<OrderRequest> getOrderList() {
        return orderRequestList;
    }

    @Override
    public OrderRequest addOrder(OrderRequest orderRequest) {
        orderRequestList.add(orderRequest);
        observer.startWhenListFull(orderRequestList, serviceSheetList, hourList);
        return orderRequest;
    }

    @Override
    public Long findFreeId() {
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

        for (int i = 0; i < temp.size(); i++) {
            if (myTemp.isEmpty()){
                return 1L;
            }
            if (!myTemp.get(i).equals(pattern.get(i))){
                return i+1L;
            }
        }
        return pattern.size()+1L;
    }

    @Override
    public List<String> getAvaliableHours() {
        return hourList;
    }

    @Override
    public void bookHour(OrderRequest orderRequest) {
        Optional<String> first = hourList.stream().filter(s -> s.equals(orderRequest.getHour())).findFirst();
        first.ifPresent(s -> hourList.remove(s));
        observer.addEveningHour(hourList);
    }

    @Override
    public List<String> getServicesList(){
        return serviceSheetList;
    }

    @Override
    public void clearLists() {
        orderRequestList.clear();
        hourList.clear();
        serviceSheetList.clear();

        orderRequestList = new ArrayList<>();
        hourList = new ArrayList<>();
        serviceSheetList = new ArrayList<>();

        addMorningHours();
    }

    public void addMorningHours() {
        hourList.add("8:30");
        hourList.add("9:30");
        hourList.add("10:30");
        hourList.add("11:30");
        hourList.add("12:30");
    }
}
