package com.example.quizapp

import android.graphics.Color
import android.os.Bundle
import android.content.res.ColorStateList
import android.view.View
import android.widget.*

class QuizActivity : BaseActivity() {


    private lateinit var currentCategory: DifficultyCategory
    private var currentQuestionIndex: Int = 0
    private var score: Int = 0
    private lateinit var tvQuestion: TextView
    private lateinit var rgAnswers: RadioGroup
    private lateinit var rbOption1: RadioButton
    private lateinit var rbOption2: RadioButton
    private lateinit var rbOption3: RadioButton
    private lateinit var rbOption4: RadioButton
    private lateinit var btnContinue: Button
    private lateinit var llDifficultyButtons: LinearLayout
    private lateinit var llQuizContainer: LinearLayout
    private lateinit var tvTitle: TextView
    private lateinit var tvScore: TextView
    private lateinit var tvQuestionCounter: TextView
    private var selectedAnswerIndex: Int = -1
    private lateinit var shuffledQuestions: List<Question>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)


        tvTitle = findViewById(R.id.tvTitle)
        llDifficultyButtons = findViewById(R.id.llDifficultyButtons)
        llQuizContainer = findViewById(R.id.llQuizContainer)
        tvQuestion = findViewById(R.id.tvQuestion)
        rgAnswers = findViewById(R.id.rgAnswers)
        rbOption1 = findViewById(R.id.rbOption1)
        rbOption2 = findViewById(R.id.rbOption2)
        rbOption3 = findViewById(R.id.rbOption3)
        rbOption4 = findViewById(R.id.rbOption4)
        btnContinue = findViewById(R.id.btnContinue)


        tvScore = findViewById(R.id.tvScore)
        tvQuestionCounter = findViewById(R.id.tvQuestionCounter)


        findViewById<Button>(R.id.btnFacile).setOnClickListener { startQuiz("Facile") }
        findViewById<Button>(R.id.btnMoyen).setOnClickListener { startQuiz("Moyen") }
        findViewById<Button>(R.id.btnDifficile).setOnClickListener { startQuiz("Difficile") }
        findViewById<Button>(R.id.btnImpossible).setOnClickListener { startQuiz("Impossible") }


        rgAnswers.setOnCheckedChangeListener { _, checkedId ->
            selectedAnswerIndex = when (checkedId) {
                R.id.rbOption1 -> 0
                R.id.rbOption2 -> 1
                R.id.rbOption3 -> 2
                R.id.rbOption4 -> 3
                else -> -1
            }
        }


        btnContinue.setOnClickListener { checkAnswerAndContinue() }
    }


    private fun startQuiz(difficulty: String) {
        llDifficultyButtons.visibility = View.GONE
        llQuizContainer.visibility = View.VISIBLE
        tvTitle.text = "Quiz - $difficulty"

        // Récupère la catégorie correspondante
        val category = QuizData.getCategoryByName(difficulty) ?: return

        // Mélange les questions et en sélectionne 10
        shuffledQuestions = category.questions.shuffled().take(10)

        currentQuestionIndex = 0
        score = 0
        selectedAnswerIndex = -1

        updateScoreAndCounter()
        showQuestion(shuffledQuestions[currentQuestionIndex])
    }


    private fun showQuestion(question: Question) {
        tvQuestion.text = question.text
        rbOption1.text = question.options[0]
        rbOption2.text = question.options[1]
        rbOption3.text = question.options[2]
        rbOption4.text = question.options[3]
        rgAnswers.clearCheck()
        resetAnswerColors()
        rgAnswers.isEnabled = true
    }


    private fun checkAnswerAndContinue() {
        if (selectedAnswerIndex == -1) {
            Toast.makeText(this, "Veuillez sélectionner une réponse", Toast.LENGTH_SHORT).show()
            return
        }

        val currentQuestion = shuffledQuestions[currentQuestionIndex]
        rgAnswers.isEnabled = false


        if (selectedAnswerIndex == currentQuestion.correctAnswerIndex) {
            score++ // Incrémenter le score
            getRadioButtonByIndex(selectedAnswerIndex)?.setTextColor(ColorStateList.valueOf(Color.GREEN))
        } else {
            getRadioButtonByIndex(selectedAnswerIndex)?.setTextColor(ColorStateList.valueOf(Color.RED))
            getRadioButtonByIndex(currentQuestion.correctAnswerIndex)?.setTextColor(ColorStateList.valueOf(Color.GREEN))
        }


        btnContinue.postDelayed({
            currentQuestionIndex++
            if (currentQuestionIndex < shuffledQuestions.size) {
                updateScoreAndCounter()
                showQuestion(shuffledQuestions[currentQuestionIndex])
            } else {

                Toast.makeText(this, "Quiz terminé ! Score: $score/${shuffledQuestions.size}", Toast.LENGTH_SHORT).show()
                llDifficultyButtons.visibility = View.VISIBLE
                llQuizContainer.visibility = View.GONE
                tvTitle.text = "Page du Quiz"
            }
        }, 1500)
    }


    private fun updateScoreAndCounter() {
        tvScore.text = "Score: $score/${shuffledQuestions.size}"
        tvQuestionCounter.text = "Question ${currentQuestionIndex + 1}/${shuffledQuestions.size}"
    }


    private fun resetAnswerColors() {
        rbOption1.setTextColor(ColorStateList.valueOf(Color.BLACK))
        rbOption2.setTextColor(ColorStateList.valueOf(Color.BLACK))
        rbOption3.setTextColor(ColorStateList.valueOf(Color.BLACK))
        rbOption4.setTextColor(ColorStateList.valueOf(Color.BLACK))
    }


    private fun getRadioButtonByIndex(index: Int): RadioButton? {
        return when (index) {
            0 -> rbOption1
            1 -> rbOption2
            2 -> rbOption3
            3 -> rbOption4
            else -> null
        }
    }
}