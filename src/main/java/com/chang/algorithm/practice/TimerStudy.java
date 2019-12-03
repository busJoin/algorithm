package com.chang.algorithm.practice;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;
@Component //这个很重要
@Slf4j
public class TimerStudy {
    public static void main(String[] args) {
        //testTimer();
        //testQuartz();
    }

    public static void testTimer(){
        //只执行一次
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("2000毫米后执行一次。");
            }
        }, 2000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("5000毫米后执行一次。");
            }
        }, new Date(System.currentTimeMillis() + 5000));

        //循环执行
        Timer timer1 = new Timer();
        timer1.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(111);
            }
        }, 1000, 2000); // 1000毫米后执行第一次，之后每2000毫米执行一次

       // 终止任务
        timer.cancel();
    }

    public static void testQuartz(){
        // 该 map 可在 job 中获取
        JobDataMap map = new JobDataMap();
        map.put("hello", "world");
        JobDetail jobDetail = newJob(QuartzJob.class).
                withIdentity("myJob", "myGroup").
                setJobData(map).build();
        /*
         * 简单定时器
         *
         * 执行时间间隔
         * withIntervalInMilliSeconds 毫秒
         * withIntervalInSeconds 秒
         * withIntervalInMinutes 分钟
         * withIntervalInHours 小时
         *
         * 执行次数
         * repeatForever 重复执行
         * withRepeatCount 次数
         */

        /*
         * corn定时器
         *
         * corn表达式，使用更灵活
         * corn表达式在线生成 http://cron.qqe2.com/
         */
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("* * * * * ? *");

        Trigger trigger = newTrigger().startAt(new Date()).//startNow() 默认现在开始
                withIdentity("myTrigger", "myGroup").
                //withSchedule(scheduleBuilder).build();
                        withSchedule(cronScheduleBuilder).build();

        try {
            //1.创建Scheduler工厂
            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
            //2.获取实例
            Scheduler scheduler = schedulerFactory.getScheduler();
            //3.设置jobDetail详情和trigger触发器
            scheduler.scheduleJob(jobDetail, trigger);
            //4.定时任务开始
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @Scheduled(initialDelay=1000, fixedDelay = 1000)
    public void task1() {
//        System.out.println("延迟1000毫秒后执行，任务执行完1000毫秒之后执行！");
        log.info("task1延迟1000毫秒后执行，任务执行完1000毫秒之后执行！");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Scheduled(fixedRate = 2000)
    public void task2() {
//        System.out.println("延迟1000毫秒后执行，之后每2000毫秒执行一次！");
        log.error("延迟1000毫秒后执行，之后每2000毫秒执行一次！");
    }

    @Scheduled(cron = "*/2 * * * * ?")
    public void task3() {
//        System.out.println("每2秒执行一次！");
        log.warn("每2秒执行一次！");
    }
}
