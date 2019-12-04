package dayTest;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.assertj.core.util.Lists;
import org.junit.Test;

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

}

@Data
class Per{
    List<Integer> list;
    Integer id;
    public Per from(){
        return this;
    }
}
