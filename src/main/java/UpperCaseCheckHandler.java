import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UpperCaseCheckHandler extends BaseHandler{

    public boolean isValidPassword(String pwToCheck) {
        String regex = "((?=.*[a-z])(?=.*[A-Z]).*)";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(pwToCheck);

        return m.matches();
    }
}
