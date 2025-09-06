package org.example.dataprocessor.Output;

public class Output implements OutputInterface{
    public double operation(double data)throws Exception {
        System.out.println("Result = " + data);
        return data;
    }
}
