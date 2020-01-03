package dayTest;

import org.junit.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.stream.Stream;

public class TestMoney {
    @Test
    public void test(){
        LocalDate ld = LocalDate.of(2019,10,18);
        LocalDate ld1 = LocalDate.of(2019,8,19);
        LocalDate ld2 = LocalDate.of(2019,9,17);
        LocalDate ld3 = LocalDate.of(2019,10,17);
        LocalDate ld4 = LocalDate.of(2019,11,19);
        LocalDate[] lds = {ld};
//        LocalDate[] lds = {ld,ld1,ld2,ld3,ld4};
        final LocalDate now = LocalDate.now();
        Stream<Long> daysStream = Arrays.stream(lds).map(x -> x.until(now, ChronoUnit.DAYS));
        Long count = daysStream.reduce(0L, Long::sum);
        System.out.println("总年份"+count*1.0/365);
        double year = count*1.0/365;
        //总利息
        double money = 140.87;
        //每期本金
        double every = 10000;
        double interest = money/every/year;
        System.out.println("利率为"+interest);
    }
}
