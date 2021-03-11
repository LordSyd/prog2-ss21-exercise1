import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @DisplayName("Test")
    @Test
    void testLength() {

        Handler check = new LengthCheckHandler();

        assertFalse(check.handle(pwTooShort));
        assertFalse(check.handle(pwTooLong));
        assertTrue(check.handle(pwOk));

    }

    @Test
    void pwNotNull() {

        Handler check = new LengthCheckHandler();

        assertFalse(check.handle(pwIsNull));
        assertTrue(check.handle(pwOk));
    }

    @Test
    void testContainsUpperCase() {

        Handler check = new UpperCaseCheckHandler();

        assertFalse(check.handle(pwNoUpperNoSpecial));
        assertTrue(check.handle(pwOk));
        assertTrue(check.handle(pwConsecutiveNums));
    }

    @Test
    void testContainsNums() {

        Handler check = new ContainsNumbersCheckHandler();

        assertFalse(check.handle(pwNoUpperNoSpecial));
        assertTrue(check.handle(pwOk));
        assertTrue(check.handle(pwTooLong));
    }

    @Test
    void testContainsAllowedSpecialChars() {

        Handler check = new ContainsSpecialCheckHandler();

        assertFalse(check.handle(pwNoUpperNoSpecial));
        assertFalse(check.handle(pwDisallowedSpecialChars));
        assertTrue(check.handle(pwOk));
        assertTrue(check.handle(pwAllowedSpecialChars));
        assertFalse(check.handle(pwNumbersAndChars));
    }

    @Test
    void testContainsNoConsecutiveNums() {

        Handler check = new ConsecutiveNumbersCheckHandler();

        assertFalse(check.handle(pwConsecutiveNums));
        assertTrue(check.handle(pwOnlyNums));
        assertTrue(check.handle(pwNumbersAndChars));
        assertTrue(check.handle(pwOk));
        assertTrue(check.handle(pwRepeatedNums));
    }

    @Test
    void testContainsNoRepeatedNums() {

        Handler check = new RepeatedNumbersCheckHandler();

        assertTrue(check.handle(pwConsecutiveNums));
        assertFalse(check.handle(pwOnlyNums));
        assertFalse(check.handle(pwRepeatedNums));
        assertTrue(check.handle(pwNumbersAndChars));
        assertTrue(check.handle(pwOk));
    }

    @Test
    void testChain() {
        PasswordChecker checker = new PasswordChecker();

        assertTrue(checker.checkPassword(pwOk));
        assertFalse(checker.checkPassword(pwOnlyNums));
        assertFalse(checker.checkPassword(pwNumbersAndChars));
        assertFalse(checker.checkPassword(pwRepeatedNums));
        assertFalse(checker.checkPassword(pwConsecutiveNums));
        assertFalse(checker.checkPassword(pwTooLong));
        assertFalse(checker.checkPassword(pwTooShort));
        assertFalse(checker.checkPassword(pwNoUpperNoSpecial));
        assertFalse(checker.checkPassword(pwNoSpecial));
        assertFalse(checker.checkPassword(pwDisallowedSpecialChars));
    }
}
