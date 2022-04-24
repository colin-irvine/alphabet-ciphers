package alphabet.ciphers;

/*
 * This class is responsible for performing substitution cipher
 * operations on text passed to its encrypt and decrypt methods.
 * Every letter has (or at least should) another letter assigned to
 * use as a substitute. For example, if the letters T, H an E have
 * the substitutes D,R and A respectively then the word 'The' gets
 * encrypted to the word 'Dra'.
 *
 * On construction/initialisation, a mapping provider is passed
 * to be used to swap/substitute characters for the encryption
 * and decryption.
 */

public class SubstitutionCipher implements AlphabetCipher {
    private final MappingProvider mapping;

    SubstitutionCipher(MappingProvider mapping){
        this.mapping = mapping;
    }

    @Override
    /** Ciphers the text passed using a substitution cipher
     *
     * @param plainText - Text to ciphered
     * @return cipher text made by ciphering the plainText parameter
     */
    public String encrypt(String plainText) {
        checkAlphabeticalCharacters( plainText );

        return cipherString( plainText , false);
    }

    @Override
    /** Deciphers the text passed using a substitution cipher
     *
     * @param plainText - Text to ciphered
     * @return cipher text made by ciphering the plainText parameter
     */
    public String decrypt(String cipherText) {
        return cipherString( cipherText, true);
    }

    private void checkAlphabeticalCharacters(String text){
        if ( hasNoAlphabeticalCharacters( text ) ) {
            throw new IllegalArgumentException("No characters to cipher");
        }
    }

    private boolean hasNoAlphabeticalCharacters(String plainText){
        for ( char ch: plainText.toCharArray() ) {
            if ( isAlphabetChar(ch) ) {
                return false;
            }
        }
        return true;
    }

    private boolean isAlphabetChar(Character character){
        return Character.isAlphabetic( character );
    }

    private String cipherString(String text, boolean decipher){
        String cipherString = "";

        for ( char character: text.toCharArray() ) {
            if ( isAlphabetChar( character ) ) {
                cipherString += cipherChar( character , decipher);
                continue;
            }
            cipherString += character;
        }

        return cipherString;
    }

    private Character cipherChar(Character character, boolean decipher){
        if ( decipher ) {
            return this.mapping.getDecryptedCharacter( character );
        }
        return this.mapping.getEncryptedCharacter( character );
    }
}
