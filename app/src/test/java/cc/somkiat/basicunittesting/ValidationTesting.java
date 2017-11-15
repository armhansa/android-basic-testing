package cc.somkiat.basicunittesting;

import org.junit.Test;

import cc.somkiat.basicunittesting.Validation.ValidateCaseFactory;

import static junit.framework.Assert.assertEquals;

public class ValidationTesting {

    @Test
    public void usernameIsNull() {
        ValidateCaseFactory validation = new ValidateCaseFactory();
        String result = validation.alert();
        assertEquals("isNull", result);
    }

    @Test
    public void usernameIsEmpty() {
        ValidateCaseFactory validation = new ValidateCaseFactory();
        validation.setUsername("");
        String result = validation.alert();
        assertEquals("isEmpty", result);
    }


}
