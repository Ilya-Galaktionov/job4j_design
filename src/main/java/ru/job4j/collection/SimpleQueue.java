package ru.job4j.collection;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> input = new SimpleStack<>();
    private final SimpleStack<T> output = new SimpleStack<>();

    private int inSize = 0;
    private int outSize = 0;


    public T poll() {
        if (inSize == 0 && outSize == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        if (outSize == 0) {
            while (inSize != 0) {
                output.push(input.pop());
                outSize++;
                inSize--;
            }
        }
        outSize--;
        return output.pop();
    }

    public void push(T value) {
        input.push(value);
        inSize++;
    }
}