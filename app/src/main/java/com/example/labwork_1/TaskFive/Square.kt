package com.example.labwork_1.TaskFive

class Square(
    name: String,
    color: String,
    private val width: Double
)
    : Shape(name, color) {
    override fun area(): Double {
        return width * width;
    }
}