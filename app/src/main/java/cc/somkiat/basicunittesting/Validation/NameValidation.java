package cc.somkiat.basicunittesting.Validation;

import java.util.ArrayList;
import java.util.List;

public class NameValidation {

    String name;

    private String alerts[] = {
            "Is Null"
            , "Is Empty"
            , "Is Too Short"
            // You can include new case alert at this
            , "Saved"
    };

    public void setName(String name) {
        this.name = name;
    }

    public String alert() {
        List<FillRule> invalidate = new ArrayList<>();
        invalidate.add(new CaseNull());
        invalidate.add(new CaseEmpty());
        invalidate.add(new CaseTooShort());
        // add new Case on this line

        int i = -1;
        while(++i < invalidate.size() && !invalidate.get(i).validate(name));

        return alerts[i];
    }

}
