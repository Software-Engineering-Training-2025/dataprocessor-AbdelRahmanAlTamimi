package org.example.dataprocessor.Analysis;

import java.util.*;

public class Top3FrequentCountSum implements AnalysisInterface{
    public Double operation(List<Double> data){
        if (data.isEmpty()) return 0.0;
        Map<Double, Integer> frequencyMap = new HashMap<>();
        double result = 0.0;
        for (Double num : data) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        List<Integer> frequencies = new ArrayList<>(frequencyMap.values());
        frequencies.sort(Collections.reverseOrder());
        if (frequencies.size() < 3) {
            result = frequencies.stream().mapToInt(Integer::intValue).sum();
        } else {
            for (int i = 0;i < 3; ++i) {
                result += frequencies.get(i);
            }
        }
        return result;
    }
}
