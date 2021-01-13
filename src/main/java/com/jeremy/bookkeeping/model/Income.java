package com.jeremy.bookkeeping.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigInteger;
import java.util.Date;

/**
 * @program: book-keeping
 * @description: income entity
 * @author: Keyang Wang
 * @create: 2021-01-13 14:44
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Income {
    private BigInteger in_id;
    private String in_type;
    private Date in_beginTime;
    private Date in_endTime;
    private long in_unitPrice;
}
