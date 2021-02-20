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

    @NotEmpty(message = "Name town not can be empty")
    @Length(max = 25, message = "Length name town max be 25")
    @Column(name = "name",unique = true)
    @JsonProperty("name")
    private String name;

    @NotEmpty(message = "Information about town not can be empty")
    @Length(max = 300,  message = "Length information about town max be 300")
    @Column(name = "information")
    @JsonProperty("information")
    private String informationAboutTown;

}