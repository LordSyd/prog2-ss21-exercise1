import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PwdCheckTest {

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
    private PwdCheck check;
    private String pwOnlyNums;

    //todo refactor tests to test Handler Methods

    @BeforeAll
    static void init() {

    }

    @BeforeEach
    void setUp() {
        check = new PwdCheck();

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

    @Test
    void testLength() {

        assertFalse(check.checkLengthOk(pwTooShort));
        assertFalse(check.checkLengthOk(pwTooLong));
        assertTrue(check.checkLengthOk(pwOk));

    }

    @Test
    void pwNotNull() {

        assertFalse(check.checkNotNull(pwIsNull));
        assertTrue(check.checkNotNull(pwOk));
    }

    @Test
    void testContainsUpperCase() {

        assertFalse(check.checkUpperCase(pwNoUpperNoSpecial));
        assertTrue(check.checkUpperCase(pwOk));
        assertTrue(check.checkUpperCase(pwConsecutiveNums));

    }

    @Test
    void testContainsNums() {

        assertFalse(check.checkContainsNums(pwNoUpperNoSpecial));
        assertTrue(check.checkContainsNums(pwOk));
        assertTrue(check.checkContainsNums(pwTooLong));
    }

    @Test
    void testContainsAllowedSpecialChars() {

        assertFalse(check.checkContainsAllowedSpecialChars(pwNoUpperNoSpecial));
        assertFalse(check.checkContainsAllowedSpecialChars(pwDisallowedSpecialChars));
        assertTrue(check.checkContainsAllowedSpecialChars(pwOk));
        assertTrue(check.checkContainsAllowedSpecialChars(pwAllowedSpecialChars));
        assertFalse(check.checkContainsAllowedSpecialChars(pwNumbersAndChars));


    }

    @Test
    void testContainsNoConsecutiveNums() {

        assertFalse(check.containsNoConsecutiveNums(pwConsecutiveNums));
        assertTrue(check.containsNoConsecutiveNums(pwOnlyNums));
        assertTrue(check.containsNoConsecutiveNums(pwNumbersAndChars));
        assertTrue(check.containsNoConsecutiveNums(pwOk));
        assertTrue(check.containsNoConsecutiveNums(pwRepeatedNums));

    }



    @Test
    void testContainsNoRepeatedNums() {

        assertTrue(check.containsNoRepeatedNums(pwConsecutiveNums));
        assertFalse(check.containsNoRepeatedNums(pwOnlyNums));
        assertFalse(check.containsNoRepeatedNums(pwRepeatedNums));
        assertTrue(check.containsNoRepeatedNums(pwNumbersAndChars));
        assertTrue(check.containsNoRepeatedNums(pwOk));

    }

    @Test
    void testChain() {
        PasswordChecker checker = new PasswordChecker();

        assertTrue(checker.checkPassword(pwOk));
        assertFalse(checker.checkPassword(pwOnlyNums));
        assertFalse(checker.checkPassword(pwNumbersAndChars));
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
