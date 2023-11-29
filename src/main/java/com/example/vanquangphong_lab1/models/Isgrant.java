package com.example.vanquangphong_lab1.models;

public enum Isgrant {
    disable(0),
    enable(1);


    private final int value;

    private Isgrant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
