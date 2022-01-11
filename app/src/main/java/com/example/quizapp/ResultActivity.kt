package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val userName = intent.getStringExtra(Constants.USER_NAME)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWER,0)
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)

        tv_name.text = userName
        tv_result.text = "Your score is $correctAnswers out of $totalQuestions"

        btn_finish.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }
}