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

    }

    @Test
    void testLength() {
        PwdCheck check = new PwdCheck();
        assertFalse(check.checkLengthOk(pwTooShort));
        assertFalse(check.checkLengthOk(pwTooLong));
        assertTrue(check.checkLengthOk(pwOk));

    }

    @Test
    void pwNotNull() {
        PwdCheck check = new PwdCheck();
        assertFalse(check.checkNotNull(pwIsNull));
        assertTrue(check.checkNotNull(pwOk));
    }

    @Test
    void testContainsUpperCase() {
        PwdCheck check = new PwdCheck();
        assertFalse(check.checkUpperCase(pwNoUpperNoSpecial));
        assertTrue(check.checkUpperCase(pwOk));
        assertTrue(check.checkUpperCase(pwConsecutiveNums));

    }

    @Test
    void testContainsNums() {
        PwdCheck check = new PwdCheck();
        assertFalse(check.checkContainsNums(pwNoUpperNoSpecial));
        assertTrue(check.checkContainsNums(pwOk));
        assertTrue(check.checkContainsNums(pwTooLong));
    }

}
