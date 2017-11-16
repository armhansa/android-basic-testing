package cc.somkiat.basicunittesting.Validation;

public class CaseTooShort implements FillRule {
    @Override
    public boolean validate(String text) {
        return text.length() < 2;
    }
}
