package com.yaya.sdk.validators;

import com.yaya.sdk.exceptions.SdkException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


class PhoneValidatorTest {

    @Test
    void testValidPhoneNumbers() {
        String[] validPhones = {
                "+251912345678",
                "+251712345678",
                "251912345678",
                "251712345678",
                "0912345678",
                "0712345678"
        };

        for (String phone : validPhones) {
            assertTrue(PhoneValidator.isValid(phone));
        }
    }

    @Test
    void testInvalidPhoneNumbers() {
        String[] invalidPhones = {
                "+251812345678", // Invalid prefix (8)
                "+25191234567",  // Too short
                "+2519123456789", // Too long
                "251612345678",  // Invalid prefix (6)
                "091234567",     // Too short
                "09123456789",   // Too long
                "+251912345ABC", // Contains letters
                "123456789",     // No prefix
                "+254912345678", // Wrong country code
                null,
                ""
        };

        for (String phone : invalidPhones) {
            assertFalse(PhoneValidator.isValid(phone));
        }
    }

    @Test
    void testIsNotValid() {
        String validPhone = "+251912345678";
        String invalidPhone = "invalid";

        assertTrue(PhoneValidator.isNotValid(invalidPhone));
        assertFalse(PhoneValidator.isNotValid(validPhone));
    }

    @Test
    void testPhoneNumberFormatting() {
        String[] testPhones = {
                "0912345678",    // Should format to +251912345678
                "251912345678",  // Should format to +251912345678
                "+251912345678"  // Should remain unchanged
        };

        for (String phone : testPhones) {
            String formatted = PhoneValidator.format(phone);
            assertTrue(formatted.startsWith("+251"));
            assertEquals(13, formatted.length());
        }
    }

    @Test
    void testFormatInvalidPhone() {
        assertThrows(IllegalArgumentException.class, () -> PhoneValidator.format("invalid"));
    }

    @org.junit.jupiter.api.Test
    void testValidCountryCodes() {
        String[] validPhones = {
                "+251912345678",
                "251912345678",
                "0912345678"
        };

        for (String phone : validPhones) {
            assertTrue(PhoneValidator.hasValidCountryCode(phone));
        }
    }

    @Test
    void testInvalidCountryCodes() {
        String[] invalidPhones = {
                "+254912345678",
                "254912345678",
                "1912345678"     // Invalid prefix
        };

        for (String phone : invalidPhones) {
            assertFalse(PhoneValidator.hasValidCountryCode(phone));
        }
    }

    @Test
    void testGetCarrierPrefix() throws SdkException {
        assertEquals("9", PhoneValidator.getCarrierPrefix("+251912345678"), "Should return 9 for Ethiotel");
        assertEquals("7", PhoneValidator.getCarrierPrefix("+251712345678"), "Should return 7 for Safaricom");
        assertEquals("9", PhoneValidator.getCarrierPrefix("0912345678"), "Should return 9 for Ethiotel with 0 prefix");
    }

    @Test
    void testGetCarrierPrefixInvalidPhone() {
        assertThrows(SdkException.class, () -> PhoneValidator.getCarrierPrefix("invalid"));
    }
}