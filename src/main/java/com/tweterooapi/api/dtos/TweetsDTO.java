package com.tweterooapi.api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TweetsDTO {

    @NotBlank
    @Size(max = 280)
    private String tweet;

    @NotNull
    private Long userId;
 
}
