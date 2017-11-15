package cc.somkiat.basicunittesting.Validation;

public class ValidateCaseFactory {

    String username;

    public void setUsername(String username) {
        this.username = username;
    }

    public String alert() {
        String exception;
        boolean test[] = {
                CaseNull.isNull(username)
                , CaseEmpty.isEmpty(username)
                // You can include new case method at this
        };
        String alerts[] = {
                "isNull"
                , "isEmpty"
                , "Passed"
                // You can include new case alert at this
        };

        int caseEx = 0;
        do {
            exception = alerts[caseEx];
        } while(caseEx < alerts.length-1 && !test[caseEx++]);

        return exception;
    }

}
