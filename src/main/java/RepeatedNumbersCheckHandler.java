import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RepeatedNumbersCheckHandler extends BaseHandler{

    public boolean isValidPassword(String pwToCheck) {
        String pattern = "(\\d)\\1{3}";
        Pattern p = Pattern.compile(pattern);

        Matcher pw = p.matcher(pwToCheck);
        return !pw.find();


        /* Alternative with loop
        for (int i = 0; i < pwToCheck.length() - 2; i++) {
            if(Character.isDigit(pwToCheck.charAt(i))){
                if (pwToCheck.charAt(i) == pwToCheck.charAt(i+1) &&
                                pwToCheck.charAt(i) == pwToCheck.charAt(i+2) &&
                                pwToCheck.charAt(i) == pwToCheck.charAt(i+3))  {
                    return false;
                }
            }
        }
        return true;
    }*/
    }
}
