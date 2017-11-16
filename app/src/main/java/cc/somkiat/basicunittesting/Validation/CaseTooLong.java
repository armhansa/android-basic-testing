package cc.somkiat.basicunittesting.Validation;

public class CaseTooLong implements FillRule {
    @Override
    public boolean validate(String text) {
        return text.length() > 20;
    }
}
