package com.sea.weed.model;

import java.util.HashMap;
import java.util.Map;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ResponseModel {
    private int status;
    private String message;
    private Map<String,Object> data;

    public ResponseModel(int _status, String _message, Map _data){
        this.status = _status;
        this.message = _message;
        this.data = _data;
    }

    public ResponseModel(){
        this.status = 0;
        this.message = "";
        this.data = new HashMap<String,Object>();
    }

    public void put(String key, Object value){
        this.data.put(key,value);
    }
    public Object get(String key){
        return this.data.get(key);
    }
}
