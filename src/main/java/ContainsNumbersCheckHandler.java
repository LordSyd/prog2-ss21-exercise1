import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContainsNumbersCheckHandler extends BaseHandler{


    public boolean isValidPassword(String pwToCheck) {
        String regex = "((?=.*[0-9]).*)";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(pwToCheck);

        return m.matches();
    }

}
