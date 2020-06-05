package pl.pszczolkowski.bookspa.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class SingletonTest {

    @Test
    void testBeans() {

        ItemController itemController = new ItemController();

        ReportController reportController = new ReportController();

        assertEquals(itemController.itemService, reportController.itemService);

    }

    @RestController
    public class ItemController {

        @Autowired
        private ItemService itemService;
    }

    @RestController
    public class ReportController {

        @Autowired
        private ItemService itemService;


    }
}

interface ItemService{
}

@Component
class ItemServiceImpl implements ItemService{
}



