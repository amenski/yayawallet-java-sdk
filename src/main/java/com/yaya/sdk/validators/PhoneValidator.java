package com.yaya.sdk.validators;

import com.yaya.sdk.exceptions.SdkException;
import com.yaya.sdk.exceptions.SdkExceptionSupplier;
import com.yaya.sdk.util.StringUtils;

import java.util.regex.Pattern;

/**
 * Supports formats:
 * - +251912345678, +251712345678
 * - 251912345678, 251712345678
 * - 0912345678, 0712345678
 */
public class PhoneValidator {
    private static final Pattern ETH_PHONE_PATTERN = Pattern.compile("^(\\+251|251|0)?[79]\\d{8}$");

    private PhoneValidator() {
        //
    }

    public static boolean isValid(final String phone) {
        if (StringUtils.isBlank(phone)) {
            return false;
        }

        String normalizedNumber = normalize(phone);
        return ETH_PHONE_PATTERN.matcher(normalizedNumber).matches();
    }

    public static boolean isNotValid(String phone) {
        return !isValid(phone);
    }

    /**
     * Formats the phone number to standard format (+251).
     *
     * @param phone The phone number to format
     * @return Formatted phone number
     * @throws IllegalArgumentException if the phone number is invalid
     */
    public static String format(final String phone) {
        if (isNotValid(phone)) {
            throw new IllegalArgumentException("Invalid Ethiopian phone number: " + phone);
        }

        String normalized = normalize(phone);
        if (normalized.startsWith("0")) {
            return "+251" + normalized.substring(1);
        } else if (!normalized.startsWith("+")) {
            return "+" + normalized;
        }
        return normalized;
    }

    /**
     * Normalizes a phone number by removing all non-digit characters
     * except the leading plus sign.
     */
    private static String normalize(final String phone) {
        if (phone == null) {
            return "";
        }

        String cleaned = phone.trim();
        if (cleaned.startsWith("+")) {
            return "+" + cleaned.substring(1).replaceAll("[^0-9]", "");
        }
        return cleaned.replaceAll("[^0-9]", "");
    }

    public static boolean hasValidCountryCode(final String phone) {
        if (isNotValid(phone)) {
            return false;
        }

        String normalized = normalize(phone);
        return normalized.startsWith("+251") ||
                normalized.startsWith("251") ||
                normalized.startsWith("0");
    }

    /**
     * Extracts the carrier prefix (safari-7 or ethiotel-9) from the phone number.
     *
     * @param phone The phone number to check
     * @return The carrier prefix (7 or 9)
     * @throws IllegalArgumentException if the phone number is invalid
     */
    public static String getCarrierPrefix(final String phone) throws SdkException {
        if (isNotValid(phone)) {
            throw SdkExceptionSupplier.INVALID_PHONE_NUMBER.get();
        }

        String normalized = normalize(phone);
        if (normalized.startsWith("+251") || normalized.startsWith("251")) {
            return normalized.substring(4, 5);
        } else if (normalized.startsWith("0")) {
            return normalized.substring(1, 2);
        }
        return "";
    }
}