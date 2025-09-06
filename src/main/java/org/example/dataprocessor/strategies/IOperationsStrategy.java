package org.example.dataprocessor.strategies;

public interface IOperationsStrategy<R,T,E> {
    R operation(T data, E type);
}
