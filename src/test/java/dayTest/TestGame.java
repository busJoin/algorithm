package dayTest;

import org.junit.Test;

import java.util.*;

public class TestGame {
    //abcdefg
    //hijklmn
    //opq rst
    //uvw xyz
    @Test
    public void get(){
        Double need = (0+1000)/1.0;//cn
        Double speed = 237/1.0;//cm
        Double time = 0.0;
        time = need*1000/speed/60;
        System.out.printf("还需要%s分钟",time);
    }

    @Test
    public void sort(){
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"1.15cp");
        map.put(2,"38.5cp");
        map.put(3,"2.98co");
        map.put(4,"1.18cp");
        map.put(5,"479.19cp");
        map.put(6,"17.29cp");
        map.put(7,"56.42cp");
        map.put(8,"140.51cp");
        map.put(9,"293,88cq");
        map.put(10,"334.74cp");
        List<Integer> readed = new ArrayList<>();
        List<String> list = new ArrayList<>();
        for (int i=1;i<11;i++){
            String min = "999zz";
            for (int j = 1;j<11;j++){
                if (readed.contains(j)){
                    continue;
                }
                if (isMin(min,map.get(j))){
                    min=map.get(j);
                }
            }
            list.add(min);
            readed.add(getIndex(min,map));
        }
        for (int i=1;i<11;i++){
            String ss = list.get(i-1);
            int index = getIndex(ss,map);
            System.out.printf("第%d个升级第%d个建筑，需要资金%s",i,index,ss);
            System.out.println();
        }
    }

    public static int getIndex(String min,Map<Integer,String> map){
        for (Map.Entry<Integer,String> v:map.entrySet()){
            if (v.getValue().equals(min)){
                return v.getKey();
            }
        }
        return 0;
    }


    public static boolean isMin(String min,String value){
        int isEqual = min.substring(min.length()-2).compareTo(value.substring(value.length()-2));
        if (isEqual<0){
            return false;
        }else if (isEqual>0){
            return true;
        }else {
            Double min1 = Double.valueOf(min.substring(0,min.length()-2));
            Double value1 = Double.valueOf(value.substring(0,value.length()-2));
            if (min1<=value1){
                return false;
            }else {
                return true;
            }
        }
    }
}
