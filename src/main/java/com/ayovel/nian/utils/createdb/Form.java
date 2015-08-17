package com.ayovel.nian.utils.createdb;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2014/9/28.
 */
public class Form {
    private List<Factor> factors = new ArrayList<Factor>();
    private String name;
    private String id;
    private String desc;

    public Form(){

    }
    public Form(List<Factor> factors,String name, String id, String desc){
        this.factors=factors;
        this.name=name;
        this.id=id;
        this.desc=desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setFactors(List<Factor> factors) {
        this.factors = factors;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Factor> getFactors() {
        return factors;
    }

    public String getDesc() {
        return desc;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

