package com.zjxdqh.evcs.supervise.vo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

/**
 * 充电站 ID列表
 *
 * @author chenshunhua
 * @date 2019/05/08
 */

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE)
public class StationIdParam {

    /**
     * 充电站 ID列表
     * 数组长度不超过 50
     *
     */
    List<String> StationIDs;

}
