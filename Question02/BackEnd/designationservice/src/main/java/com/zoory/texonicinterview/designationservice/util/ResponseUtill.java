package com.zoory.texonicinterview.designationservice.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ResponseUtill {
    private Integer code;
    private String message;
    private Object data;
}
