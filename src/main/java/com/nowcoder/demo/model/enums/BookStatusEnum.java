package com.nowcoder.demo.model.enums;

public enum BookStatusEnum {

    NORMAL(0),  //正常
    BORROW(1),  //删除
    RECOMMENDED(2), //推荐
    ;

    private int value;

    BookStatusEnum(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }

}