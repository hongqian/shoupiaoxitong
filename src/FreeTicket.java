/**
 * 赠送票类
 * Created by 59480 on 2017/4/8.
 */
public class FreeTicket extends Ticket implements GetTicket{

    private String zname;//赠送人名

    public FreeTicket() {
    }

    public FreeTicket(String zname) {
            this.zname = zname;
    }

}
