package edu.nf.ch19.demo1;

/**
 * @author 洒度
 * @date 2020/12/9
 * 自定义事件源
 */
public class MySource {
    private String message;

    public MySource(){

    }

    public MySource(String message){
        this.message=message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
