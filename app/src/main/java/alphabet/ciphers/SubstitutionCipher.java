package alphabet.ciphers;

public class SubstitutionCipher implements AlphabetCipher {
    private final MappingProvider mapping;

    SubstitutionCipher(MappingProvider mapping){
        this.mapping = mapping;
    }

    @Override
    public String encrypt(String plainText) {
        checkAlphabeticalCharacters( plainText );

        return cipherString( plainText , false);
    }

    @Override
    public String decrypt(String cipherText) {
        return cipherString( cipherText, true);
    }

    private void checkAlphabeticalCharacters(String text){
        if(hasNoAlphabeticalCharacters( text )){
            throw new IllegalArgumentException("No characters to cipher");
        }
    }

    private boolean hasNoAlphabeticalCharacters(String plainText){
        for(char ch: plainText.toCharArray()){
            if(isAlphabetChar(ch)){
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

        for( char character: text.toCharArray()){
            if(isAlphabetChar( character )){
                cipherString += cipherChar( character , decipher);
                continue;
            }
            cipherString += character;
        }

        return cipherString;
    }

    private Character cipherChar(Character character, boolean decipher){
        if(decipher){
            return this.mapping.getDecryptedCharacter( character );
        }
        return this.mapping.getEncryptedCharacter( character );
    }
}
