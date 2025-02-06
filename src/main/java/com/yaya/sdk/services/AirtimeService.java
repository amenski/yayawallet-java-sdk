package com.yaya.sdk.services;

import com.yaya.sdk.client.ApiClient;
import com.yaya.sdk.client.ApiClient.HttpMethod;
import com.yaya.sdk.config.ApiEndpoints;
import com.yaya.sdk.exceptions.SdkException;
import com.yaya.sdk.exceptions.SdkExceptionSupplier;
import com.yaya.sdk.models.Airtime;
import com.yaya.sdk.validators.PhoneValidator;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.yaya.sdk.client.ApiClient.HttpMethod.GET;
import static com.yaya.sdk.client.ApiClient.HttpMethod.POST;

/**
 * Provides methods for purchasing airtime and packages.
 */
public class AirtimeService {
    private static final String PHONE_PARAM = "phone";
    private static final String AMOUNT_PARAM = "amount";
    private static final String PACKAGE_PARAM = "package";
    private final ApiClient apiClient;

    public AirtimeService(ApiClient apiClient) {
        this.apiClient = Objects.requireNonNull(apiClient, "ApiClient cannot be null");
    }

    /**
     * Purchases airtime for a specified phone number.
     *
     * @param phone  The recipient's phone number
     * @param amount The amount of airtime to purchase
     * @return Details of the airtime purchase
     * @throws SdkException if the input parameters are invalid
     */
    public Airtime buyAirtime(String phone, String amount) throws SdkException {
        try {
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
                    Airtime.class
            );
        } catch (SdkException e) {
            throw e;
        } catch (Exception e) {
            throw SdkExceptionSupplier.UNHANDLED_EXCEPTION.get(e.getMessage());
        }
    }

    /**
     * Retrieves a list of all recharge transactions.
     *
     * @return Array of airtime transactions
     */
    public Airtime[] listRecharges() throws SdkException {
        try {
            return apiClient.sendRequest(
                    GET,
                    ApiEndpoints.AIRTIME_RECHARGES_LIST,
                    null,
                    null,
                    Airtime[].class
            );
        } catch (SdkException e) {
            throw e;
        } catch (Exception e) {
            throw SdkExceptionSupplier.UNHANDLED_EXCEPTION.get(e.getMessage());
        }
    }

    /**
     * Purchases a specific package for a phone number.
     *
     * @param phone       The recipient's phone number
     * @param packageCode The code of the package to purchase
     * @return Details of the package purchase
     * @throws SdkException if the input parameters are invalid
     */
    public Airtime buyPackage(String phone, String packageCode) throws SdkException {
        try {
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
                    Airtime.class
            );
        } catch (SdkException e) {
            throw e;
        } catch (Exception e) {
            throw SdkExceptionSupplier.UNHANDLED_EXCEPTION.get(e.getMessage());
        }
    }

    /**
     * Retrieves available packages for a specific phone number.
     *
     * @param phone The phone number to check packages for
     * @return Array of available packages
     * @throws SdkException if the phone number is invalid
     */
    public Package[] listPackages(String phone) throws SdkException {
        try {
            validatePhone(phone);

            Map<String, Object> payload = new HashMap<>();
            payload.put(PHONE_PARAM, phone);

            return apiClient.sendRequest(
                    POST,
                    ApiEndpoints.PACKAGES_LIST,
                    null,
                    payload,
                    Package[].class
            );
        } catch (SdkException e) {
            throw e;
        } catch (Exception e) {
            throw SdkExceptionSupplier.UNHANDLED_EXCEPTION.get(e.getMessage());
        }
    }

    private void validatePhone(String phone) throws SdkException {
        if (PhoneValidator.isNotValid(phone)) {
            throw SdkExceptionSupplier.INVALID_PHONE_NUMBER.get(phone);
        }
    }

    private void validateAmount(String amount) throws SdkException {
        try {
            double amountValue = Double.parseDouble(amount);
            if (amountValue <= 0) {
                throw SdkExceptionSupplier.INVALID_AMOUNT.get(amount);
            }
        } catch (NumberFormatException e) {
            throw SdkExceptionSupplier.INVALID_AMOUNT.get(e.getMessage());
        }
    }

    private void validatePackageCode(String packageCode) throws SdkException {
        if (packageCode == null || packageCode.trim().isEmpty()) {
            throw SdkExceptionSupplier.INVALID_PACKAGE_CODE.get(packageCode);
        }
    }
}