package com.Module2.Web.DTO;

import com.Module2.Web.Annotation.PasswordValid;
import com.Module2.Web.Annotation.PrimeNumber;
import lombok.*;
import lombok.experimental.FieldDefaults;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DepartmentDTO {
    Long id;
    @NotBlank(message = "Title is mandatory")
    String title;
    Boolean isActive = true;
    LocalDateTime createdAt;
    @PrimeNumber
    private Integer departmentCode;
    @PasswordValid
    private String password;
}
