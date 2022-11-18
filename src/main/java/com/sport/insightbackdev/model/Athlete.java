package com.sport.insightbackdev.model;

import com.sport.insightbackdev.model.enums.Gender;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ATHLETE", schema = "ATHLETES")
@NoArgsConstructor
@AllArgsConstructor
public class Athlete {

    @Id
    @Column(name = "ID")
    @ApiModelProperty(readOnly = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "GENDER")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "HEIGHT")
    private float height;

    @Column(name = "WEIGHT")
    private float weight;

}

