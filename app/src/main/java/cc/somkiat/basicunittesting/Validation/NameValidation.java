package cc.somkiat.basicunittesting.Validation;

import java.util.ArrayList;
import java.util.List;

public class NameValidation {

    String name;

    private String alerts[] = {
            // You can include new case alert at this
            "Saved"
    };

    public void setName(String name) {
        this.name = name;
    }

    public String alert() {
        List<FillRule> invalidate = new ArrayList<>();
        // add new Case on this line

        int i = -1;
        while(++i < invalidate.size() && !invalidate.get(i).validate(name));

        return alerts[i];
    }

}
