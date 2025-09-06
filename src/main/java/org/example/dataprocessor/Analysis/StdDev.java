package org.example.dataprocessor.Analysis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StdDev implements AnalysisInterface{

    public Double operation(List<Double> data) {
        int n = data.size();
        if (n == 0 ) return Double.NaN;
        double result = 0.0;
        double mean = mean(data);
        double square = 0.0;
        for (Double num : data){
            square = Math.pow((num - mean), 2);
            result += square;
        }
        result = Math.sqrt(result/data.size());
        return result;
    }

    private double mean (List<Double> data) {
        return data.stream()
                .mapToDouble(d -> d)
                .average()
                .orElse(0.0);
    }


}
