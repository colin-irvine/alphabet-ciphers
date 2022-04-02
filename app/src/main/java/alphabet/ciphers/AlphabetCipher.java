package alphabet.ciphers;

public interface AlphabetCipher {
    String encrypt(String plainText);
    String decrypt(String cipherText);
}
