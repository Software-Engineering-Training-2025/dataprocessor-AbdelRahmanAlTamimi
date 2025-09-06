package org.example.dataprocessor.factories;

import org.example.dataprocessor.Output.Output;
import org.example.dataprocessor.Output.OutputInterface;
import org.example.dataprocessor.Output.TextFile;
import org.example.dataprocessor.enums.OutputType;

public class OutputFactory {
    public static OutputInterface outputStrategy(OutputType type) {
        return switch (type) {
            case CONSOLE -> new Output();
            case TEXT_FILE -> new TextFile();
        };
    }
}
