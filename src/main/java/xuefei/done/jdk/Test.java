package xuefei.done.jdk;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description: 测试类
 * @author: xuefei
 * @date: 2022/03/03 01:12
 */
public class Test {
    public static void main(String[] args) {



        System.out.println(getHour());

    }

    public static Integer getHour() {
//        Calendar calendar = Calendar.getInstance();
        return Integer.valueOf(new SimpleDateFormat("H").format(new Date(1674921893000L)));
    }
}
