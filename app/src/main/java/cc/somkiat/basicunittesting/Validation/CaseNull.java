package cc.somkiat.basicunittesting.Validation;

public class CaseNull implements FillRule {
    @Override
    public boolean validate(String text) {
        return text == null;
    }
}
