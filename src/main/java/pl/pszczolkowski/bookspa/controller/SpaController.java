package pl.pszczolkowski.bookspa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pszczolkowski.bookspa.ServicesDecorator.ServiceSheet;
import pl.pszczolkowski.bookspa.model.OrderRequest;
import pl.pszczolkowski.bookspa.service.SpaService;

import java.util.List;

@RestController
@RequestMapping("/spa")
@CrossOrigin("*")
public class SpaController {

    SpaService spaService;

    @Autowired
    public SpaController(SpaService spaService) {
        this.spaService = spaService;
    }

    @GetMapping
    public ResponseEntity<List<OrderRequest>> getOrders(){
        List<OrderRequest> allOrders = spaService.getOrderList();
        return new ResponseEntity<>(allOrders, HttpStatus.OK);
    }

    @GetMapping("/hours")
    public ResponseEntity<List<String>> getHourList(){
        List<String> allHours = spaService.getAvaliableHours();
        return new ResponseEntity<>(allHours, HttpStatus.OK);
    }

    @GetMapping("/services")
    public ResponseEntity<List<String>> getServiceSheetList(){
        List<String> serviceSheetList = spaService.getServicesList();
        return new ResponseEntity<>(serviceSheetList,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OrderRequest> addOrder(@RequestBody OrderRequest order){
        spaService.bookHour(order);
        Long freeId = spaService.findFreeId();
        if (order.getId() == 0){
            order.setId(freeId);
        }
        spaService.addOrder(order);
        return new ResponseEntity<>(order, HttpStatus.ACCEPTED);
    }

    @DeleteMapping
    public void clearList(){
        spaService.clearLists();
    }
}
