package com.telegram.bot.tourism.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.common.aliasing.qual.Unique;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;


@Entity
@Table(name = "towns")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Town {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @NotNull(message = "Id not can be null")
    private UUID id;

    @Length(min = 5,max = 25, message = "Length name town max be 25, min be 5 ")
    @Column(name = "name",unique = true)
    @JsonProperty("name")
    private String name;

    @Length(min = 5,max = 300,  message = "Length information about town max be 300, min be 5")
    @Column(name = "information_about_town")
    @JsonProperty("information_about_town")
    private String informationAboutTown;

}