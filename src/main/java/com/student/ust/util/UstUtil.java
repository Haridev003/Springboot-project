package com.student.ust.util;

import com.student.ust.exception.InvalidException;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Ust util.
 */
public class UstUtil {

    /**
     * Email vaild int.
     *
     * @param email the email
     * @return the int
     */
    public static int emailVaild(String email) {
        String regex = "^([A-Za-z0-9+_.-]+)@([A-Za-z0-9]+)\\.([a-z]+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            return 1;
        } else {
            throw new InvalidException();
        }
    }

    /**
     * Password valid int.
     *
     * @param password the password
     * @return the int
     */
    public static int passwordValid(String password) {
        //String regex = "^.*(?=.{6,})(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!&$%&? \"]).*$";
        String regex = "^(?=(?:.*\\d){3,})(?=\\S+$)(?=.*[@#$%^&+=])(?=(?:.*[A-Za-z]){3,})(?=.*[A-Z]).{7,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        if(matcher.matches()){
            return 1;
        }
        else{
            throw new InvalidException();
        }


    }

    /**
     * Get sha byte [ ].
     *
     * @param input the input
     * @return the byte [ ]
     * @throws NoSuchAlgorithmException the no such algorithm exception
     */
    public static byte[] getSHA(String input) throws NoSuchAlgorithmException
    {
        // Static getInstance method is called with hashing SHA
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        // digest() method called
        // to calculate message digest of an input
        // and return array of byte
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * To hex string string.
     *
     * @param hash the hash
     * @return the string
     */
    public static String toHexString(byte[] hash)
    {
        // Convert byte array into signum representation
        BigInteger number = new BigInteger(1, hash);

        // Convert message digest into hex value
        StringBuilder hexString = new StringBuilder(number.toString(16));

        // Pad with leading zeros
        while (hexString.length() < 64)
        {
            hexString.insert(0, '0');
        }

        return hexString.toString();
    }
}
