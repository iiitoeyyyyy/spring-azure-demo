package com.demo.springapplication.config;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class CommonConstants {
    /**
     * ********* Common **********
     */
    public static final String JSON_TYPE = "application/json";
    public static final String TIMEZONE_BANGKOK = "Asia/Bangkok";
    public static final ZonedDateTime CURRENT_ZONED_DATE_TIME = ZonedDateTime.now((ZoneId.of(TIMEZONE_BANGKOK)));
    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static final String BEARER_KEY = "Bearer";
    public static final String CORRELATION_ID_HEADER_KEY = "correlationId";
    public static final String DEVICE_ID_HEADER = "deviceId";
    public static final String HEADER_STRING_ACCEPT_LANGUAGE = "accept-language";
    public static final String IS_INFO_MASKED_HEADER = "isInfoMasked";
    public static final String LANGUAGE_en = "en";
    public static final String LANGUAGE_TH = "th";
    public static final String LONG_FORMAT_DATETIME = "yyyy-MM-dd'T'HH:mm:ssXXX";
    public static final String LOOKUP_DEFAULT_MICROSERVICE = "cbdc-mb-customer-onboarding";
    public static final String LOOKUP_TYPE_ERROR_MESSAGE = "ERROR_MESSAGE";
    public static final String RESPONSE_AUTHORIZATION_MESSAGE = "MBGW Authentication failure.";
    public static final String STATUS_UNAUTHORIZED = "Unauthorized";
    public static final String USER_ID_HEADER = "userId";

    /**
     * Status Code
     */
    public static final String RESPONSE_CODE_1000 = "1000";
    public static final String RESPONSE_CODE_1001 = "1001";
    public static final String RESPONSE_CODE_1899 = "1899";
    public static final String RESPONSE_CODE_1999 = "1999";
    public static final String RESPONSE_CODE_9000 = "9000";

    /**
     * ********* Microservice specific below **********
     */
    public static final String STATUS_ACTIVE = "ACTIVE";
    public static final String STATUS_INACTIVE = "INACTIVE";

    public static final String RESOURCE_OWNER_ID_HEADER_KEY = "resourceOwnerId";
    public static final String PE_RESOURCE_OWNER_ID_HEADER_KEY = "peResourceOwnerId";
    public static final String SQL_TIME_FORMAT = "HH:mm:ss";

    /**
     * Status Code of mb-customer-onboarding only
     */

    public static final String RESPONSE_CODE_CUOB1000 = "CUOB1000";   // Check CBDC Downtime
    public static final String RESPONSE_CODE_CUOB1001 = "CUOB1001";
    public static final String RESPONSE_CODE_CUOB1002 = "CUOB1002";    // System Error
    public static final String RESPONSE_CODE_CUOB1003 = "CUOB1003";
    public static final String RESPONSE_CODE_CUOB1004 = "CUOB1004";   // App version does not Support
    public static final String RESPONSE_CODE_CUOB1005 = "CUOB1005";    // Success
    public static final String RESPONSE_CODE_CUOB1007 = "CUOB1007"; // Mobile Number List is null/empty
    public static final String RESPONSE_CODE_CUOB1008 = "CUOB1008"; // Email List is null/empty
    public static final String RESPONSE_CODE_CUOB1009 = "CUOB1009"; // Non-thai user
    public static final String RESPONSE_CODE_CUOB1010 = "CUOB1010"; // Failed to delete account
    public static final String RESPONSE_CODE_CUOB1012 = "CUOB1012"; // User profile inactive
    public static final String RESPONSE_CODE_CUOB1011 = "CUOB1011";
    public static final String RESPONSE_CODE_CUOB1899 = "CUOB1899";// Internal Error
    public static final String RESPONSE_CODE_CUOB1999 = "CUOB1999";
    public static final String RESPONSE_CODE_CUOB5006 = "CUOB5006";
    public static final String RESPONSE_DESC_CUOB1000 = "Success";
    public static final String DELETE_ACCOUNT_TEMPLATE_NAME = "DELETE_ACCOUNT_SUCCESSFUL";
    public static final String EMAIL_FROM = "SCB CBDC Wallet<no-reply@scb.co.th>";
}
