package com.example.serviceinventory.security;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.util.encoders.Hex;
import org.drools.core.util.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;

@Slf4j
public class EncryptDecrypt256 {

    static int iterations = 1000;
    private static final String ALGORITHM = "AES";
    private static final String CIPHERS = "AES/CBC/PKCS5Padding";
    static int keySize = 256;
    protected static String GENERATE_KEY = "PBKDF2WithHmacSHA1";

    public static String decryptAES(byte[] message, String phrase) {
        try {
            String respuesta = "";
            String salt = new String(Arrays.copyOfRange(message, 0, 32));
            String iv = new String(Arrays.copyOfRange(message, 32, 64));
            String data = new String(Arrays.copyOfRange(message, 64, message.length));
            SecretKey key = generateKey(salt, phrase);
            Cipher cipher = Cipher.getInstance(CIPHERS);
            cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(hex(iv)));
            respuesta = new String(cipher.doFinal(Base64.decodeBase64(data.getBytes())));
            return respuesta;
        } catch (Exception e) {
            System.err.println("Error " + e);
        }
        return null;
    }

    public static String encriptaValores(String input, String key) {
        String respuesta;
        try {
            log.info("ENCRIPTANDO VALORES PARA ENVIO POR CANALES");
            respuesta = new EncryptDecrypt256().encryptAES(input, key);
        } catch (Exception e) {
            log.error("ERROR AL ENCRIPTAR LOS VALORES POR CANAL");
            respuesta = input;
        }
        return respuesta;
    }

    public static String encryptAES(String message, String phrase) {
        try {
            String salt = random(16);
            String iv = random(16);
            SecretKey key = generateKey(salt, phrase);
            Cipher cipher = Cipher.getInstance(CIPHERS);
            cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(hex(iv)));
            byte[] encrypted = cipher.doFinal(message.getBytes(StandardCharsets.UTF_8));
            String code = Base64.encodeBase64String(encrypted).replaceAll("\r\n", StringUtils.EMPTY);
            return salt + iv + code;
        } catch (Exception e) {
            //throw new FitbankException("ERRWS","ERROR EN LA ENCRIPTACION",e);
        }
        return null;
    }

    private static String random(int length) {
        byte[] salt = new byte[length];
        new SecureRandom().nextBytes(salt);
        return hex(salt);
    }

    public static String hex(byte[] bytes) {
        return new String(Hex.encode(bytes));
    }

    public static byte[] hex(String str) {
        return Hex.decode(str.getBytes());
    }

    private static SecretKey generateKey(String salt, String passphrase) throws InvalidKeySpecException, NoSuchAlgorithmException {
        SecretKeyFactory factory = SecretKeyFactory.getInstance(GENERATE_KEY);
        KeySpec spec = new PBEKeySpec(passphrase.toCharArray(), hex(salt), iterations, keySize);
        return new SecretKeySpec(factory.generateSecret(spec).getEncoded(), ALGORITHM);
    }
}
