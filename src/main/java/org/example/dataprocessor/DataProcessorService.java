package org.example.dataprocessor;

import org.example.dataprocessor.enums.AnalysisType;
import org.example.dataprocessor.enums.CleaningType;
import org.example.dataprocessor.enums.OutputType;
import org.example.dataprocessor.strategies.IOperationsStrategy;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
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

        IOperationsStrategy cleaningStrategy =
                OperationStrategy.createOperation(cleaningType);
        List<Double> cleanedResult = (List<Double>) cleaningStrategy.operation(data, cleaningType);

        IOperationsStrategy analysisStrategy =
                OperationStrategy.createOperation(analysisType);
        Double analysisResult = (Double) analysisStrategy.operation(cleanedResult, analysisType);

        IOperationsStrategy outputStrategy =
                OperationStrategy.createOperation(outputType);
        outputStrategy.operation(analysisResult, outputType);

        return analysisResult;

    }
}

