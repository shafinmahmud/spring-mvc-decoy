package net.shafin.decoy.util;

import org.mindrot.jbcrypt.BCrypt;

/**
 * @author SHAFIN
 * @since 12/12/2016
 */
public class CryptoUtil {

    public static String generateSecurePasswordHash(String originalPassword) {
        return BCrypt.hashpw(originalPassword, BCrypt.gensalt(12));
    }

    public static boolean matchProvidedPassword(String providedPassword, String passwordHash) {
        return BCrypt.checkpw(providedPassword, passwordHash);
    }
}
