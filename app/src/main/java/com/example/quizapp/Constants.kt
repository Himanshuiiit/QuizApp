package com.example.quizapp

object Constants{
    fun getQuestions(): ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val q1 = Question(1,"Which Country's Flag is This?",R.drawable.argentina,"Argentina","America","Australia","Russia",1)
        val q2 = Question(2,"Which Country's Flag is This?",R.drawable.australia,"India","New Zealand","Australia","Canada",3)
        val q3 = Question(3,"Which Country's Flag is This?",R.drawable.china,"Japan","China","Bhutan","Thailand",2)
        val q4 = Question(4,"Which Country's Flag is This?",R.drawable.japan,"Russia","Japan","Bhutan","Nepal",2)
        val q5 = Question(5,"Which Country's Flag is This?",R.drawable.india,"India","Russia","Bangladesh","USA",1)
        val q6 = Question(6,"Which Country's Flag is This?",R.drawable.denmark,"Germany","Russia","Denmark","France",3)
        val q7 = Question(7,"Which Country's Flag is This?",R.drawable.germany,"France","India","UAE","Germany",4)
        val q8 = Question(8,"Which Country's Flag is This?",R.drawable.spain,"Netherlands","Austria","Denmark","Spain",4)
        val q9 = Question(9,"Which Country's Flag is This?",R.drawable.france,"France","Austria","India","Maldives",1)
        val q10 = Question(10,"Which Country's Flag is This?",R.drawable.russia,"Japan","South Africa","Russia","Canada",3)

        questionList.add(q1)
        questionList.add(q2)
        questionList.add(q3)
        questionList.add(q4)
        questionList.add(q5)
        questionList.add(q6)
        questionList.add(q7)
        questionList.add(q8)
        questionList.add(q9)
        questionList.add(q10)

        return questionList
    }
}