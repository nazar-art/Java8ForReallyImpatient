package com.demo.ch8.sec05;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * @author Nazar_Lelyak.
 */
public class EncodingDemo {
    public static final char[] HEX_CHARS = "0123456789ABCDEF".toCharArray();
    public static final String TEST_TEXT = "This is a hash test";

    public enum EncodingTypes {
        MD_5("MD5"),
        SHA_1("SHA-1"),
        SHA_256("SHA-256"),
        SHA_384("SHA-384"),
        SHA_512("SHA-512");

        private String name;

        EncodingTypes(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static String encodeString(String text, EncodingTypes encodingType) {
        System.out.println("Original string: " + text);
        System.out.println("Hash type: " + encodingType.getName());
        String result = "";
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance(encodingType.getName());
            messageDigest.reset();
            messageDigest.update(text.getBytes(StandardCharsets.UTF_8));
            final byte[] resultByte = messageDigest.digest();
            result = decodeBytes(resultByte);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static String base64Encoding(String text) {
        System.out.println("Base 64 encoding in Java 8:");
        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(text.getBytes(StandardCharsets.UTF_8));
    }

    private static String decodeBytes(byte[] hash) {
        StringBuilder sb = new StringBuilder(hash.length * 2);
        for (byte b : hash) {
            sb.append(HEX_CHARS[(b & 0xF0) >> 4]);
            sb.append(HEX_CHARS[b & 0x0F]);
        }
//        sb.append("\n");
        return sb.toString();
    }

    public static void main(String[] args) {
        String md5 = encodeString(TEST_TEXT, EncodingTypes.MD_5);
        System.out.println(md5);
        String sha1 = encodeString(TEST_TEXT, EncodingTypes.SHA_1);
        System.out.println(sha1);
        String sha256 = encodeString(TEST_TEXT, EncodingTypes.SHA_256);
        System.out.println(sha256);
        String sha384 = encodeString(TEST_TEXT, EncodingTypes.SHA_384);
        System.out.println(sha384);
        String sha512 = encodeString(TEST_TEXT, EncodingTypes.SHA_512);
        System.out.println(sha512);
        System.out.println(sha512.length());
        System.out.println(base64Encoding(TEST_TEXT));
    }
}
