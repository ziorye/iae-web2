package day0901;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;

@WebListener
public class MyHttpSessionAttributeListener implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        // 哪个 attribute 被添加了
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        // 哪个 attribute 被删除了
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        // 哪个 attribute 由什么变成了什么
    }
}
