package by.grapesrain.aspect;

import lombok.extern.log4j.Log4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by PloSkiY on 09.07.2017.
 */
@Aspect
//@Log4j
public class Logger {

    @Pointcut ("execution(public * by.grapesrain.services.*.* (..))")
    public void allServices() {};


    @Before("allServices()")
    public void printParametrs() {

//        log.info("--------------------ASPECT _ printParametrs-------------------");

        System.out.println("--------------------ASPECT _ printParametrs-------------------");
        System.out.println("--------------------ASPECT ^^^^^ printParametrs-------------------");
    }

}
