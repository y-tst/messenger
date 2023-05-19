package com.epam.ld.module2.testing;

import com.epam.ld.module2.testing.custom_annotatoins.MailAnnotation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailVerifier {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final String GMAIL_REGEX = "^[A-Za-z0-9+_.-]+@gmail.com";
    private static final String YAHOO_REGEX = "^[A-Za-z0-9+_.-]+@gmail.com";
    private static final Pattern pattern = Pattern.compile(EMAIL_REGEX);
    private static final Pattern gmailPattern = Pattern.compile(GMAIL_REGEX);
    private static final Pattern yahooPattern = Pattern.compile(YAHOO_REGEX);

    public static boolean isValidEmail(String email) {
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    @MailAnnotation(domainName = "Email belongs *gmail* domain")
    public static boolean isEmailDomainGmail(String email) {
        Matcher matcher = gmailPattern.matcher(email);
        return matcher.matches();
    }

    @MailAnnotation(domainName = "Email belongs *yahoo* domain")
    public static boolean isEmailDomainYahoo(String email) {
        Matcher matcher = gmailPattern.matcher(email);
        return matcher.matches();
    }
}
