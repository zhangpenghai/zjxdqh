package com.zjxdqh.face.param.page;

import lombok.Data;

import java.io.Serializable;

/**
 * 分页公共参数
 *
 * @author chenshunhua
 * @date 2019/09/10
 */
@Data
public class PageParam implements Serializable {


    /**
     * 当前页
     */
    private Integer pageNo = 1;
    /**
     * 每页显示条数
     */
    private Integer pageSize = 10;

}
