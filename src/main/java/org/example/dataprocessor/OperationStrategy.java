package org.example.dataprocessor;

import org.example.dataprocessor.strategies.AnalysisStrategy;
import org.example.dataprocessor.strategies.CleaningStrategy;
import org.example.dataprocessor.strategies.IOperationsStrategy;
import org.example.dataprocessor.enums.*;
import org.example.dataprocessor.strategies.OutputStrategy;

public class OperationStrategy {

    public static <T> IOperationsStrategy createOperation(T type) {
        if (type instanceof CleaningType) {
            return new CleaningStrategy();
        } else if (type instanceof AnalysisType) {
            return new AnalysisStrategy();
        } else if (type instanceof OutputType) {
            return new OutputStrategy();
        } else {
            throw new IllegalArgumentException("Unsupported type: " + type.getClass().getName());
        }
    }


}
