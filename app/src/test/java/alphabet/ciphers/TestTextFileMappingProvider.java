package alphabet.ciphers;

import org.junit.Test;

public class TestTextFileMappingProvider {

    @Test( expected = Exception.class)
    public void testTextFileMappingProviderWhenMappingsAreTheSameExpectException() throws Exception {
        TextFileMappingProvider mappingProvider = new TextFileMappingProvider("C:/Users/colin/alphabet-ciphers/app/src/test/resources/same-mapping-ciphers");
    }

    @Test( expected = Exception.class )
    public void testTextFileMappingProviderWhenFileDoesNotExistExpectException() throws Exception {
        TextFileMappingProvider mappingProvider = new TextFileMappingProvider("not a file path");
    }

    @Test( expected = Exception.class )
    public void testTextFileMappingProviderWhenMappingsAreDifferentLengthsExpectException() throws Exception {
        TextFileMappingProvider mappingProvider = new TextFileMappingProvider("C:/Users/colin/alphabet-ciphers/app/src/test/resources/different-length-mapping-ciphers");
    }

    @Test( expected = Exception.class )
    public void testTextFileMappingProviderWhenFirstMappingIsNotDistinctExpectException() throws Exception {
        TextFileMappingProvider mappingProvider = new TextFileMappingProvider("C:/Users/colin/alphabet-ciphers/app/src/test/resources/first-line-not-distinct-cipher");
    }

    @Test( expected = Exception.class )
    public void testTextFileMappingProviderWhenMappingIsNotOneToOneExpectException() throws Exception {
        TextFileMappingProvider mappingProvider = new TextFileMappingProvider("C:/Users/colin/alphabet-ciphers/app/src/test/resources/not-one-to-one-mapping-cipher");
    }


}
