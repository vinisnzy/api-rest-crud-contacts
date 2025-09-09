package com.vinisnzy.api_rest_crud.exceptions;

import java.time.Instant;

public record ErrorResponseDTO(Instant timestamp, Integer status, String error, String message, String path) {
}
