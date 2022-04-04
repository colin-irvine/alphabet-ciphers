package alphabet.ciphers;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestCaesarCipher {
    @Test( expected = IllegalArgumentException.class)
    public void testEncryptWhenBlankExpectException(){
        AlphabetCipher cipher = new ArithmeticCaesar();
        cipher.encrypt("");
    }

    @Test( expected = IllegalArgumentException.class)
    public void testEncryptWhenOnlyNumericCharactersExpectException(){
        AlphabetCipher cipher = new ArithmeticCaesar();
        cipher.encrypt("1234567890");
    }

    @Test( expected = IllegalArgumentException.class)
    public void testEncryptWhenOnlyNonAlphaNumericCharactersExpectException(){
        AlphabetCipher cipher = new ArithmeticCaesar();
        cipher.encrypt("!@#~;:%^&*()_-+={}[]?<>|");
    }

    @Test
    public void testEncryptWhenAlphabeticalCharactersExpectSuccess(){
        AlphabetCipher cipher = new ArithmeticCaesar();

        String expected = "def";
        String actual = cipher.encrypt("abc");
        assertEquals(expected, actual);
    }

    @Test
    public void testEncryptWhenAlphabeticalAndNonAlphabeticalCharactersExpectSuccess(){
        AlphabetCipher cipher = new ArithmeticCaesar();

        String expected = "dwwdfn dw gdzq";
        String actual = cipher.encrypt("attack at dawn");
        assertEquals(expected, actual);
    }

    @Test
    public void testEncryptWhenShiftedBy1ExpectSuccess(){
        ArithmeticCaesar arithmeticCaesar = new ArithmeticCaesar(1);

        AlphabetCipher cipher = arithmeticCaesar;

        String expected = "BCD";
        String actual = cipher.encrypt("ABC");
        assertEquals(expected, actual);

        expected ="ABC";
        actual = cipher.encrypt("ZAB");
        assertEquals(expected, actual);

        expected ="BCDEFGHIJKLMNOPQRSTUVWXYZA";
        actual = cipher.encrypt("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        assertEquals(expected, actual);
    }

    @Test
    public void testDecryptWhenShiftedBy1AlphabeticalAndNonAlphabeticalCharactersExpectSuccess(){
        ArithmeticCaesar arithmeticCaesar = new ArithmeticCaesar(1);

        AlphabetCipher cipher = arithmeticCaesar;

        String expected = "ZABC";
        String actual = cipher.decrypt("ABCD");
        assertEquals(expected, actual);

        expected ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        actual = cipher.decrypt("BCDEFGHIJKLMNOPQRSTUVWXYZA");
        assertEquals(expected, actual);
    }

}
