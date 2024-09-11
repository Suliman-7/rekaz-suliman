package com.example.rekazfinalproject.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Entity
@Setter
@Getter
public class Complaint{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String type;
    private Integer project_num;
    private String  description;
    private String file;

    private String priority_level;

    @ManyToOne
    @JsonIgnore
    private Investor investor ;

}
