import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContainsSpecialCheckHandler extends BaseHandler{

    public boolean isValidPassword(String pwToCheck) {
        String regexContainsSpecial = "(?=.*[\\W]).*";
        String regexDisallowed = "((?=.*[^()#$?!%/@A-Za-z0-9]).*)";

        Pattern containsSpecial = Pattern.compile(regexContainsSpecial);
        Matcher matchSpecial = containsSpecial.matcher(pwToCheck);
        Pattern disallowedPattern = Pattern.compile(regexDisallowed);
        Matcher matchDisallowed = disallowedPattern.matcher(pwToCheck);

        if( matchSpecial.matches()){
            return !matchDisallowed.matches();
        }
        return false;
    }
}
