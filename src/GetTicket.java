/**
 * 获取票的接口
 * Created by 59480 on 2017/4/9.
 */
public interface GetTicket {


    /*
    获得放映电影日程类
     */
    void setSchedule(Schedule schedule);


    /*
    获得座位号
     */
    void setSeat(String seatNum);


    /*
    获得对应的票面
     */
    void print(String type,String zname,double price);
}
