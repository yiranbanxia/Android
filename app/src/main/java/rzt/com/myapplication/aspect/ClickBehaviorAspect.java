package rzt.com.myapplication.aspect;

import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import rzt.com.myapplication.annocation.Clickbehavior;


@Aspect//定义切面类
public class ClickBehaviorAspect {
    private final static String TAG = "netease>>";

    //1.应用中用到了哪些注解，放到当前的切入点进行处理（找到需要处理的切入点）
    // execution,以方法执行时作为切点，处罚Aspect类
    //* *(..)) 可以处理Clickbehavior 这个类的所有的方法
    @Pointcut("execution(@rzt.com.myapplication.annocation.Clickbehavior * *(..))")
    public void methodPointCut() {
        Log.d(TAG, "methodPointCut");
    }

    //2、对切入点如何进行处理
    @Around("methodPointCut()")
    public Object jointPotion(ProceedingJoinPoint joinPoint) throws Throwable {
        Log.d(TAG, "jointPotion");
        //获取签名的方法
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        //获取方法所属的类名
        String className = methodSignature.getDeclaringType().getName();
        //获取方法名
        String methodNanme = methodSignature.getName();
        //获取方法的注解值（需要统计的行为）
        String funName = methodSignature.getMethod().getAnnotation(Clickbehavior.class).value();
        //统计方法的执行时间，统计用户点击某种功能行为。（存放本地，每过多少天上传服务器）
        long begin = System.currentTimeMillis();
        Log.d(TAG, "method start>>>" + begin);
        Object reslut = joinPoint.proceed();//MainActivity中切面的方法
        long duration = System.currentTimeMillis() - begin;
        Log.d(TAG, "ClickBehavior  Method end>>" + duration);
        Log.d(TAG, String.format("统计了:%S方法，在%s类的%s放啊，用时%d ms", funName, className, methodNanme, reslut));
        return reslut;
    }
}
