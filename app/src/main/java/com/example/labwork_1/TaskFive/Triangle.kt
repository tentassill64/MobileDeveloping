package com.example.labwork_1.TaskFive

class Triangle(
    name: String,
    color: String, 
    private val base: Double,
    private val height: Double
) :
    Shape(name, color) {
    override fun area(): Double {
        return 0.5 * base * height
    }
}
