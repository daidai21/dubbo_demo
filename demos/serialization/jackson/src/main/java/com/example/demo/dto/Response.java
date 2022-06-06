package com.example.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response<T extends Serializable> implements Serializable {

    private Boolean succeed;

    private Integer errorCode;

    private T data;

    private String errorMessage;

}
