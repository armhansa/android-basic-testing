package cc.somkiat.basicunittesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import cc.somkiat.basicunittesting.Validation.EmailValidation;
import cc.somkiat.basicunittesting.Validation.NameValidation;

public class MainActivity extends AppCompatActivity {

    EditText nameInput;
    EditText emailInput;
    DatePicker dateOfBirthInput;

    NameValidation nameValidation;
    EmailValidation emailValidation;

    android.text.format.Time now;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setValue();
    }

    private void setValue() {
        nameInput = findViewById(R.id.userNameInput);
        emailInput = findViewById(R.id.emailInput);
        dateOfBirthInput = findViewById(R.id.dateOfBirthInput);

        nameValidation = new NameValidation();
        emailValidation = new EmailValidation();

        now = new android.text.format.Time();
    }

    public void onSaveClick(View view) {
        nameValidation.setName(nameInput.getText().toString());
        emailValidation.setEmail(emailInput.getText().toString());
        if("Saved".equals(nameValidation.alert()) && "Saved".equals(emailValidation.alert())) {
            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Name Invalidate: "+nameValidation.alert(), Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "Email Invalidate: "+emailValidation.alert(), Toast.LENGTH_LONG).show();
        }
    }

    public void onRevertClick(View view) {
        resetInput();
    }

    public void resetInput() {
        now.setToNow();
        nameInput.setText("");
        emailInput.setText("");
        dateOfBirthInput.updateDate(now.year, now.month, now.monthDay);
    }

}
