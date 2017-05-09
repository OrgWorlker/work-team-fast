package com.wtf.infrastructure.util;


import java.security.MessageDigest;

/**
 * The type Md 5 util.
 */
public class MD5Util {

    private static final String[] HEXDIGITS = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    private static String byteArrayToHexString(byte[] b) {
        final StringBuilder resultSb = new StringBuilder();
        for (byte b1 : b) {
            resultSb.append(byteToHexString(b1));
        }
        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            final int i = 256;
            n += i;
        }
        final int sixteen = 16;
        final int d1 = n / sixteen;
        final int d2 = n % sixteen;
        return HEXDIGITS[d1] + HEXDIGITS[d2];
    }

    /**
     * Md 5 encode string.
     *
     * @param origin      需要转换的字符串
     * @param charsetname 编码
     * @return the string
     */
    public static String md5Encode(String origin, String charsetname) {
        String resultString = null;
        try {
            resultString = origin;
            final MessageDigest md = MessageDigest.getInstance("MD5");
            if (charsetname == null || "".equals(charsetname)) {
                resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
            } else {
                resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetname)));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return resultString;
    }


    /**
     * Md 5 encode string.
     *
     * @param origin the origin
     * @return the string
     */
    public static String md5Encode(String origin) {
        String resultString = null;
        try {
            resultString = origin;
            final MessageDigest md = MessageDigest.getInstance("MD5");
            resultString = byteArrayToHexString(md.digest(resultString.getBytes("utf-8")));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return resultString;
    }

    public static void main(String[] args) {
        final String encode = md5Encode("123456");
        System.out.println("encode = " + encode);
    }

}
