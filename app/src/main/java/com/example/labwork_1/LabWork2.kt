package com.example.labwork_1

import androidx.compose.animation.core.animateRectAsState
import java.nio.file.DirectoryStream.Filter
import kotlin.random.Random

fun task1(number: Int): Int {
        when {
            number % 2 == 0 -> return number/2
            else -> return 2 * number;
        }
    }

    val task2: (Int) -> Boolean = { number -> number % 2 == 0 }

    fun displayArray(array: Array<Int>){
        for(element in array) {
            print("$element ")
        }
        println("");
    }

fun Array<Int>.filterAndMap(filter: (Int) -> Boolean, map: (Int) -> Int): Array<Int> {
    return this.filter(filter).map(map).toTypedArray()
}


fun main() {
    var dimension: Int

    print("Input dimension of Array: ")
    dimension =  readlnOrNull()?.toIntOrNull() ?: 1;

    val array = Array(dimension) {(Random.nextInt(-100, 500))}

    displayArray(array);

    val arrayTask1: Array<Int> = array.map(::task1).toTypedArray();

    displayArray(arrayTask1);

    val arrayTask2: Array<Int> = array.filter(task2).toTypedArray();

    displayArray(arrayTask2);

    val task3: (Int) -> Int = { it * 2 }

    val arrayTask3: Array<Int> = array.filterAndMap(task2, task3);

    displayArray(arrayTask3);
}

//Задание 5

//1. (Int, Int, String) -> Unit

//2. () -> String

//3. (() -> Unit) -> Unit