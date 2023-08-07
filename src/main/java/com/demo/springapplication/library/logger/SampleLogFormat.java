package com.demo.springapplication.library.logger;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor()
public @Data class SampleLogFormat {
    private String correlationId = UUID.randomUUID().toString();
    @NonNull private String message;
    @NonNull private Object payload;
}
