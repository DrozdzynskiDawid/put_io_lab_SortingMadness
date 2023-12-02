package pl.put.poznan.sorting.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.sorting.logic.SortingMadnessLogic;

import java.util.ArrayList;


@RestController
public class SortingMadnessController {

    private static final Logger logger = LoggerFactory.getLogger(SortingMadnessController.class);

    @RequestMapping(value = "/sortInts", method = RequestMethod.POST,
            consumes = "application/json", produces = "application/json")
    public ArrayList<SortingResponse<Integer>> sortInts(@RequestBody SortingRequest<Integer> request) throws Exception {
        logger.info("Given array: " + request.getArray().toString());
        logger.info("Chosen algorithms: " + request.getAlgorithms());

        ArrayList<SortingResponse<Integer>> response = new ArrayList<>();
        for (String algo: request.getAlgorithms()) {
            SortingMadnessLogic sorting = new SortingMadnessLogic(algo);
            response.add(sorting.sort(request.getArray()));
        }
        return response;
    }

    @RequestMapping(value = "/sortStrings", method = RequestMethod.POST,
            consumes = "application/json", produces = "application/json")
    public ArrayList<SortingResponse<String>> sortStrings(@RequestBody SortingRequest<String> request) throws Exception {
        logger.info("Given array: " + request.getArray().toString());
        logger.info("Chosen algorithms: " + request.getAlgorithms());

        ArrayList<SortingResponse<String>> response = new ArrayList<>();
        for (String algo: request.getAlgorithms()) {
            SortingMadnessLogic sorting = new SortingMadnessLogic(algo);
            response.add(sorting.sort(request.getArray()));
        }
        return response;
    }
}
