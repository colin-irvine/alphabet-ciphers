package alphabet.ciphers;

public interface MappingProvider {
    Character getEncryptedCharacter(Character character);
    Character getDecryptedCharacter(Character character);
}
