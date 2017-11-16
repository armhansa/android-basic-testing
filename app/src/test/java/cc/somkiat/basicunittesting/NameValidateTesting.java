package cc.somkiat.basicunittesting;

import org.junit.Test;

import cc.somkiat.basicunittesting.Validation.NameValidation;

import static junit.framework.Assert.assertEquals;

public class NameValidateTesting {

    String result;

    @Test
    public void nameIsNull() {
        NameValidation validation = new NameValidation();
        result = validation.alert();
        assertEquals("Is Null", result);
    }

    @Test
    public void nameIsEmpty() {
        NameValidation validation = new NameValidation();
        validation.setName("");
        result = validation.alert();
        assertEquals("Is Empty", result);
    }

    @Test
    public void nameTooShort() {
        NameValidation validation = new NameValidation();
        validation.setName("H");
        result = validation.alert();
        assertEquals("Is Too Short", result);
    }



    @Test
    public void nameIsCorrect() {
        NameValidation validate = new NameValidation();
        validate.setName("Henna");
        result = validate.alert();
        assertEquals("Saved", result);
    }


}
