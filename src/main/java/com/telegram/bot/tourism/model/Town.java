package com.telegram.bot.tourism.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "towns")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Town {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @NotNull(message = "Id not can be null")
    private Long id;

    @NotEmpty(message = "Name not can be empty")
    @Length(max = 25, message = "Length name max be 25")
    private String name;

    @NotEmpty(message = "Information not can be empty")
    @Length(max = 300,  message = "Length information max be 300")
    private String informationAboutCity;

}
