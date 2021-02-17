package com.telegram.bot.tourism.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Document(value = "cities")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Country {

    @Id
    @NotNull
    private UUID id;

    @NotEmpty
    @Length(max = 25)
    private String name;

    @NotEmpty
    @Length(max = 300)
    private String informationAboutCountry;

}
