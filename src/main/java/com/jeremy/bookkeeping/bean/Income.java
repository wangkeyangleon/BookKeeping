package com.jeremy.bookkeeping.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
    private Long in_id;
    private String in_type;
    private Date in_beginTime;
    private Date in_endTime;
    private long in_unitPrice;
}
