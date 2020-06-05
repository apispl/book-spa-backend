package pl.pszczolkowski.bookspa.hourObserver;

import pl.pszczolkowski.bookspa.model.OrderRequest;
import java.util.List;

public interface CloseObserver {
    void addEveningHour(List<String> stringList);
    void startWhenListFull(List<OrderRequest> orderRequestList, List<String> serviceSheetList, List<String> hourList);
}
