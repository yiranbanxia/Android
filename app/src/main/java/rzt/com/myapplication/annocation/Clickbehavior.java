package rzt.com.myapplication.annocation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//用户点击痕迹（行为统计）IOC容器
@Target(ElementType.METHOD)//作用在方法上
@Retention(RetentionPolicy.RUNTIME)//目标作用在方法之上
public @interface Clickbehavior {
    String value();
}
