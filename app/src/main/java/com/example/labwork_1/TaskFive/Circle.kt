package com.example.labwork_1.TaskFive

class Circle(
    name: String,
    color: String,
    private val radius: Double
) :
    Shape(name, color) {
    override fun area(): Double {
        return Math.PI * radius * radius;
    }
}