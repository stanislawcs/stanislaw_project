package by.stanislaw.it.encoder;

import org.apache.commons.codec.digest.DigestUtils;

public class PasswordEncoder {
    public static String encodePassword(String password) {
        return DigestUtils.md5Hex(password);
    }
}
