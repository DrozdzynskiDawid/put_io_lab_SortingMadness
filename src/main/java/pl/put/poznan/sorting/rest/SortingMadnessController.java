package pl.put.poznan.sorting.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.sorting.logic.AutomaticAlgorithmSelector;
import pl.put.poznan.sorting.logic.SortingInterface;
import pl.put.poznan.sorting.logic.SortingMadnessLogic;

import java.util.ArrayList;


@RestController
public class SortingMadnessController {

    private static final Logger logger = LoggerFactory.getLogger(SortingMadnessController.class);

    @RequestMapping(value = "/sortInts", method = RequestMethod.POST,
            consumes = "application/json", produces = "application/json")
    public ArrayList<SortingResponse<Integer>> sortInts(@RequestBody SortingRequest<Integer> request) throws Exception {
        logger.info("Given array: " + request.getArray().toString());
        if (request.getArray().isEmpty()) {
            logger.error("Data is empty");
            throw new Exception("Data is empty");
        }
        logger.info("Chosen algorithms: " + request.getAlgorithms());
        if(request.getAlgorithms().isEmpty() || request.getAlgorithms().size() > 6){
            logger.error("Invalid number of algorithms chosen");
            throw new Exception("Invalid number of algorithms chosen");
        }
        logger.info("Chosen sorting order: " + request.getSortingOrder());
        logger.info("Chosen iteration limit: " + request.getIterationLimit());
        ArrayList<SortingResponse<Integer>> response = new ArrayList<>();
        for (String algo: request.getAlgorithms()) {
                SortingMadnessLogic sorting = new SortingMadnessLogic(algo, request.getSortingOrder(), request.getCheckedIterationLimit());
                response.add(sorting.sort(request.getArray()));
        }
        return response;
    }

    @RequestMapping(value = "/sortStrings", method = RequestMethod.POST,
            consumes = "application/json", produces = "application/json")
    public ArrayList<SortingResponse<String>> sortStrings(@RequestBody SortingRequest<String> request) throws Exception {
        logger.info("Given array: " + request.getArray().toString());
        if (request.getArray().isEmpty()) {
            logger.error("Data is empty");
            throw new Exception("Data is empty");
        }
        logger.info("Chosen algorithms: " + request.getAlgorithms());
        if(request.getAlgorithms().isEmpty() || request.getAlgorithms().size() > 6){
            logger.error("Invalid number of algorithms chosen");
            throw new Exception("Invalid number of algorithms chosen");
        }
        logger.info("Chosen sorting order: " + request.getSortingOrder());
        logger.info("Chosen iteration limit: " + request.getIterationLimit());
        ArrayList<SortingResponse<String>> response = new ArrayList<>();
        for (String algo: request.getAlgorithms()) {
            SortingMadnessLogic sorting = new SortingMadnessLogic(algo, request.getSortingOrder(), request.getCheckedIterationLimit());
            response.add(sorting.sort(request.getArray()));
        }
        return response;
    }
    @PostMapping(value = "/automaticAlgorithmSelect", consumes = "application/json", produces = "application/json")
    public SortingResponse<Object> automaticAlgorithmSelect(@RequestBody SortingRequest<Object> request) {
        logger.info("Given array: " + request.getArray().toString());
        if (request.getArray().isEmpty()) {
            logger.error("Data is empty");
            return new SortingResponse<>();
        }

        SortingInterface selectedAlgorithm = AutomaticAlgorithmSelector.selectAlgorithm(
                request.getArray(), request.getSortingOrder());

        SortingResponse<Object> response = new SortingResponse<>();
        response.setAlgorithm(selectedAlgorithm.getName());

        return response;
    }



}
