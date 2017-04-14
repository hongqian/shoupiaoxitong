import java.io.PrintWriter;


/**
 * 学生票类
 * Created by 59480 on 2017/4/8.
 */
public class StudentTicket extends Ticket implements GetTicket{
    private double price;

    public StudentTicket(String type, double price) {
        super(type);
        this.price = price;
    }

    @Override
    public void printfmo(PrintWriter sw) {
        sw.println(" 价格：  " + price);
        sw.println("***************************");
        System.out.println(" 价格:   " + price);
        System.out.println("***************************");
    }
}
