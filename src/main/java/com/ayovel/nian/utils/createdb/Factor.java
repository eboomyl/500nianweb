package com.ayovel.nian.utils.createdb;

/**
 * Created by admin on 2014/9/28.
 */
public class Factor {
    private String name;
    private String type;
    private String index;
    private String desc;
    private String size;
    private String targetname;

    public Factor(){

    }
    public Factor(String name,String type,String index,String desc,String size,String targetname){
        this.desc = desc;
        this.name = name;
        this.type = type;
        this.index =index;
        this.size = size;
        this.targetname = targetname;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setTargetname(String targetname) {
        this.targetname = targetname;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public String getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public String getTargetname() {
        return targetname;
    }

    public String getType() {
        return type;
    }
}
