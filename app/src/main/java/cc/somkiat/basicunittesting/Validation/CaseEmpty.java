package cc.somkiat.basicunittesting.Validation;

public class CaseEmpty {

    public static boolean isEmpty(String username) {
        try {
            return "".equals(username);
        } catch(Exception ex) {
            return false;
        }
    }
}
