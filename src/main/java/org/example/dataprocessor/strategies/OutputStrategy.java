package org.example.dataprocessor.strategies;

import org.example.dataprocessor.enums.OutputType;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OutputStrategy implements IOperationsStrategy<Double, Double, OutputType> {

    public Double operation(Double data, OutputType type) {
        return switch (type) {
            case CONSOLE -> {
                System.out.println("Result = " + data);
                yield data;
            }
            case TEXT_FILE -> {
                try {
                    File dir = new File("target");
                    if (!dir.exists()) {
                        dir.mkdirs();
                    }

                    File file = new File(dir, "result.txt");

                    try (FileWriter writer = new FileWriter(file, false)) {
                        writer.write("Result = " + data);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
                yield data;
            }
        };
    }
}
