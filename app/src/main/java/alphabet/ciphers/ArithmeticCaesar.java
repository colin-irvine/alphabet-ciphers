package alphabet.ciphers;

/*
 * This class is responsible for performing Caesar or Shift cipher
 * operations on text passed to its encrypt and decrypt methods.
 * A shift value is used to move the characters forwards or backwards
 * through the alphabet. For example, with a shift value of 3 the
 * string 'abc' encrypted becomes 'def'. With a shift value of 3 the
 * string 'abc' decrypted becomes 'xyz'.
 */

public class ArithmeticCaesar implements AlphabetCipher {
    private int shiftValue;

    /*
     * If cipher 'shift' value not provided
     *      default the value to 3
     */
    public ArithmeticCaesar(){
        setShiftValue( 3 );
    }

    /*
     * Set 'shift' value provided
     * @param shiftValue - integer value to be used as 'shift' to cipher and decipher
     */
    public ArithmeticCaesar(int shiftValue){
        setShiftValue( shiftValue );
    }

    @Override
    /* Ciphers the text passed using a basic Caesar cipher by moving
     * the letters in the alphabet
     *
     * @param plainText - Text to ciphered
     * @return cipher text made by ciphering the plainText parameter
     */
    public String encrypt(String plainText) {
        checkAlphabeticalCharacters( plainText );

        return cipherString( plainText, false );
    }

    @Override
    /* Deciphers the text passed using a basic Caesar cipher by moving
     * the letters the opposite direction in the alphabet
     *
     * @param cipherText - Text to be deciphered
     * @return plain text made by deciphering the cipherText parameter
     */
    public String decrypt(String cipherText) {
        checkAlphabeticalCharacters( cipherText );

        return cipherString( cipherText, true);
    }

    private void setShiftValue(int shiftValue){
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
