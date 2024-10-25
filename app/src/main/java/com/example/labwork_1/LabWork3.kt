package com.example.labwork_1

class LabWork3 {
}

fun task1() {
    var nullableVar: Int? = null;

    println(nullableVar); //null

    nullableVar = 64;

    val text: String = nullableVar?.toString() ?: "null";

    println(text); //64
}

fun getFullName(firstName: String?, lastName: String?): String {
    val notNullFirstName = firstName ?: "Unknown"
    val notNullLastName = lastName ?: "Unknown"
    return "$notNullFirstName $notNullLastName"
}

fun calculateSquareRoot(number: Double?): Double {
    return Math.sqrt(number!!)
}

fun getStringLength(obj: Any?): Int {
    val stringOfObj = obj as? String

    return stringOfObj?.length ?: -1
}

fun main() {
    task1();

    getFullName(null, "Miheev");

    try {
        val result1 = calculateSquareRoot(144.0)
        println("Square root 144.0: $result1");

        val result2 = calculateSquareRoot(null)
        println("Square root null: $result2");
    } catch (e: NullPointerException) {
        println("Error: number is null")
    }

    println(getStringLength("Vsem Privet!"))
    println(getStringLength(64));
    println(getStringLength(null));
    println(getStringLength(-1));
}