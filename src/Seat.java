import java.io.*;


/**
 * 座信息位类
 * Created by 59480 on 2017/4/8.
 */
public class Seat implements Serializable{

    private  String seatNum;//座位号

    public   Seat() {
    }

    public   Seat(String seatNum) {
        this.seatNum = seatNum;
    }

    public   String   getSeatNum() {
        return seatNum;
    }

    public   void     setSeatNum(String seatNum) {
        this.seatNum = seatNum;
    }
}
