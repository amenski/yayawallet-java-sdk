package com.yaya.sdk.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yaya.sdk.client.ApiClient;
import com.yaya.sdk.client.ApiClient.HttpMethod;
import com.yaya.sdk.config.ApiEndpoints;
import com.yaya.sdk.exceptions.AirtimeServiceException;
import com.yaya.sdk.exceptions.ApiException;
import com.yaya.sdk.exceptions.ValidationException;
import com.yaya.sdk.models.Airtime;
import com.yaya.sdk.validators.PhoneValidator;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.yaya.sdk.client.ApiClient.HttpMethod.GET;
import static com.yaya.sdk.client.ApiClient.HttpMethod.POST;

public class AirtimeService {
    private final ApiClient apiClient;

    private static final String PHONE_PARAM = "phone";
    private static final String AMOUNT_PARAM = "amount";
    private static final String PACKAGE_PARAM = "package";

    public AirtimeService(ApiClient apiClient) {
        this.apiClient = Objects.requireNonNull(apiClient, "ApiClient cannot be null");
    }

    /**
     * Purchases airtime for a specified phone number.
     *
     * @param phone The recipient's phone number
     * @param amount The amount of airtime to purchase
     * @return Details of the airtime purchase
     * @throws ValidationException if the input parameters are invalid
     */
    public Airtime buyAirtime(String phone, String amount) throws ValidationException, ApiException {
        validatePhone(phone);
        validateAmount(amount);

        Map<String, Object> payload = new HashMap<>();
        payload.put(PHONE_PARAM, phone);
        payload.put(AMOUNT_PARAM, amount);

        return apiClient.sendRequest(
                HttpMethod.POST,
                ApiEndpoints.AIRTIME_BUY,
                null,
                payload,
                Airtime.class,
                "Failed to purchase airtime"
        );
    }

    /**
     * Retrieves a list of all recharge transactions.
     *
     * @return Array of airtime transactions
     * @throws AirtimeServiceException if the retrieval operation fails
     */
    public Airtime[] listRecharges() throws AirtimeServiceException, ApiException {
        return apiClient.sendRequest(
                GET,
                ApiEndpoints.AIRTIME_RECHARGES_LIST,
                null,
                null,
                Airtime[].class,
                "Failed to retrieve recharge history"
        );
    }

    /**
     * Purchases a specific package for a phone number.
     *
     * @param phone The recipient's phone number
     * @param packageCode The code of the package to purchase
     * @return Details of the package purchase
     * @throws ValidationException if the input parameters are invalid
     * @throws AirtimeServiceException if the purchase operation fails
     */
    public Airtime buyPackage(String phone, String packageCode) throws ValidationException, ApiException {
        validatePhone(phone);
        validatePackageCode(packageCode);

        Map<String, Object> payload = new HashMap<>();
        payload.put(PHONE_PARAM, phone);
        payload.put(PACKAGE_PARAM, packageCode);

        return apiClient.sendRequest(
                POST,
                ApiEndpoints.AIRTIME_BUY,
                null,
                payload,
                Airtime.class,
                "Failed to purchase package"
        );
    }

    /**
     * Retrieves available packages for a specific phone number.
     *
     * @param phone The phone number to check packages for
     * @return Array of available packages
     * @throws ValidationException if the phone number is invalid
     */
    public Package[] listPackages(String phone) throws ApiException, ValidationException {
        validatePhone(phone);

        Map<String, Object> payload = new HashMap<>();
        payload.put(PHONE_PARAM, phone);

        return apiClient.sendRequest(
                POST,
                ApiEndpoints.PACKAGES_LIST,
                null,
                payload,
                Package[].class,
                "Failed to retrieve packages"
        );
    }

    private void validatePhone(String phone) throws ValidationException {
        if (!PhoneValidator.isValid(phone)) {
            throw new ValidationException("Invalid phone number format");
        }
    }

    private void validateAmount(String amount) throws ValidationException {
        try {
            double amountValue = Double.parseDouble(amount);
            if (amountValue <= 0) {
                throw new ValidationException("Amount must be greater than zero");
            }
        } catch (NumberFormatException e) {
            throw new ValidationException("Invalid amount.");
        }
    }

    private void validatePackageCode(String packageCode) throws ValidationException {
        if (packageCode == null || packageCode.trim().isEmpty()) {
            throw new ValidationException("Package code cannot be empty");
        }
    }
}