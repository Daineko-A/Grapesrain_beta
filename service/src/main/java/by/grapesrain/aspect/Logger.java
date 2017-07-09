package by.grapesrain.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by PloSkiY on 09.07.2017.
 */
@Aspect
public class Logger {

    @Pointcut ("execution(public * by.grapesrain.services.*.* (..))")
    public void allServices() {};


    @Before("execution(public * by.grapesrain.services.*.* (..))")
    public void printParametrs() {
        System.out.println("--------------------ASPECT _ printParametrs-------------------");
        System.out.println("--------------------ASPECT ^^^^^ printParametrs-------------------");
    }

}
