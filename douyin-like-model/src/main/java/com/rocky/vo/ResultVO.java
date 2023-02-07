package com.rocky.vo;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.jws.Oneway;
import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultVO {

    @JsonProperty("status_code")
    private Integer statusCode;

    @JsonProperty("status_msg")
    private String statusMsg;
    // 响应消息

    // 响应数据，可以是Object，也可以是List或Map等
    @JsonIgnore
    private Object data;

    @JsonIgnore
    private String objectName;

    @JsonAnyGetter
    public Map<String, Object> getDataMap(){
        Map<String, Object> map = new HashMap<>();
        if(objectName==null){
            objectName="data";
        }
        if(data==null){
            data="";
        }
        map.put(objectName,data);
        return map;
    }
}
