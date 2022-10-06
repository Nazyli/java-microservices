package com.api.sample.util;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

public class hash {
    public static class SHA_256 {

        public static byte[] digest(String data){
            return DigestUtils.sha256(data);
        }

        public static byte[] digest(byte[] data){
            return DigestUtils.sha256(data);
        }

        public static String digestAsHex(String data){
            return DigestUtils.sha256Hex(data);
        }

        public static String digestAsHex(byte[] data){
            return DigestUtils.sha256Hex(data);
        }

        public static byte[] digestAsBase64(String data){
            return Base64.encodeBase64(digest(data));
        }

        public static byte[] digestAsBase64(byte[] data){
            return Base64.encodeBase64(digest(data));
        }

        public static String digestAsBase64String(String data){
            return Base64.encodeBase64String(digest(data));
        }

        public static String digestAsBase64String(byte[] data){
            return Base64.encodeBase64String(digest(data));
        }

    }
}
