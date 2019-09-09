package model.resp;

import org.springframework.stereotype.Component;

import java.io.Serializable;

public class BaseResp<T> implements Serializable {

    private int ok ;  //1代表成功   0 代表失败
    private String msg ;
    private T data ;
    private int count;
    private int keynum;
    private String username;

    @Override
    public String toString() {
        return "BaseResp{" +
                "ok=" + ok +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", count=" + count +
                ", keynum=" + keynum +
                ", username='" + username + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getKeynum() {
        return keynum;
    }

    public void setKeynum(int keynum) {
        this.keynum = keynum;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public BaseResp() {
    }

    public BaseResp(int ok, String msg, T data) {
        this.ok = ok;
        this.msg = msg;
        this.data = data;
    }

    public int getOk() {
        return ok;
    }

    public void setOk(int ok) {
        this.ok = ok;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
