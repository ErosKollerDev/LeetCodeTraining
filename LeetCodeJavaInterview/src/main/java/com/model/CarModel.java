package com.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
public class CarModel {

    private String name;
    private String brand;
    private String type;
    private Integer model;
    private Integer year;


}
