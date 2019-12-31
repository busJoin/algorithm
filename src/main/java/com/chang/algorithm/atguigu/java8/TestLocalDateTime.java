package com.chang.algorithm.atguigu.java8;

import org.junit.Test;
import sun.rmi.server.LoaderHandler;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

public class TestLocalDateTime {
    @Test
    public void test1(){
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        LocalDateTime ld2 = LocalDateTime.of(2019,12,12,12,12,12);
        System.out.println(ld2);
        //20年后
        LocalDateTime ld3 = ld2.plusYears(20);
        System.out.println(ld3);
        //2个月前
        LocalDateTime ld4 = ld2.minusMonths(2);
        System.out.println(ld4);

        System.out.println(ldt.getYear());
        System.out.println(ldt.getMonthValue());
        System.out.println(ldt.getDayOfMonth());
        System.out.println(ldt.getHour());
        System.out.println(ldt.getMinute());
        System.out.println(ldt.getSecond());
    }

    //2. Instant : 时间戳。 （使用 Unix 元年  1970年1月1日 00:00:00 所经历的毫秒值）
    @Test
    public void test2(){
        Instant ins = Instant.now();//默认使用UTC时区
        System.out.println(ins);
        OffsetDateTime odt = ins.atOffset(ZoneOffset.ofHours(8));
        System.out.println(odt);

        System.out.println(ins.getNano());

        Instant ins2 = Instant.ofEpochSecond(5);
        System.out.println(ins2);
    }

    //3.
    //Duration : 用于计算两个“时间”间隔
    //Period : 用于计算两个“日期”间隔
    @Test
    public void test3(){
        Instant ins1 = Instant.now();
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){

        }
        Instant ins2 = Instant.now();
        //1.001S
        System.out.println("耗时"+ Duration.between(ins1,ins2));
        //-1.001S
        System.out.println("耗时"+ Duration.between(ins2,ins1));
        System.out.println("-----------");
        LocalDate ld1 = LocalDate.now();
        LocalDate ld2 = LocalDate.of(2019,1,1);
        System.out.println("------------");
        //P-11M-30D
        Period pe = Period.between(ld1,ld2);
        //P11M30D
        Period pe1 = Period.between(ld2,ld1);
        System.out.println("Period:"+pe);
        System.out.println("Period:"+pe1);
        //0
        System.out.println(pe.getYears());
        System.out.println(pe.getMonths());
        System.out.println(pe.getDays());

    }

    //4. TemporalAdjuster : 时间校正器
    @Test
    public void test4(){
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);
        //当月十号
        LocalDateTime ldt2 = ldt.withDayOfMonth(10);
        System.out.println(ldt2);
        //下个周六
        LocalDateTime ldt3 = ldt.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(ldt3);
        //自定义：下一个工作日
        LocalDateTime ldt5 = ldt.with((l)->{
            LocalDateTime ldt4 = (LocalDateTime) l;
            DayOfWeek dow = ldt4.getDayOfWeek();
            if(dow.equals(DayOfWeek.FRIDAY)){
                return ldt4.plusDays(3);
            }else if(dow.equals(DayOfWeek.SATURDAY)){
                return ldt4.plusDays(2);
            }else{
                return ldt4.plusDays(1);
            }
        });
        System.out.println(ldt5);
    }

    //5. DateTimeFormatter : 解析和格式化日期或时间
    @Test
    public void test5(){
        DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE;
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss E");
        LocalDateTime ldt = LocalDateTime.now();
        String strDate = ldt.format(dtf1);
        System.out.println(strDate);
        System.out.println(ldt.format(dtf));

        LocalDateTime newLdt = ldt.parse(strDate,dtf1);
        System.out.println(newLdt);
    }

    @Test
    public void test6(){
        Set<String> set = ZoneId.getAvailableZoneIds();
        set.forEach(System.out::println);
    }

    //6.ZonedDate、ZonedTime、ZonedDateTime ： 带时区的时间或日期
    @Test
    public void test7(){
        LocalDateTime ldt = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println(ldt);

        ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of("US/Pacific"));
        System.out.println(zdt);
    }
}
