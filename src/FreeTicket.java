import java.io.PrintWriter;

/**
 * 赠送票类
 * Created by 59480 on 2017/4/8.
 */
public class FreeTicket extends Ticket implements GetTicket{

    private String zname;//赠送人名

    public FreeTicket(String type, String zname) {
        super(type);
        this.zname = zname;
    }

    @Override
    public void printfmo(PrintWriter sw) {
        sw.println(" 赠送人： " + zname);
        sw.println("***************************");
        System.out.println(" 赠送人： " + zname);
        System.out.println("***************************");
    }
}
