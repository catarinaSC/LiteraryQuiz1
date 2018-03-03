package com.example.catarina.literaryquiz;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView name;
    TextView questionOneAnswerThree;
    TextView questionTwoAnswerOne;
    TextView questionTwoAnswerTwo;
    TextView questionTwoAnswerThree;
    TextView questionTwoAnswerFour;
    TextView questionThreeAnswerOne;
    TextView questionThreeAnswerTwo;
    TextView questionThreeAnswerThree;
    TextView questionThreeAnswerFour;
    TextView questionFourAnswerThree;
    TextView questionFiveAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView picture = (ImageView) findViewById(R.id.picture);
        picture.setImageResource(R.drawable.books);
        name = findViewById(R.id.name);
        questionOneAnswerThree = findViewById(R.id.question_one_answer_three);
        questionTwoAnswerOne = findViewById(R.id.question_two_answer_one);
        questionTwoAnswerTwo = findViewById(R.id.question_two_answer_two);
        questionTwoAnswerThree = findViewById(R.id.question_two_answer_three);
        questionTwoAnswerFour = findViewById(R.id.question_two_answer_four);
        questionThreeAnswerOne = findViewById(R.id.question_three_answer_one);
        questionThreeAnswerTwo = findViewById(R.id.question_three_answer_two);
        questionThreeAnswerThree = findViewById(R.id.question_three_answer_three);
        questionThreeAnswerFour = findViewById(R.id.question_three_answer_four);
        questionFourAnswerThree = findViewById(R.id.question_four_answer_three);
        questionFiveAnswer = findViewById(R.id.question_five_answer);
    }

    /**
     * This method is called when the Submit button is clicked.
     */

    public void checkAnswers(View view) {
        // Get user's name
        EditText nameField = (EditText) name;
        Editable nameEditable = nameField.getText();
        String user = nameEditable.toString();

        //Answers to the questions
        //Answer One. RadioButton
        RadioButton questionOneAnswerThreeRadioButton = (RadioButton) questionOneAnswerThree;
        boolean isQuestionOneAnswerThree = questionOneAnswerThreeRadioButton.isChecked();

        //Answer Two. CheckBox

        CheckBox questionTwoAnswerOneCheckBox = (CheckBox) questionTwoAnswerOne;
        boolean isQuestionTwoAnswerOne = questionTwoAnswerOneCheckBox.isChecked();
        CheckBox questionTwoAnswerTwoCheckBox = (CheckBox) questionTwoAnswerTwo;
        boolean isQuestionTwoAnswerTwo = questionTwoAnswerTwoCheckBox.isChecked();
        CheckBox questionTwoAnswerThreeCheckBox = (CheckBox) questionTwoAnswerThree;
        boolean isQuestionTwoAnswerThree = questionTwoAnswerThreeCheckBox.isChecked();
        CheckBox questionTwoAnswerFourCheckBox = (CheckBox) questionTwoAnswerFour;
        boolean isQuestionTwoAnswerFour = questionTwoAnswerFourCheckBox.isChecked();
        boolean isQuestionTwoTotal;
        if (isQuestionTwoAnswerTwo || isQuestionTwoAnswerThree) {
            isQuestionTwoTotal = false;
        } else {
            isQuestionTwoTotal = isQuestionTwoAnswerOne && isQuestionTwoAnswerFour;
        }


        //Answer Three. CheckBox

        CheckBox questionThreeAnswerOneCheckBox = (CheckBox) questionThreeAnswerOne;
        boolean isQuestionThreeAnswerOne = questionThreeAnswerOneCheckBox.isChecked();
        CheckBox questionThreeAnswerTwoCheckBox = (CheckBox) questionThreeAnswerTwo;
        boolean isQuestionThreeAnswerTwo = questionThreeAnswerTwoCheckBox.isChecked();
        CheckBox questionThreeAnswerThreeCheckBox = (CheckBox) questionThreeAnswerThree;
        boolean isQuestionThreeAnswerThree = questionThreeAnswerThreeCheckBox.isChecked();
        CheckBox questionThreeAnswerFourCheckBox = (CheckBox) questionThreeAnswerFour;
        boolean isQuestionThreeAnswerFour = questionThreeAnswerFourCheckBox.isChecked();
        boolean isQuestionThreeTotal;
        if (isQuestionThreeAnswerThree) {
            isQuestionThreeTotal = false;
        } else {
            isQuestionThreeTotal = isQuestionThreeAnswerOne && isQuestionThreeAnswerTwo && isQuestionThreeAnswerFour;
        }

        //Answer Four. RadioButton

        RadioButton questionFourAnswerThreeRadioButton = (RadioButton) questionFourAnswerThree;
        boolean isQuestionFourAnswerThree = questionFourAnswerThreeRadioButton.isChecked();

        //Answer Five. EditText

        EditText questionFiveAnswerEditText = (EditText) questionFiveAnswer;
        String questionFiveAnswer = questionFiveAnswerEditText.getText().toString();
        boolean isQuestionFiveAnswer = questionFiveAnswer.equalsIgnoreCase("Moçambique") || questionFiveAnswer.equalsIgnoreCase("Moçambique ") || questionFiveAnswer.equalsIgnoreCase("Mozambique ") || questionFiveAnswer.equalsIgnoreCase("Mozambique");

        //Toast Message with the results

        Context context = getApplicationContext();
        CharSequence text = createAnswerSummary(user, isQuestionOneAnswerThree, isQuestionTwoTotal, isQuestionThreeTotal, isQuestionFourAnswerThree, isQuestionFiveAnswer);
        int duration = Toast.LENGTH_SHORT;
        Toast finalResult = Toast.makeText(context, text, duration);
        finalResult.show();
    }

    //Counts the right answers

    public String createAnswerSummary(String user, boolean isQuestionOneAnswerThree, boolean isQuestionTwoTotal, boolean isQuestionThreeTotal, boolean isQuestionFourAnswerThree, boolean isQuestionFiveAnswer) {

        int counter = 0;

        if (isQuestionOneAnswerThree) {
            counter = counter + 1;
        }

        if (isQuestionTwoTotal) {
            counter = counter + 1;
        }

        if (isQuestionThreeTotal) {
            counter = counter + 1;
        }

        if (isQuestionFourAnswerThree) {
            counter = counter + 1;
        }

        if (isQuestionFiveAnswer) {
            counter = counter + 1;
        }

        String quizResultsMessage = getString(R.string.user_name, user);
        quizResultsMessage += "\n\n" + getString(R.string.counter, counter);
        quizResultsMessage += "\n\n" + getString(R.string.thank_you);
        return quizResultsMessage;
    }
}
