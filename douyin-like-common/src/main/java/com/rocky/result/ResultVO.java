package com.rocky.result;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.xml.transform.Result;
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

    @JsonIgnore
    private Long userId;
    // long默认就不会是null

    @JsonIgnore
    private String token;

    @JsonIgnore
    private Long nextTime;


    @JsonAnyGetter
    public Map<String, Object> getDataMap(){


        if(objectName==null&&userId==null&&token==null&&nextTime==null){
            return null;
        }
        Map<String, Object> map = new HashMap<>();
        if(objectName!=null){
            if(data==null){
                data= "null";
            }
            map.put(objectName,data);
        }
        if(userId!=null){
            map.put("user_id",userId.longValue());
        }
        if(token!=null){
            map.put("token",token);
        }
        if(nextTime!=null){
            map.put("next_time",nextTime.longValue());
        }


        return map;

    }

    public ResultVO(ResponseStatusEnum responseStatus){
        this.statusCode = responseStatus.status();
        this.statusMsg = responseStatus.msg();
    }



    public ResultVO(ResponseStatusEnum responseStatus, String objectName,Object data){
        this.statusCode = responseStatus.status();
        this.statusMsg = responseStatus.msg();
        this.objectName = objectName;
        this.data = data;
    }

    public static ResultVO error(ResponseStatusEnum responseStatusEnum){
        return new ResultVO(responseStatusEnum);
    }

    public static ResultVO ok(ResponseStatusEnum responseStatusEnum,String objectName, Object data){
        return new ResultVO(responseStatusEnum,objectName,data);
    }

    public static ResultVO ok(ResponseStatusEnum responseStatusEnum){
        return new ResultVO(responseStatusEnum);
    }





}
