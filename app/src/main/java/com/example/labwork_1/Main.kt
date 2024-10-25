package com.example.labwork_1

fun main() {
    println("hello");
    println("variant - 14");

    firstTask();
    secondTaskIf();
    secondTaskWhen();
    thirdTask();
    fouthTask();
}

fun firstTask(): Unit {
    var firstVariable = 64;
    var secondVariable = 5;

    println("Before swap first variable: $firstVariable second variable: $secondVariable");

    firstVariable = secondVariable.also {secondVariable = firstVariable}

    println("After swap first variable: $firstVariable second variable: $secondVariable");
}

fun secondTaskIf(): Unit {
    val a = 20
    val b = 40

    if (a > 30 || b > 30) {
        println("yes");
    } else {
        println("no");
    }
}

fun secondTaskWhen(): Unit {
    val a = 20;
    val b = 20;

    when {
        a > 30 || b > 30 -> println("yes");
        else -> println("no");
    }
}

fun thirdTask(): Unit {
    var countEven = 0
    var input: Int

    println("Enter non-zero integers:")

    while (true) {
        input = readLine()?.toIntOrNull() ?: 0

        if (input == 0) {
            break
        }

        if (input % 2 == 0) {
            countEven++
        }
    }

    println("Number of even numbers: $countEven")
}

fun fouthTask(): Unit {
    val array = arrayOf(
        arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
        arrayOf(1, 12, 13, 14, 15, 16, 17, 18, 19, 20),
        arrayOf(5, 12, 6, 14, 15, 5, 17, 18, 19, 7),
        arrayOf(4, 7, 13, 14, 15, 16, 17, 6, 19, 6),
        arrayOf(11, 12, 4, 14, 6, 8, 17, 18, 19, 2),
        arrayOf(5, 5, 13, 5, 8, 16, 17, 18, 9, 20),
        arrayOf(11, 1, 13, 3, 15, 3, 17, 18, 19, 20),
        arrayOf(2, 12, 2, 14, 6, 16, 17, 18, 19, 4),
        arrayOf(11, 12, 6, 14, 11, 16, 17, 7, 19, 5),
        arrayOf(5, 1, 7, 42, 15, 2, 17, 18, 19, 1),
    );

    findSumOfRowArray(array);
    findProduceOfTableArray(array);
    findMaxElementFromDiagonal(array);
}

fun findSumOfRowArray(array: Array<Array<Int>>):Unit {
    var sumOfRow = 0;
    var indexer = 1;
    for (row in array) {
        for (element in row) {
            sumOfRow += element;
        }
        println("Sum of $indexer row: $sumOfRow")
        indexer++;
        sumOfRow = 0;
    }
}

fun findProduceOfTableArray(array: Array<Array<Int>>): Unit {
    val columnProducts = IntArray(10) { 1 }

    for (row in array) {
        for (col in 0 until 10) {
            columnProducts[col] *= row[col]
        }
    }

    var indexer = 1;
    for(element in columnProducts) {
        println("Produce of $indexer table: $element");
        indexer++;
    }
}

fun findMaxElementFromDiagonal(array: Array<Array<Int>>): Unit {
    var maxDiagonalElement = 0;
    for (i in 0 until array.size) {
        if (array[i][i] > maxDiagonalElement) {
            maxDiagonalElement = array[i][i]
        }
    }
    println("Max element from diagonal: $maxDiagonalElement");
}