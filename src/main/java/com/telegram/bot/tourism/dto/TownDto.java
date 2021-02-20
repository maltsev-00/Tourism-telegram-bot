package com.telegram.bot.tourism.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TownDto {

    @NotEmpty(message = "Name not can be empty")
    @Length(max = 25, message = "Length name max be 25")
    private String name;

    @NotEmpty(message = "Information about town not can be empty")
    @Length(max = 300,  message = "Length information about town max be 300")
    private String informationAboutTown;

}
