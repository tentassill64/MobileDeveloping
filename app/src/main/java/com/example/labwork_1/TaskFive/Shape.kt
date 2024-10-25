package com.example.labwork_1.TaskFive

import com.example.labwork_1.main

abstract class Shape(protected val name: String, protected val color: String) {
    abstract fun area(): Double;

    override fun toString(): String {
        return ("Shape: $name, color: $color");
    }
}
