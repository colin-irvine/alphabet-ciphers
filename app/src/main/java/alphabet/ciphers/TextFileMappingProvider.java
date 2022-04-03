package alphabet.ciphers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TextFileMappingProvider implements MappingProvider {
    private String alphabetString;
    private String substituteAlphabetString;
    private Map<Character, Character> decryptedCharacterMap = new HashMap<>();
    private Map<Character, Character> encryptedCharacterMap = new HashMap<>();

    TextFileMappingProvider(String filePath) throws Exception {
        readSubstitutionMappingFromFile( filePath );
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

    private void readSubstitutionMappingFromFile(String filePath) throws Exception {
        String firstLine, secondLine;
        FileReader mappingFile = new FileReader( filePath );
        BufferedReader mappingReader = new BufferedReader( mappingFile );

        firstLine = mappingReader.readLine();
        secondLine = mappingReader.readLine();

        checkMappingIsValid( firstLine, secondLine );
        setAlphabetString( firstLine );
        setSubstituteAlphabetString( secondLine );
    }

    private void checkMappingIsValid(String alphabet, String substituteAlphabet) throws Exception {
        checkAlphabetsStringsAreDifferent( alphabet, substituteAlphabet );
        checkLengthsAreEqual( alphabet, substituteAlphabet );
        checkAlphabetSetsAreEqual( alphabet, substituteAlphabet );
    }

    private void checkAlphabetsStringsAreDifferent(String alphabet, String substituteAlphabet) throws Exception {
        if( alphabet.equals( substituteAlphabet )){
            throw new Exception("Mappings are the same, not possible to cipher");
        }
    }

    private void checkLengthsAreEqual(String alphabet, String substituteAlphabet) throws Exception {
        if( alphabet.length() != substituteAlphabet.length() )
            throw new Exception("Substitution mappings are of different lengths");
    }

    private void checkAlphabetSetsAreEqual(String alphabet, String substituteAlphabet) throws Exception {
        Set<Character> firstSet, secondSet;
        firstSet = new HashSet<>();
        secondSet = new HashSet<>();

        for( char character: alphabet.toCharArray()){
            firstSet.add( character );
        }

        for( char character: substituteAlphabet.toCharArray()){
            secondSet.add( character );
        }

        if( firstSet.stream().count() != alphabet.length() ){
            throw new Exception("Substitution mapping is not distinct: first line");
        }

        if( secondSet.stream().count() != substituteAlphabet.length() ){
            throw new Exception("Substitution mapping is not distinct: second line");
        }

        if( !firstSet.equals(secondSet) ){
            throw new Exception("Substitution mappings contain different characters");
        }
    }

    private void setAlphabetString(String alphabetString){
        this.alphabetString = alphabetString;
    }

    private void setSubstituteAlphabetString(String substituteAlphabetString){
        this.substituteAlphabetString = substituteAlphabetString;
    }

    private void setDecryptedCharacterMap(){
        int substitutionLength = this.alphabetString.length();

        for(int i = 0; i < substitutionLength; ++i){
            this.encryptedCharacterMap.put(this.substituteAlphabetString.charAt(i),
                    this.alphabetString.charAt(i));
            this.encryptedCharacterMap.put(this.substituteAlphabetString.toUpperCase().charAt(i),
                    this.alphabetString.toUpperCase().charAt(i));
        }
    }

    private void setEncryptedCharacterMap(){
        int substitutionLength = this.alphabetString.length();

        for(int i = 0; i < substitutionLength; ++i){
            this.encryptedCharacterMap.put( this.alphabetString.charAt(i),
                    this.substituteAlphabetString.charAt(i) );
            this.encryptedCharacterMap.put( this.alphabetString.toUpperCase().charAt(i),
                    this.substituteAlphabetString.toUpperCase().charAt(i) );
        }
    }
}
