package alphabet.ciphers;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestSubstitutionCipher {
    @Test( expected = IllegalArgumentException.class)
    public void testEncryptWhenBlankExpectException(){
        MappingProvider alBhedMap = new InMemoryMappingProvider();
        AlphabetCipher cipher = new SubstitutionCipher(alBhedMap);
        cipher.encrypt("");
    }

    @Test( expected = IllegalArgumentException.class)
    public void testEncryptWhenNoAlphabeticalCharactersExpectException(){
        MappingProvider alBhedMap = new InMemoryMappingProvider();
        AlphabetCipher cipher = new SubstitutionCipher(alBhedMap);
        cipher.encrypt("123 *&^% <>?");
    }

    @Test
    public void testEncryptWhenAlphabeticalCharactersArePresentExpectSuccess(){
        MappingProvider alBhedMap = new InMemoryMappingProvider();
        AlphabetCipher cipher = new SubstitutionCipher(alBhedMap);
        String expected = "Dra oui";
        String actual = cipher.encrypt("The you");
        assertEquals(expected, actual);
    }
}
