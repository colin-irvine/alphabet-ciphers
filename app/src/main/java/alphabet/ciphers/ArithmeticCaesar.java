package alphabet.ciphers;

public class ArithmeticCaesar implements AlphabetCipher {
    private int shiftValue;

    ArithmeticCaesar(){
        setShiftValue( 3 );
    }

    @Override
    public String encrypt(String plainText) {
        checkAlphabeticalCharacters( plainText );

        return cipherString( plainText, false );
    }

    @Override
    public String decrypt(String cipherText) {
        checkAlphabeticalCharacters( cipherText );

        return cipherString( cipherText, true);
    }

    public void setShiftValue(int shiftValue){
        this.shiftValue = shiftValue;
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

    private String cipherString(String text, boolean Decipher){
        String cipherText = "";
        int shiftValue;

        shiftValue = Decipher ? - this.shiftValue : this.shiftValue;

        for ( char character: text.toCharArray() ){
            if (isAlphabetChar( character )) {
                cipherText += cipherChar( character, shiftValue );
                continue;
            }
            cipherText += character;
        }

        return cipherText;
    }

    private boolean isAlphabetChar(Character character){
        return Character.isAlphabetic( character );
    }

    private Character cipherChar(Character character, int shiftValue){
        String alphabetStr = "abcdefghijklmnopqrstuvwxyz";
        boolean upperFlag = Character.isUpperCase(character);
        int charIndex;

        if ( upperFlag ) {
            charIndex = alphabetStr.toUpperCase().indexOf( character );
            return alphabetStr.toUpperCase().charAt( wrapIndexToAlphabet( charIndex + shiftValue ) );
        }

        charIndex = alphabetStr.indexOf( character );

        return alphabetStr.charAt( wrapIndexToAlphabet( charIndex + shiftValue ) );
    }

    private int wrapIndexToAlphabet(int n){
        if ( n < 0 ) {
            return 26 - Math.abs( n % 26 );
        }
        return Math.abs( n % 26 );
    }
}
