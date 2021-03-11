import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class PwdCheckTest {

    /**
     * Repo:
     * https://github.com/LordSyd/prog2-ss21-exercise1
     */

    private String pwTooShort;
    private String pwTooLong;
    private String pwNoUpperNoSpecial;
    private String pwNoSpecial;
    private String pwOk;
    private String pwConsecutiveNums;
    private String pwRepeatedNums;
    private String pwIsNull = null;
    private String pwAllowedSpecialChars;
    private String pwDisallowedSpecialChars;
    private String pwNumbersAndChars;
    private String pwOnlyNums;
    private Handler check;

    @BeforeAll
    static void init() {

    }

    @BeforeEach
    void setUp() {

        pwTooShort = "Aa?1"; // too short
        pwTooLong = "bB?32abcabcdeabasswaasda1sadfadfasdfvadf4asdvadsfagadf";
        pwNoUpperNoSpecial = "abcdefghij"; // length ok, no upper case, no special char
        pwNoSpecial = "aAbcdefghij";
        pwOk = "aA?2020wastheWorst";
        pwConsecutiveNums = "aA!adass567";
        pwRepeatedNums = "aA$asdada3333";
        pwAllowedSpecialChars = "()#$?%/@!";
        pwDisallowedSpecialChars = "()#$?%/@!<\">";
        pwNumbersAndChars = "aastloBB12";
        pwOnlyNums = "1112223334444";

    }

    @AfterEach
    void close() {
        check = null;
    }

    @DisplayName("Password too short")
    @Test
    void testLength_TooShort() {
        Handler check = new LengthCheckHandler();
        assertFalse(check.handle(pwTooShort));
    }

    @DisplayName("Password too long")
    @Test
    void testLength_TooLong() {
        check = new LengthCheckHandler();
        assertFalse(check.handle(pwTooLong));
    }

    @DisplayName("Password has correct length")
    @Test
    void testLength_Ok() {
        check = new LengthCheckHandler();
        assertTrue(check.handle(pwOk));
    }

    @DisplayName("Password is null")
    @Test
    void testPwIsNull() {
        check = new LengthCheckHandler();
        assertFalse(check.handle(pwIsNull));
    }

    @DisplayName("Password not null")
    @Test
    void pwNotNull() {
        check = new LengthCheckHandler();
        assertTrue(check.handle(pwOk));
    }

    @DisplayName("Password has no upper case letters")
    @Test
    void testUpperCaseHandler_noUppercase() {
        check = new UpperCaseCheckHandler();
        assertFalse(check.handle(pwNoUpperNoSpecial));
    }

    @DisplayName("Password has upper case letters but consecutive nums")
    @Test
    void testUpperCaseHandler_containsUpperCase() {
        check = new UpperCaseCheckHandler();
        assertTrue(check.handle(pwConsecutiveNums));
    }

    @DisplayName("Password Ok")
    @Test
    void testUpperCaseHandler_Ok() {
        check = new UpperCaseCheckHandler();
        assertTrue(check.handle(pwOk));
    }

    @DisplayName("Password contains no numbers")
    @Test
    void testContainsNumsHandler_NoNums() {
        check = new ContainsNumbersCheckHandler();
        assertFalse(check.handle(pwNoUpperNoSpecial));
    }

    @DisplayName("Password contains numbers but is too long")
    @Test
    void testContainsNumsHandler_TooLong() {
        check = new ContainsNumbersCheckHandler();
        assertTrue(check.handle(pwTooLong));
    }

    @DisplayName("Password contains numbers but is too long")
    @Test
    void testContainsNumsHandler_Ok() {
        check = new ContainsNumbersCheckHandler();
        assertTrue(check.handle(pwOk));
    }

    @DisplayName("Password contains no special characters")
    @Test
    void testSpecialCharsHandler_NoSpecial() {

        check = new ContainsSpecialCheckHandler();
        assertFalse(check.handle(pwNoUpperNoSpecial));
    }

    @DisplayName("Password contains no special characters")
    @Test
    void testSpecialCharsHandler_NoSpecial2() {
        check = new ContainsSpecialCheckHandler();
        assertFalse(check.handle(pwNumbersAndChars));
    }

    @DisplayName("Password contains disallowed characters")
    @Test
    void testSpecialCharsHandler_Disallowed() {

        check = new ContainsSpecialCheckHandler();
        assertFalse(check.handle(pwDisallowedSpecialChars));
    }

    @DisplayName("Password contains only allowed special characters")
    @Test
    void testSpecialCharsHandler_Allowed() {

        check = new ContainsSpecialCheckHandler();
        assertTrue(check.handle(pwAllowedSpecialChars));
    }

    @DisplayName("Password ok")
    @Test
    void testSpecialCharsHandler_OK() {

        check = new ContainsSpecialCheckHandler();
        assertTrue(check.handle(pwOk));
    }




    @DisplayName("Password contains consecutive numbers")
    @Test
    void testConsecutiveNumsHandler_ConsecutiveNums() {

        check = new ConsecutiveNumbersCheckHandler();
        assertFalse(check.handle(pwConsecutiveNums));
    }


    @DisplayName("Password contains only numbers, no consecutives")
    @Test
    void testConsecutiveNumsHandler_OnlyNums() {

        check = new ConsecutiveNumbersCheckHandler();
        assertTrue(check.handle(pwOnlyNums));
    }


    @DisplayName("Password contains no special characters, only numbers and characters, no consecutives")
    @Test
    void testConsecutiveNumsHandler_NumbersAndChars() {
        check = new ConsecutiveNumbersCheckHandler();
        assertTrue(check.handle(pwNumbersAndChars));
    }

    @DisplayName("Password contains repeated numbers, no consecutive incrementing numbers")
    @Test
    void testConsecutiveNumsHandler_RepeatedNumbers() {
        check = new ConsecutiveNumbersCheckHandler();
        assertTrue(check.handle(pwRepeatedNums));
    }

    @DisplayName("Password ok")
    @Test
    void testConsecutiveNumsHandler_Ok() {
        check = new ConsecutiveNumbersCheckHandler();
        assertTrue(check.handle(pwOk));
    }

    @DisplayName("Password contains consecutive numbers, no repeats")
    @Test
    void testRepeatedNumsHandler_ConsecutiveNums() {

        check = new RepeatedNumbersCheckHandler();
        assertTrue(check.handle(pwConsecutiveNums));
    }

    @DisplayName("Password contains only numbers and repeats")
    @Test
    void testRepeatedNumsHandler_OnlyNumbers() {

        check = new RepeatedNumbersCheckHandler();
        assertFalse(check.handle(pwOnlyNums));
    }

    @DisplayName("Password contains repeated numbers")
    @Test
    void testRepeatedNumsHandler_RepeatedNumbers() {

        check = new RepeatedNumbersCheckHandler();
        assertFalse(check.handle(pwRepeatedNums));
    }

    @DisplayName("Password contains consecutive numbers and characters, no repeats")
    @Test
    void testRepeatedNumsHandler_NumbersAndChars() {

        check = new RepeatedNumbersCheckHandler();
        assertTrue(check.handle(pwNumbersAndChars));
    }

    @DisplayName("Password contains consecutive numbers, no repeats")
    @Test
    void testRepeatedNumsHandler_Ok() {

        check = new RepeatedNumbersCheckHandler();
        assertTrue(check.handle(pwOk));
    }

    @DisplayName("Tests client, chain of responsibility creation and correct return. Password is correct")
    @Test
    void testChain_PasswordOk() {
        PasswordChecker checker = new PasswordChecker();
        assertTrue(checker.checkPassword(pwOk));
    }

    @DisplayName("Tests client, chain of responsibility creation and correct return. Password is not correct")
    @Test
    void testChain_PasswordNotOk() {
        PasswordChecker checker = new PasswordChecker();
        assertFalse(checker.checkPassword(pwConsecutiveNums));
    }
}
