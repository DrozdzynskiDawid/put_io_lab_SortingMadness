package pl.put.poznan.sorting.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.sorting.logic.SortingMadnessLogic;

import java.util.ArrayList;


@RestController
public class SortingMadnessController {

    private static final Logger logger = LoggerFactory.getLogger(SortingMadnessController.class);

    @RequestMapping(value = "/sortInts", method = RequestMethod.POST, produces = "application/json")
    public ArrayList<Integer> sortInts(@RequestParam ArrayList<Integer> arr,
                                       @RequestParam String algo) throws Exception {
        logger.info("Given array: " + arr.toString());
        logger.info("Chosen algorithm: " + algo);

        SortingMadnessLogic sorting = new SortingMadnessLogic(algo);
        return sorting.sort(arr);
    }

    @RequestMapping(value = "/sortStrings", method = RequestMethod.POST, produces = "application/json")
    public ArrayList<String> sortStrings(@RequestParam ArrayList<String> arr,
                                         @RequestParam String algo) throws Exception {
        logger.info("Given array: " + arr.toString());
        logger.info("Chosen algorithm: " + algo);

        SortingMadnessLogic sorting = new SortingMadnessLogic(algo);
        return sorting.sort(arr);
    }
}
