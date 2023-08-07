package com.demo.springapplication.config.rest;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Enumeration;
import java.util.List;

@Configuration
@Slf4j
public class HttpHeaderConfig {
    public static final String ACCEPT_ENCODING_KEY = "accept-encoding";
    public static final String ACCEPT_KEY = "accept";
    public static final String ACCEPT_LANGUAGE_KEY = "accept-language";
    public static final String AUTHORIZATION_KEY = "authorization";
    public static final String CACHE_CONTROL_KEY = "cache-control";
    public static final String CLIENT_VERSION_KEY = "client-version";
    public static final String CONTENT_TYPE_KEY = "content-type";
    public static final String COOKIE_KEY = "cookie";
    public static final String CUSTTYPE_KEY = "custtype";
    public static final String HOST_KEY = "host";
    public static final String PLATFORM_KEY = "platform";
    public static final String REMOTEADDR_KEY = "remoteaddr";
    public static final String REQUESTUID_KEY = "requestuid";
    public static final String RESOURCEOWNERID_KEY = "resourceownerid";
    public static final String RESOURCEOWNERTYPE_KEY = "resourceownertype";
    public static final String SCB_CHANNEL_KEY = "scb-channel";
    public static final String TX_TOKEN_KEY = "tx-token";
    public static final String USER_AGENT_KEY = "user-agent";
    public static final String USERID_KEY = "userid";
    public static final String VIA_KEY = "via";
    public static final String X_AMZ_CF_ID_KEY = "x-amz-cf-id";
    public static final String X_B3_FLAGS_KEY = "x-b3-flags";
    public static final String X_B3_PARENTSPANID_KEY = "x-b3-parentspanid";
    public static final String X_B3_SAMPLED_KEY = "x-b3-sampled";
    public static final String X_B3_SPANID_KEY = "x-b3-spanid";
    public static final String X_B3_TRACEID_KEY = "x-b3-traceid";
    public static final String X_CORRELATION_ID_KEY = "x-correlation-id";
    public static final String X_DEVICE_BRAND_KEY = "x-device-brand";
    public static final String X_DEVICE_ID_KEY = "x-device-id";
    public static final String X_DEVICE_JAILBREAK_KEY = "x-device-jailbreak";
    public static final String X_DEVICE_MODEL_KEY = "x-device-model";
    public static final String X_DEVICE_NAME_KEY = "x-device-name";
    public static final String X_FORWARDED_FOR_KEY = "x-forwarded-for";
    public static final String X_FORWARDED_HOST_KEY = "x-forwarded-host";
    public static final String X_FORWARDED_PORT_KEY = "x-forwarded-port";
    public static final String X_FORWARDED_PROTO_KEY = "x-forwarded-proto";
    public static final String X_LOCATION_PERMISSION_KEY = "x-location-permission";
    public static final String X_NOTIFICATION_PERMISSION_KEY = "x-notification-permission";
    public static final String X_ORIGINAL_FORWARDED_FOR_KEY = "x-original-forwarded-for";
    public static final String X_OS_VERSION_KEY = "x-os-version";
    public static final String X_OT_SPAN_CONTEXT_KEY = "x-ot-span-context";
    public static final String X_PLATFORM_KEY = "x-platform";
    public static final String X_REAL_IP_KEY = "x-real-ip";
    public static final String X_REQUEST_ID_KEY = "x-request-id";
    public static final String X_SCHEME_KEY = "x-scheme";
    public static final String X_SIGNATURE_KEY = "x-signature";
    public static final String X_SPECIAL_FLAG_KEY = "x-special-flag";
    public static final String X_STAGING_TOKEN_KEY = "x-staging-token";
    public static final List<String> ALLOW_HEADER_LIST = List.of(ACCEPT_ENCODING_KEY, ACCEPT_KEY, ACCEPT_LANGUAGE_KEY, AUTHORIZATION_KEY, CACHE_CONTROL_KEY, CLIENT_VERSION_KEY, CONTENT_TYPE_KEY, COOKIE_KEY, CUSTTYPE_KEY, HOST_KEY, PLATFORM_KEY, REMOTEADDR_KEY, REQUESTUID_KEY, RESOURCEOWNERID_KEY, RESOURCEOWNERTYPE_KEY, SCB_CHANNEL_KEY, TX_TOKEN_KEY, USER_AGENT_KEY, USERID_KEY, VIA_KEY, X_AMZ_CF_ID_KEY, X_B3_FLAGS_KEY, X_B3_PARENTSPANID_KEY, X_B3_SAMPLED_KEY, X_B3_SPANID_KEY, X_B3_TRACEID_KEY, X_CORRELATION_ID_KEY, X_DEVICE_BRAND_KEY, X_DEVICE_ID_KEY, X_DEVICE_JAILBREAK_KEY, X_DEVICE_MODEL_KEY, X_DEVICE_NAME_KEY, X_FORWARDED_FOR_KEY, X_FORWARDED_HOST_KEY, X_FORWARDED_PORT_KEY, X_FORWARDED_PROTO_KEY, X_LOCATION_PERMISSION_KEY, X_NOTIFICATION_PERMISSION_KEY, X_ORIGINAL_FORWARDED_FOR_KEY, X_OS_VERSION_KEY, X_OT_SPAN_CONTEXT_KEY, X_PLATFORM_KEY, X_REAL_IP_KEY, X_REQUEST_ID_KEY, X_SCHEME_KEY, X_SIGNATURE_KEY, X_SPECIAL_FLAG_KEY, X_STAGING_TOKEN_KEY);

    /**
     * This bean creates an HTTP Header object by copying all required headers from the incoming HTTP request and makes it available via auto-wiring into your REST templates
     * <p>
     * These headers are required for traceability of a request
     *
     * @return a HttpHeaders object with Fast Easy required headers copied in from incoming HTTP request
     */
    @Bean
    @RequestScope
    public HttpHeaders httpHeaders() {
        HttpHeaders requestHeaders = new HttpHeaders();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpServletRequest curRequest = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        Enumeration<String> headerNames = curRequest.getHeaderNames();

        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String header = headerNames.nextElement();
                String value = curRequest.getHeader(header);
                requestHeaders.add(header, value);
                if (ALLOW_HEADER_LIST.contains(header.toLowerCase())) {
                    httpHeaders.add(header, value);
                }
            }
        }

        // Add default Lang 'th' when accept-language is empty
        if (!httpHeaders.containsKey(ACCEPT_LANGUAGE_KEY) || Strings.isEmpty(httpHeaders.getFirst(ACCEPT_LANGUAGE_KEY))) {
            httpHeaders.set(ACCEPT_LANGUAGE_KEY, "th");
        }

        // Set client IP
        httpHeaders.set(REMOTEADDR_KEY, curRequest.getRemoteAddr());

        return httpHeaders;
    }
}
