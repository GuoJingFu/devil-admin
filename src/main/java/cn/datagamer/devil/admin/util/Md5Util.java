package cn.datagamer.devil.admin.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Util {

    private static String inStr;
    private static MessageDigest md5;

    public Md5Util(String inStr) {
        this.inStr = inStr;
        try {
            this.md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // md5 加密（32位）
    public static String compute(String plainText) {
        String result = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();

            int i;

            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }

}
