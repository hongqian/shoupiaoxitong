import java.io.IOException;

/**
 * 电影票工厂类
 * Created by 59480 on 2017/4/9.
 */
public class TicketFactory {
    private static Ticket ticket;
    public static void getTicket(
                String      i,
                String      zName,
                Schedule    schedule){
        switch (i){
            case "1"://全票
                ticket = new PTTicket();
                ticket.setSchedule(schedule);//获取电影票信息
                ticket.setSeat(schedule.getSeat().getSeatNum());//获取座位
                ticket.print("","");//打印票
                break;
            case "2"://学生票
                ticket = new StudentTicket();
                ticket.setSchedule(schedule);//获取电影票信息
                ticket.setSeat(schedule.getSeat().getSeatNum());//获取座位
                ticket.print("(学生票)","");//打印票
                break;
            case "3"://增票
                ticket =new FreeTicket(zName);
                ticket.setSchedule(schedule);//获取电影票信息
                ticket.setSeat(schedule.getSeat().getSeatNum());//获取座位
                ticket.print("(赠票)",zName);//打印票
                break;
        }
        //将售出票信息写如文件保存
        try {
            ObjIO.outputSchedule(schedule);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
