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

    @Length(min = 5,max = 25, message = "Length name town max be 25, min be 5 ")
    @JsonProperty("name")
    private String name;

    @Length(min = 5,max = 300,  message = "Length information about town max be 300, min be 5")
    @JsonProperty("information_about_town")
    private String informationAboutTown;

}
