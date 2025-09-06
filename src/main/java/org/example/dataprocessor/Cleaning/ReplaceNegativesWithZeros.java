package org.example.dataprocessor.Cleaning;

import java.util.ArrayList;
import java.util.List;

public class ReplaceNegativesWithZeros implements CleaningInterface {
    public List<Double> operation(List<Integer> data) {
        List<Double> cleanedList = new ArrayList<>();
        for (Integer num: data) {
            if (num < 0) {
                cleanedList.add(num.doubleValue());
            } else {
                cleanedList.add(num.doubleValue());
            }
        }
        return cleanedList;
    }
}
