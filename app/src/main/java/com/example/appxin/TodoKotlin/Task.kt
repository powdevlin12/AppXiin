package com.example.appxin.TodoKotlin

data class Task(
    val id: Int,
    var title: String,
    var isCompleted: Boolean = false
)