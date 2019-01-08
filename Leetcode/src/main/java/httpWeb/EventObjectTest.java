package httpWeb;

import java.util.EventListener;
import java.util.EventObject;

/**
 * 理解EventObject的source域到底是什么
 * 还有事件的监听机制。
 * 回顾一下awt设计时button和actionListener的监听机制。
 */
public class EventObjectTest  {
    public static void main(String[] args) {
    }
}

/**
 * use the example to understand the event
 */
class PersonSpeakEvent extends EventObject{
    String content;
    //从这个构造函数的source才是我们监听的对象，EventObject只是这个Listener的桥梁。
    public PersonSpeakEvent(Object source) {
        super(source);
    }

    @Override
    public Object getSource() {
        return super.getSource();
    }

    @Override
    public String toString() {
        return super.toString();
    }
    public void speak(String content){
        this.content = content;
        System.out.println(content);
    }
}

/**
 * EventListener也是一个标记类，没有定义任何方法。
 */
class  PersonSpeakEventListener implements EventListener{

}
class Door{
    boolean state;

    public boolean isState() {
        if(state == true){
            System.out.println("the door opened");
        }
        else {
            System.out.println("the door close");
        }
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
