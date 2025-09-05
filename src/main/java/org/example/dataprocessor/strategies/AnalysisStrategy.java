package org.example.dataprocessor.strategies;

import org.example.dataprocessor.enums.AnalysisType;
import java.util.*;
import java.lang.Math;
import java.util.Map;


public class AnalysisStrategy implements IOperationsStrategy<Double,List<Double>,AnalysisType> {
    public Double operation(List<Double> data,AnalysisType type) {
        double result = 0.0;
        int n = data.size();

                switch (type) {
                    case MEAN:
                        if (n == 0 ) return Double.NaN;
                        result = mean(data);
                    break;

                    case MEDIAN:
                        if (n == 0 ) return Double.NaN;
                        List<Double> sortedList = new ArrayList<>(data);
                        Collections.sort(sortedList);
                        if (n % 2 == 0) {
                            result = (sortedList.get(n/2) + sortedList.get(n/2 - 1)) / 2.0;
                        } else {
                            result = sortedList.get(n/2);
                        }
                    break;

                    case STD_DEV:
                        if (n == 0 ) return Double.NaN;
                        double mean = mean(data);
                        double square = 0.0;
                        for (Double num : data){
                            square = Math.pow((num - mean), 2);
                            result += square;
                        }
                        result = Math.sqrt(result/data.size());
                    break;

                    case P90_NEAREST_RANK:
                        if (n == 0) return Double.NaN;
                        List<Double> sortedForP90 = new ArrayList<>(data);
                        Collections.sort(sortedForP90);
                        result = sortedForP90.get((int)(Math.ceil(data.size()*0.90))-1);
                    break;

                    case TOP3_FREQUENT_COUNT_SUM:
                        if (n == 0) return 0.0;
                        Map<Double, Integer> frequencyMap = new HashMap<>();
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
                    break;
                    default:
                        return Double.NaN;
                };
                return result;
    }

    private Double mean(List<Double> data) {
        double result = 0;
        for (Double num : data)
            result += num;
        result = result/data.size();
        return result;
    }
}
