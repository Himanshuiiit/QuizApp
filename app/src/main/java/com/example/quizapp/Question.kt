package com.example.quizapp

data class Question(
    val Id : Int,
    val question :String,
    val image : Int,
    val option1 :String,
    val option2 : String,
    val option3 : String,
    val option4 : String,
    val correctOption : Int
)