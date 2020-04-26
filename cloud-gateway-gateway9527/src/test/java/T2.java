import cn.hutool.core.date.DateUtil;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class T2 {
    public static void main(String[] args) {
//        ZonedDateTime ctt = ZonedDateTime.of(2020, 4, 25, 16, 30, 00, 000, ZoneId.systemDefault());
//        ZonedDateTime ctt = ZonedDateTime.of(2020, 4, 25, 16, 30, 00, 000, ZoneId.of("CTT",ZoneId.SHORT_IDS));
        String ctt = DateUtil.now();
        System.out.println(ctt);
    }
}
