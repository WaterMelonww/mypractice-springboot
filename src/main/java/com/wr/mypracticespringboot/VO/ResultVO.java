package com.wr.mypracticespringboot.VO;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wangru
 * @create 2019-08-27 19:52
 */
@Data
public class ResultVO implements Serializable {
    private int code;
    private String message;
    private Integer userid;

    public ResultVO(int code, Integer userid) {
        this.code = code;
        this.userid = userid;
    }

    public ResultVO(int code) {
        this.code = code;
    }


    public ResultVO(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
