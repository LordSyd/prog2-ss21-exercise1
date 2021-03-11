public class ConsecutiveNumbersCheckHandler extends BaseHandler {

    public boolean isValidPassword(String pwToCheck) {

        for (int i = 0; i < pwToCheck.length() - 2; i++) {
            if(Character.isDigit(pwToCheck.charAt(i))){
                if ( (pwToCheck.charAt(i+1) - pwToCheck.charAt(i)) == 1 && (pwToCheck.charAt(i+2) - pwToCheck.charAt(i+1)) == 1 )  {
                    return false;
                }
            }
        }
        return true;
    }
}
