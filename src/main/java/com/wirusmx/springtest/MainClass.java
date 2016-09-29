package com.wirusmx.springtest;

import com.wirusmx.springtest.springidol.PerformanceException;
import com.wirusmx.springtest.springidol.Performer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MainClass
{
    public static void main( String[] args ) throws PerformanceException {
        ApplicationContext context = new FileSystemXmlApplicationContext("spring-idol.xml");
        Performer performer = (Performer) context.getBean("poeticDuke");
        performer.perform();
    }
}
