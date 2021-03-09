import java.util.regex.*;

class PwdCheck {
    public boolean checkLengthOk(String pwToCheck) {
        return pwToCheck.length() >= 8 && pwToCheck.length() <= 25;
    }

    public boolean checkNotNull(String pwToCheck) {
        return pwToCheck != null;
    }

    public boolean checkUpperCase(String pwToCheck) {
        String regex = "((?=.*[a-z])(?=.*[A-Z]).*)";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(pwToCheck);

        return m.matches();
    }

    public boolean checkContainsNums(String pwToCheck) {
        String regex = "((?=.*[0-9]).*)";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(pwToCheck);

        return m.matches();
    }

    public boolean checkContainsAllowedSpecialChars(String pwToCheck) {
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
