package org.example.dataprocessor.strategies;

import org.example.dataprocessor.enums.CleaningType;
import java.util.*;
import java.util.stream.Collectors;


public class CleaningStrategy implements IOperationsStrategy<List<Double>,List<Integer>,CleaningType> {

    public List<Double> operation(List<Integer> data, CleaningType type) {
        List<Integer> cleanedList = new ArrayList<>(data);
        cleanedList = switch (type) {
            case REMOVE_NEGATIVES -> cleanedList.stream()
                    .filter(num -> num >= 0)
                    .collect(Collectors.toList());
            case REPLACE_NEGATIVES_WITH_ZERO -> cleanedList.stream()
                    .map(num -> num < 0 ? 0 : num)
                    .collect(Collectors.toList());
        };

        List<Double> doubleList = new ArrayList<>();
        for (Integer num : cleanedList) {
            doubleList.add(num.doubleValue());
        }

        return doubleList;
    }
}
