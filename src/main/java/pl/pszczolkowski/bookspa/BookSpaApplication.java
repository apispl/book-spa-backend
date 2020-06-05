package pl.pszczolkowski.bookspa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.annotation.Order;
import pl.pszczolkowski.bookspa.model.OrderRequest;
import pl.pszczolkowski.bookspa.model.OrderRequestBuilder;

@SpringBootApplication
public class BookSpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookSpaApplication.class, args);
    }

}
