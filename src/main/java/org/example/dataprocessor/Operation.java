package org.example.dataprocessor;


import org.example.dataprocessor.Analysis.AnalysisInterface;
import org.example.dataprocessor.Cleaning.CleaningInterface;
import org.example.dataprocessor.Output.OutputInterface;

import java.util.List;

public class Operation {
    private CleaningInterface cleaningInterface;
    private AnalysisInterface analysisInterface;
    private OutputInterface outputInterface;

    public Operation(CleaningInterface cleaningInterface,
                     AnalysisInterface analysisInterface,
                     OutputInterface outputInterface ) {
        this.cleaningInterface = cleaningInterface;
        this.analysisInterface = analysisInterface;
        this.outputInterface = outputInterface;
    }

    public List<Double> clean (List<Integer> data) {
        return cleaningInterface.operation(data);
    }
     public Double analysis (List<Double> data) {
        return  analysisInterface.operation(data);
     }

     public double output(double data) throws Exception {
        return outputInterface.operation(data);
     }

}
