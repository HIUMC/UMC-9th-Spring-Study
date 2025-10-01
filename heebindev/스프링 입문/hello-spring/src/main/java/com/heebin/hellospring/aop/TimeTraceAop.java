package com.heebin.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component //이 애노테이션이 아니라 config 파일에 직접 생성자 등록해도된다.(@Bean)
@Aspect //aop
public class TimeTraceAop {

    @Around("execution(* com.heebin.hellospring..*(..))")//적용 범위
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {

        long start = System.currentTimeMillis(); //시간 변수
        System.out.println("START: " + joinPoint.toString());
        //try finally 구문
        try {
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis(); //시간 변수
            long timeMs = finish - start; //시간 변수
            System.out.println("END: " + joinPoint.toString()+ " " + timeMs +"ms");
        }
    }
}