public class LengthCheckHandler extends BaseHandler{

    public boolean isValidPassword(String pwToCheck) {
        return pwToCheck.length() >= 8 && pwToCheck.length() <= 25;
    }
}
