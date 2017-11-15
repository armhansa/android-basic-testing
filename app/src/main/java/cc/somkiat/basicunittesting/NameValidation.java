package cc.somkiat.basicunittesting;

import java.util.List;

class NameValidation {

    String username;

    String exception;

    public void setUsername(String username) {
        this.username = username;
    }

    public String alert() {
        boolean test[] = {
                isNull()
                , isEmpty()
        };
        String alerts[] = {"isNull", "isEmpty", "Pass"};

        int caseEx = 0;
        do {
            exception = alerts[caseEx];
        } while(caseEx < 2 && !test[caseEx++]);

        return exception;
    }

    private boolean isNull() {
        return username == null;
    }

    private boolean isEmpty() {
        try {
            return "".equals(username);
        } catch(Exception ex) {
            return false;
        }
    }
}
