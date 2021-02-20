package com.telegram.bot.tourism.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TownDto {

    @NotEmpty(message = "Name town not can be empty")
    @Length(max = 25, message = "Length name town max be 25")
    @JsonProperty("name")
    private String name;

    @NotEmpty(message = "Information about town not can be empty")
    @Length(max = 300,  message = "Length information about town max be 300")
    @JsonProperty("information")
    private String informationAboutTown;

}
