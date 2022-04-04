package alphabet.ciphers;

import org.junit.Test;

import java.io.FileNotFoundException;

public class TestTextFileMappingProvider {

    @Test( expected = FileNotFoundException.class )
    public void testTextFileMappingProviderWhenFileDoesNotExistExpectException() throws Exception {
        TextFileMappingProvider mappingProvider = new TextFileMappingProvider("not a file path");
    }

    @Test( expected = IllegalArgumentException.class)
    public void testTextFileMappingProviderWhenMappingsAreTheSameExpectException() throws Exception {
        TextFileMappingProvider mappingProvider = new TextFileMappingProvider("C:/Users/colin/alphabet-ciphers/app/src/test/resources/same-mapping-ciphers");
    }

    @Test( expected = IllegalArgumentException.class )
    public void testTextFileMappingProviderWhenMappingsAreDifferentLengthsExpectException() throws Exception {
        TextFileMappingProvider mappingProvider = new TextFileMappingProvider("C:/Users/colin/alphabet-ciphers/app/src/test/resources/different-length-mapping-ciphers");
    }

    @Test( expected = IllegalArgumentException.class )
    public void testTextFileMappingProviderWhenFirstMappingIsNotDistinctExpectException() throws Exception {
        TextFileMappingProvider mappingProvider = new TextFileMappingProvider("C:/Users/colin/alphabet-ciphers/app/src/test/resources/first-line-not-distinct-cipher");
    }

    @Test( expected = IllegalArgumentException.class )
    public void testTextFileMappingProviderWhenMappingIsNotOneToOneExpectException() throws Exception {
        TextFileMappingProvider mappingProvider = new TextFileMappingProvider("C:/Users/colin/alphabet-ciphers/app/src/test/resources/not-one-to-one-mapping-cipher");
    }

    @Test( expected = IllegalArgumentException.class )
    public void testTextFileMappingProviderWhenMappingFileIsEmptyExpectException() throws Exception {
        TextFileMappingProvider mappingProvider = new TextFileMappingProvider("C:/Users/colin/alphabet-ciphers/app/src/test/resources/empty-file");
    }

    @Test( expected = IllegalArgumentException.class )
    public void testTextFileMappingProviderWhenMappingFileOnlyHasOneLineExpectException() throws Exception {
        TextFileMappingProvider mappingProvider = new TextFileMappingProvider("C:/Users/colin/alphabet-ciphers/app/src/test/resources/only-first-line");
    }

    @Test( expected = IllegalArgumentException.class )
    public void testTextFileMappingProviderWhenMappingFileFirstLineIsBlankSecondIsGoodExpectException() throws Exception {
        TextFileMappingProvider mappingProvider = new TextFileMappingProvider("C:/Users/colin/alphabet-ciphers/app/src/test/resources/blank-first-line-good-second-line");
    }

}
