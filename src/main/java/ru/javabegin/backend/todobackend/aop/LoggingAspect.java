package ru.javabegin.backend.todobackend.aop;

import lombok.extern.java.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
@Log
public class LoggingAspect {

    @Around("execution(* ru.javabegin.backend.todobackend.controller..*(..)))")
    public Object profileControllerMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();

        log.info(" ----- Executing " + className + "." + methodName + " ----- ");

        StopWatch countDown = new StopWatch();

        countDown.start();

        Object result = proceedingJoinPoint.proceed();

        countDown.stop();

        log.info("---- Execution time of " + className + "." + methodName + " :: " + countDown.getTotalTimeMillis() + " ms");

        return result;
    }
}
