package com.example.gymInfo.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomResponse {
    private Object body;
    private String statusCode;
    private String statusMsg;
}
