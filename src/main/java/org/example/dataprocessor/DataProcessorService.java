package org.example.dataprocessor;

import org.example.dataprocessor.Analysis.AnalysisInterface;
import org.example.dataprocessor.Cleaning.CleaningInterface;
import org.example.dataprocessor.Output.OutputInterface;
import org.example.dataprocessor.enums.AnalysisType;
import org.example.dataprocessor.enums.CleaningType;
import org.example.dataprocessor.enums.OutputType;
import org.example.dataprocessor.factories.AnalysisFactory;
import org.example.dataprocessor.factories.CleaningFactory;
import org.example.dataprocessor.factories.OutputFactory;
import org.example.dataprocessor.strategies.IOperationsStrategy;

import java.util.*;

/**
 * Students ONLY implement the process(...) method below.
 *
 * Requirements:
 * - Order: Clean -> Analyze -> Output -> Return result
 * - Do NOT mutate the original input list
 * - Handle empties as specified in AnalysisType docs
 * - Output format EXACTLY: "Result = <value>"
 * - TEXT_FILE path: target/result.txt (create parent dirs, overwrite file)
 */
public class DataProcessorService {

    /**
     * Implement this method.
     */
    public double process(
            CleaningType cleaningType,
            AnalysisType analysisType,
            OutputType outputType,
            List<Integer> data) throws Exception {

        CleaningInterface cleaner = CleaningFactory.cleaningStrategy(cleaningType);
        AnalysisInterface analyser = AnalysisFactory.AnalysisStrategy(analysisType);
        OutputInterface output = OutputFactory.outputStrategy(outputType);
        Operation preProcessor = new Operation(cleaner,analyser,output);

        return preProcessor.output(preProcessor.analysis(preProcessor.clean(data)));
    }
}

