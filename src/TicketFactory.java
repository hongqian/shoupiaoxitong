
/**
 * 电影票工厂类
 * Created by 59480 on 2017/4/9.
 */
public class TicketFactory {
    private static GetTicket ticket;
    public static GetTicket getTicket(String i, String zName){
        switch (i){
            case "1"://全票
                ticket = new Ticket();
                break;
            case "2"://学生票
                ticket = new StudentTicket();
                break;
            case "3"://增票
                FreeTicket freeTicket=new FreeTicket();
                freeTicket.setZname(zName);//设置赠送人名字
                ticket= freeTicket;
                break;
        }
        return ticket;
    }

}
