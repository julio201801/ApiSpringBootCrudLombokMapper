package com.ngsystem.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeDTO {
    private Integer idEmploye;
    @NotNull
    @NotEmpty
    @Size(min=3,max=50)
    private String name;
    @NotNull
    @NotEmpty
    @Size(min=3,max=50)
    private String phone;
    @NotNull
    @NotEmpty
    @Size(min=3,max=50)
    private String email;
    @NotNull
    private LocalDateTime joindate;
}
