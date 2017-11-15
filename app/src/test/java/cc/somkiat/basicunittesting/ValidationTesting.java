package cc.somkiat.basicunittesting;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ValidationTesting {

    @Test
    public void usernameIsNull() {
        NameValidation validation = new NameValidation();
        String result = validation.alert();
        assertEquals("isNull", result);
    }


}
