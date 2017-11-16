package cc.somkiat.basicunittesting.Validation;

import java.util.ArrayList;
import java.util.List;

public class EmailValidation {

    String email;

    private String alerts[] = {
            "Is Null"
            , "Is Empty"
            // You can include new case alert at this
            , "Saved"
    };

    public void setEmail(String email) {
        this.email = email;
    }

    public String alert() {
        List<FillRule> invalidate = new ArrayList<>();
        invalidate.add(new CaseNull());
        invalidate.add(new CaseEmpty());
        // add new Case on this line

        int i = -1;
        while(++i < invalidate.size() && !invalidate.get(i).validate(email));

        return alerts[i];
    }
}
