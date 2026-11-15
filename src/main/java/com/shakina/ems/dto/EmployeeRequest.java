package com.shakina.ems.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public record EmployeeRequest(
        @NotBlank @Size(max = 60) String firstName,
        @NotBlank @Size(max = 60) String lastName,
        @NotBlank @Email @Size(max = 120) String email,
        @NotBlank @Size(max = 80) String department,
        @NotBlank @Size(max = 80) String jobTitle,
        @NotNull @DecimalMin(value = "0.0", inclusive = false) BigDecimal salary
) {}
