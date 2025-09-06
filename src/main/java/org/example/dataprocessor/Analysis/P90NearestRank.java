package org.example.dataprocessor.Analysis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P90NearestRank implements AnalysisInterface{
    public Double operation(List<Double> data) {
        int n = data.size();
        if (n == 0) return Double.NaN;
        double result = 0.0;
        List<Double> sortedForP90 = new ArrayList<>(data);
        Collections.sort(sortedForP90);
        result = sortedForP90.get((int)(Math.ceil(data.size()*0.90))-1);
        return result;
    }
}
