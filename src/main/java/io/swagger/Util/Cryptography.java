package io.swagger.Util;

import io.swagger.service.VerifyAccountServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class Cryptography {

    private static final Logger log = LoggerFactory.getLogger(Cryptography.class);
    private static SecretKeySpec secretKey;
    private static byte[] key;

    public static void setKey(String myKey)
    {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-256");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");
        }
        catch (NoSuchAlgorithmException e) {
            log.error("NoSuchAlgorithmException: " +e.getMessage());

        }
        catch (UnsupportedEncodingException e) {
            log.error("UnsupportedEncodingException: " +e.getMessage());
        }
    }

    public static String encrypt(String strToEncrypt)
    {
        try
        {
            setKey("BAV@EncrytionKey!test");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            log.info(" encrypting: " + Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8"))));
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));

        }
        catch (Exception e)
        {
            log.error("Error while encrypting: " +e.getMessage());

        }
        return null;
    }

    public static String decrypt(String strToDecrypt)
    {
        try
        {
            setKey("BAV@EncrytionKey!test");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            String result = new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
            log.info(" decrypting: " + result);

            return result;
        }
        catch (Exception e)
        {
            log.error("Error while decrypting: " +e.getMessage());
        }
        return null;
    }
}
