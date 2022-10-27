package operations.impl;

import operations.Interpreter;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class AggregationInterpreter implements Interpreter<String> {

    /*
    *   statistics data structure keeps each category name, status, and count.
    *   The following explanation shows how to be stored of data into statistics .
    *
    *   INPUT :
    *       PAYMENT, FAIL
    *       PAYMENT, SUCCESS
    *       PAYMENT, SUCCESS
    *       ADVICE,  WITHDRAW
    *       ADVICE,  FAIL
    *   MAP STORAGE OF ABOVE INPUT :
    *
    *      <"PAYMENT", <  <FAIL,1>, <SUCCESS,2>  >>
    *      <"ADVICE",  <  <WITHDRAW,1>, <FAIL,1> >>
    *
    *   ** <> notation points a map structure
    *
    * */
    private final Map<String, Map<String,Integer>> statistics;


    public AggregationInterpreter() {
        statistics = new HashMap<>();
    }

    @Override
    public void interpret(String[] parsedResource) {

        /*take Category and It's status info from parsed resource*/
        String category = parsedResource[1];
        String status = parsedResource[2];

        /*stores category's statistics as Status, and it's count in map*/
        Map<String, Integer> statusCount;

        /*checks whether provided category is in statistics Map or not*/
        if (statistics.containsKey(category)) {
            statusCount = statistics.get(category);

            /*checks whether provided "status info" keeps in statusCount or not*/
            if (statusCount.containsKey(status)) {
                /*if so, increments status's count on map*/
                incrementStatusCount(statusCount,status);
            } else {
                /*else, creates a new map entry for  status that does not exist in the map previously*/
                statusCount.put(status,1);
            }
        } else {
            /*
              if provided category is not exist in the map previously,
              A new statusCount map entry is created for the new category in
              statistics map.
            */
            statusCount = new HashMap<>();
            statusCount.put(status,1);
        }

        statistics.put(category,statusCount);


    }

    @Override
    public String toString() {

        return statistics.keySet().stream()
                .map( key-> key + " " +
                        statistics.get(key).keySet().stream().map(key2 -> key2 + " " +
                                statistics.get(key).get(key2)).collect(Collectors.joining(" "))).collect(Collectors.joining("\n"));
    }

    private void incrementStatusCount(Map<String, Integer> statusCount,String status) {
        Integer count = statusCount.get(status);
        count = count + 1;
        statusCount.put(status,count);
    }


}
