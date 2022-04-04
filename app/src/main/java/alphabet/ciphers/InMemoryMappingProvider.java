package alphabet.ciphers;

import java.util.HashMap;
import java.util.Map;

public class InMemoryMappingProvider implements MappingProvider{
    private Map<Character, Character> decryptedCharacterMap = new HashMap<>();
    private Map<Character, Character> encryptedCharacterMap = new HashMap<>();

    InMemoryMappingProvider(){
        setDecryptedCharacterMap();
        setEncryptedCharacterMap();
    }

    @Override
    public Character getEncryptedCharacter(Character character) {
        return this.encryptedCharacterMap.get( character );
    }

    @Override
    public Character getDecryptedCharacter(Character character) {
        return this.decryptedCharacterMap.get( character );
    }

    private void setDecryptedCharacterMap(){
        String alphabetStr = "abcdefghijklmnopqrstuvwxyz";
        String alBhedAlphabetStr = "ypltavkrezgmshubxncdijfqow";

        for ( int i = 0; i < 26; ++i ) {
            this.encryptedCharacterMap.put(alBhedAlphabetStr.charAt(i),
                    alphabetStr.charAt(i));
            this.encryptedCharacterMap.put(alBhedAlphabetStr.toUpperCase().charAt(i),
                    alphabetStr.toUpperCase().charAt(i));
        }
    }

    private void setEncryptedCharacterMap(){
        String alphabetStr = "abcdefghijklmnopqrstuvwxyz";
        String alBhedAlphabetStr = "ypltavkrezgmshubxncdijfqow";

        for ( int i = 0; i < 26; ++i ) {
            this.encryptedCharacterMap.put(alphabetStr.charAt(i),
                    alBhedAlphabetStr.charAt(i));
            this.encryptedCharacterMap.put(alphabetStr.toUpperCase().charAt(i),
                    alBhedAlphabetStr.toUpperCase().charAt(i));
        }
    }
}
