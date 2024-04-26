package com.tantely.freshfruitmanager.advices;

import java.time.LocalDate;

public record ApplicationError(
        String message,
        LocalDate date,
        int status
) {}
