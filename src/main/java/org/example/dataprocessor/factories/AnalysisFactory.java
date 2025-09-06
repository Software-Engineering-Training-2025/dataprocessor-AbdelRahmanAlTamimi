package org.example.dataprocessor.factories;

import org.example.dataprocessor.Analysis.*;
import org.example.dataprocessor.enums.AnalysisType;

public class AnalysisFactory {
    public static AnalysisInterface AnalysisStrategy(AnalysisType type) {
        return switch (type) {
            case MEAN -> new Mean();
            case MEDIAN -> new Median();
            case STD_DEV -> new StdDev();
            case P90_NEAREST_RANK -> new P90NearestRank();
            case TOP3_FREQUENT_COUNT_SUM -> new Top3FrequentCountSum();
        };
    }
}
