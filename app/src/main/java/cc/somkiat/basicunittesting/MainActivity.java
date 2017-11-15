package cc.somkiat.basicunittesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.Time;
import java.time.Year;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private static MainActivity mainActivity;

    public static MainActivity getMainActivity() {
        return mainActivity;
    }

    EditText userNameInput;
    EditText emailInput;
    DatePicker dateOfBirthInput;

    android.text.format.Time now;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setValue();
    }

    private void setValue() {
        mainActivity = this;

        userNameInput = findViewById(R.id.userNameInput);
        emailInput = findViewById(R.id.emailInput);
        dateOfBirthInput = findViewById(R.id.dateOfBirthInput);

        now = new android.text.format.Time();
    }

    public void onSaveClick(View view) {
        //TODO
    }

    public void onRevertClick(View view) {
        resetInput();
    }

    public void resetInput() {
        now.setToNow();
        userNameInput.setText("");
        emailInput.setText("");
        dateOfBirthInput.updateDate(now.year, now.month, now.monthDay);
    }

    public EditText getUserNameInput() {
        return userNameInput;
    }

    public EditText getEmailInput() {
        return emailInput;
    }

}
