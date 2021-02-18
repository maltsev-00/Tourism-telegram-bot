package com.telegram.bot.tourism.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TownDto {

    @NotEmpty
    @Length(max = 25)
    private String name;

    @NotEmpty
    @Length(max = 300)
    private String informationAboutCountry;
    
}
