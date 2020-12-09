package edu.nf.ch19.demo2;

/**
 * @author 洒度
 * @date 2020/12/9
 * 自定义事件对象
 */
public class DemoEvent {

    private String message;

    public DemoEvent(){

    }

    public DemoEvent(String message){
        this.message=message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
