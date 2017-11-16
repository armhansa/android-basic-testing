package cc.somkiat.basicunittesting.Validation;

import java.util.regex.Pattern;

public class CaseNameWrongPattern implements FillRule {
    @Override
    public boolean validate(String text) {
        return !Pattern.matches("[a-zA-Z]*", text);
    }
}
