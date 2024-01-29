package com.tweterooapi.api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TweetsDTO {

    @NotBlank
    @Size(max = 280)
    private String tweet;

    @NotBlank
    private String username;
    
    @NotBlank
    private String avatar;
}
