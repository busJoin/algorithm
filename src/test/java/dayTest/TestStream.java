package dayTest;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestStream {
    @Test
    public void test01(){
        Per per = new Per();
        per.setId(1);
        per.setList(Lists.newArrayList(1,2));
        Per per1 = JSON.parseObject(JSON.toJSONString(per),Per.class);
        List<Per> list = Lists.newArrayList();
        list.add(per);
        list.add(per1);
        Map<Integer,Per> collect = list.stream().collect(Collectors.toMap(Per::getId, Function.identity(), (a, b)->{
            a.getList().addAll(b.getList());
            return a;
        }));
        System.out.println(JSON.toJSONString(collect));

    }

    /**
     * 200万是买房好还是租房好
     */
    @Test
    public void test02(){
        money();
    }

    public static double money(){
        //第几个月
        int n= 0;
        //初始钱
        double money = 200*10000;
        //每月房租
        double price = 5000;
        //资金年化收益
        double add = 0.04;
        //物价上涨指数
        double des = 0.025;
        DecimalFormat df = new DecimalFormat("0.00");
        while (n<12*55){
            int year = n/12+1;
            int month = n%12 +1;
            if (month==1){
                money = money - price*12;
            }
            if (month == 12){
                money = money*(1+add);
                price= price*(1+des);
            }
            System.out.print("第"+year+"年"+month+"月\t");
            System.out.println("余额"+(int)money/10000+"万"+df.format(money%10000)+"元"+"当月房租"+df.format(price));
            n++;
        }
        return money;
    }
}

@Data
class Per{
    List<Integer> list;
    Integer id;
    public Per from(){
        return this;
    }
}
