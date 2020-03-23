package rzt.com.myapplication.aspect;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import rzt.com.myapplication.activity.LoginActvity;

//定义切面类
@Aspect
public class LoginCheckAspect {
    private static final String TAG = "AOP====>>>";

    // 1、应用中用到了哪些注解，放到当前的切入点进行处理（找到需要处理的切入点）
    // execution，以方法执行时作为切点，触发Aspect类
    // * *(..)) 可以处理ClickBehavior这个类所有的方法
    @Pointcut("execution(@rzt.com.myapplication.annocation.LoginCheck * *(..))")
    public void methodPointCut() {
        Log.e(TAG, "LoginCheckAspect");
    }

    // 2、对切入点如何处理
    @Around("methodPointCut()")
    public Object jointPotin(ProceedingJoinPoint joinPoint) throws Throwable
    {
        Context context = (Context) joinPoint.getThis();
        if (false)//模拟未登录
        { // 从SharedPreferences中读取
            Log.e(TAG, "检测到已登录！");
            return joinPoint.proceed();
        } else {
            Log.e(TAG, "检测到未登录！");
            Toast.makeText(context, "请先登录！", Toast.LENGTH_SHORT).show();
            context.startActivity(new Intent(context, LoginActvity.class));
            return null; // 不再执行方法（切入点）
        }
    }
}