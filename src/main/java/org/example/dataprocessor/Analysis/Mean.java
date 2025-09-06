package org.example.dataprocessor.Analysis;
import java.util.List;



public class Mean implements AnalysisInterface{
    public Double operation(List<Double> data) {
        if (data.isEmpty()) return Double.NaN;
        double result = 0;
        for (Double num : data)
            result += num;
        result = result/data.size();
        return result;
    }
}
