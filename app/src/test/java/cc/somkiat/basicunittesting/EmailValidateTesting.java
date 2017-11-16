package cc.somkiat.basicunittesting;

import org.junit.Test;

import cc.somkiat.basicunittesting.Validation.EmailValidation;

import static junit.framework.Assert.assertEquals;

public class EmailValidateTesting {

    String result;

    @Test
    public void emailIsNull() {
        EmailValidation validation = new EmailValidation();
        result = validation.alert();
        assertEquals("Is Null", result);
    }





    @Test
    public void emailIsCorrect() {
        EmailValidation validation = new EmailValidation();
        validation.setEmail("armhansa@gmail.com");
        result = validation.alert();
        assertEquals("Saved", result);
    }

}
