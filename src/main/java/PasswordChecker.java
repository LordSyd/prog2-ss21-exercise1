public class PasswordChecker {

    /**
     * Client for checking passwords. Builds Chain on construction and sets start to be the first handler.
     *
     *
     */

    private Handler start;

    public PasswordChecker() {
        makeChain();
    }

    /**
     * builds chain of responsibility out of different handlers, sets start to desired first handler
     *
     */
    private void makeChain() {
        Handler lengthHandler = new LengthCheckHandler();
        Handler upperCaseHandler = new UpperCaseCheckHandler();
        Handler containsNumbersHandler = new ContainsNumbersCheckHandler();
        Handler containsSpecialHandler = new ContainsSpecialCheckHandler();
        Handler consecutiveNumbersHandler = new ConsecutiveNumbersCheckHandler();
        Handler repeatedNumbersHandler = new RepeatedNumbersCheckHandler();

        start = lengthHandler;

        lengthHandler.setNext(upperCaseHandler);
        upperCaseHandler.setNext(containsNumbersHandler);
        containsNumbersHandler.setNext(containsSpecialHandler);
        containsSpecialHandler.setNext(consecutiveNumbersHandler);
        consecutiveNumbersHandler.setNext(repeatedNumbersHandler);

    }

    /**
     * API method. Takes a password as a string and checks for validity by handing it down the chain, returns the result
     *
     * @param pwToCheck String
     * @return Boolean
     */

    public boolean checkPassword(String pwToCheck) {
        return start.handle(pwToCheck);
    }
}
