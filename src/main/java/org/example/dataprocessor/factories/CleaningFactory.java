package org.example.dataprocessor.factories;

import org.example.dataprocessor.Cleaning.CleaningInterface;
import org.example.dataprocessor.Cleaning.RemoveNegatives;
import org.example.dataprocessor.Cleaning.ReplaceNegativesWithZeros;
import org.example.dataprocessor.enums.CleaningType;

public class CleaningFactory {

    public static CleaningInterface cleaningStrategy(CleaningType type) {
        return switch (type) {
            case REMOVE_NEGATIVES -> new RemoveNegatives();
            case REPLACE_NEGATIVES_WITH_ZERO -> new ReplaceNegativesWithZeros();
        };
    }
}
