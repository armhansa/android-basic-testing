package cc.somkiat.basicunittesting.Validation;

public class CaseEmpty implements FillRule {
    @Override
    public boolean validate(String text) {
        return "".equals(text);
    }
}
