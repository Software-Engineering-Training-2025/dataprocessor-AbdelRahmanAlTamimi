package org.example.dataprocessor.Analysis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Median  implements AnalysisInterface{
    public Double operation(List<Double> data) {
        int n = data.size();
        if (data.isEmpty()) return Double.NaN;
        double result = 0.0;
        List<Double> sortedList = new ArrayList<>(data);
        Collections.sort(sortedList);
        if (n % 2 == 0) {
            result = (sortedList.get(n/2) + sortedList.get(n/2 - 1)) / 2.0;
        } else {
            result = sortedList.get(n/2);
        }
        return result;
    }
}
