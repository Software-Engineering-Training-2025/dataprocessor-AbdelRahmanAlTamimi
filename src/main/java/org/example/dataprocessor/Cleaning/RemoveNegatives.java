package org.example.dataprocessor.Cleaning;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveNegatives implements CleaningInterface {
    public List<Double> operation(List<Integer> data) {
        List<Double> cleanedList = new ArrayList<>();

        for (Integer num : data) {
            if (num >= 0){
                cleanedList.add(num.doubleValue());
            }

        }
        return cleanedList;
    }
}
