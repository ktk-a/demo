package com.sj.demo.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PageInfo<T> implements Serializable {

    private long total;

    private List<T> list;
}
