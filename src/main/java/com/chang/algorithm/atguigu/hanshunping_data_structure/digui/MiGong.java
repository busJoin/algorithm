package com.chang.algorithm.atguigu.hanshunping_data_structure.digui;

public class MiGong {
    public static void main(String[] args) {
        int[][] map = new int[8][7];
        initMap(map);
        System.out.println("初始化地图是");
        printMap(map);
//        setWay(map,1,1);
        printLoad(map,1,1);
//        System.out.println("跑完地图后");
//        printMap(map);
    }

    /**
     * 跑图并打印随机一条路线
     * @param map
     * @param i
     * @param j
     */
    public static void printLoad(int[][] map,int i,int j){
        setWay(map,i,j);
        System.out.println("跑完的地图");
        printMap(map);
        System.out.println("下面是解答");
        if (map[i][j]!=2){
            System.out.println("没有答案");
            return;
        }
        findNext(map,i,j);
    }

    public static void findNext(int[][] map,int i,int j){
        if (map[i][j]==2){
            System.out.println(i+","+j);
            map[i][j]=0;
            findNext(map,i+1,j);
            findNext(map,i-1,j);
            findNext(map,i,j+1);
            findNext(map,i,j-1);
        }
    }

    /**
     * 尝试跑迷宫
     * @param map
     * @param i
     * @param j
     * @return
     */
    public static boolean setWay(int[][] map,int i,int j){
        //通路找到了
        if (map[6][5]==2){
            return true;
        }else {
            if (map[i][j]==0){
                //按照下右上左的策略走
                map[i][j]=2;
                if (setWay(map,i+1,j)){
                    return true;
                }else if (setWay(map,i,j+1)){
                    return true;
                }else if (setWay(map,i-1,j)){
                    return true;
                }else if (setWay(map,i,j-1)){
                    return true;
                }else {
                    //说明是思路，走不通
                    map[i][j]=3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }

    /**
     * 初始化地图
     * @param map
     */
    public static void initMap(int[][] map){
        for (int i=0;i<map.length;i++){
            //最左边和最右边是墙
            map[i][0]=1;
            map[i][6]=1;
        }
        for (int i=0;i<map[0].length;i++){
            //最上边和最下边是墙
            map[0][i]=1;
            map[7][i]=1;
        }

        map[3][1] = 1;
        map[3][5] = 1;

    }

    /**
     * 打印地图
     * @param map
     */
    public static void printMap(int[][] map){
        for (int i=0;i<map.length;i++){
            for (int j=0;j<map[0].length;j++){
                System.out.print(map[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
