package com.project.microservice.members.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.Date;
@Data
@Document(collation = "members")
public class Member {

    @Id
    private Long id;

    private String memberShipNumber;

    private String name;

    private String nif;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date brithdayDate;

    private String mobile;

    private String address;

    private String email;

    private String province;
}
