package com.example.quizapp

import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.AdaptiveIconDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.widget.TintableCompoundDrawablesView
import kotlinx.android.synthetic.main.activity_quiz_questions.*

class QuizQuestionsActivity : AppCompatActivity(),View.OnClickListener {
    private var mCurrentPosition:Int = 1
    private var mQuestionList : ArrayList<Question>? = null
    private var mSelectedPosition: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mQuestionList = Constants.getQuestions()
        setQuestion()

        option1.setOnClickListener(this)
        option2.setOnClickListener(this)
        option3.setOnClickListener(this)
        option4.setOnClickListener(this)
        submitButton.setOnClickListener(this)

    }
    fun setQuestion(){
        val question = mQuestionList?.get(mCurrentPosition -1)

        defaultOptionView()
        if(mCurrentPosition==mQuestionList!!.size){
            submitButton.text = "FINISH"
        }else{
            submitButton.text = "SUBMIT"
        }
        progressBar.progress = mCurrentPosition
        tvProgress.text = "$mCurrentPosition"+ "/" + progressBar.max

        tvQuestion.text = question!!.question
        ivImage.setImageResource(question.image)
        option1.text = question.option1
        option2.text = question.option2
        option3.text = question.option3
        option4.text = question.option4
    }
    private fun defaultOptionView(){
        var options = ArrayList<TextView>()
        options.add(0,option1)
        options.add(1,option2)
        options.add(2,option3)
        options.add(3,option4)

        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,R.drawable.default_option_bg)
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.option1-> {
                selectedOptionView(option1,1)
            }
            R.id.option2-> {
                selectedOptionView(option2,2)
            }
            R.id.option3-> {
                selectedOptionView(option3,3)
            }
            R.id.option4-> {
                selectedOptionView(option4,4)
            }
            R.id.submitButton->{
                if(mSelectedPosition==0){
                    mCurrentPosition++
                    when{
                        mCurrentPosition <= mQuestionList!!.size ->{
                            setQuestion()
                        }else->{
                            Toast.makeText(this,"You have successfully complited the quiz",Toast.LENGTH_SHORT).show()
                        }
                    }
                }else{
                    val question = mQuestionList!!.get(mCurrentPosition-1)
                    if(question!!.correctOption!=mSelectedPosition){
                        answerView(mSelectedPosition,R.drawable.incorrect_option_bg)
                    }
                    answerView(question.correctOption,R.drawable.correct_option_bg)

                    if(mCurrentPosition==mQuestionList!!.size){
                        submitButton.text = "FINISH"
                    }else{
                        submitButton.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedPosition = 0

                }
            }
        }
    }

    private fun answerView(answer:Int,drawablesView: Int){
        when(answer){
            1->{
                option1.background = ContextCompat.getDrawable(this,drawablesView)
            }
            2->{
                option2.background = ContextCompat.getDrawable(this,drawablesView)
            }
            3->{
                option3.background = ContextCompat.getDrawable(this,drawablesView)
            }
            4->{
                option4.background = ContextCompat.getDrawable(this,drawablesView)
            }
        }
    }

    private fun selectedOptionView(tv:TextView,selectedOption : Int){
        defaultOptionView()
        mSelectedPosition = selectedOption

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this,R.drawable.selected_option_bg)

    }
}