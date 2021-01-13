package com.jeremy.bookkeeping.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigInteger;
import java.util.Date;

/**
 * @program: book-keeping
 * @description: expenditure entity
 * @author: Keyang Wang
 * @create: 2021-01-13 14:44
 **/
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Expenditure {
    private BigInteger ex_id;
    private String ex_type;
    private long ex_money;
    private Date ex_time;
}
