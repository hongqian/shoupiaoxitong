import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * 学生票类
 * Created by 59480 on 2017/4/8.
 */
public class StudentTicket implements GetTicket{
    private String seat;
    private Schedule schedule;


    public StudentTicket() {
    }

    public StudentTicket(String seat, Schedule schedule) {

        this.seat = seat;
        this.schedule = schedule;

    }

    public String getSeat() {

        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }


    /*
    重写GetTicket内的print方法打印学生票
     */
    @Override
    public void print() {
        /*
        将电影票写入到src文件夹下
         */
        try (
                FileWriter fs = new FileWriter("src/"+this.schedule.getMovie().getName()+this.getSeat()+"（学生票）.txt", true);
                PrintWriter sw = new PrintWriter(fs))
        {
            sw.println("***************************");
            sw.println("       xx影院（学生票）");
            sw.println("---------------------------");
            sw.println(" 电影名：" + this.schedule.getMovie().getName());
            sw.println(" 时间：  " + this.schedule.getMovie().getTime());
            sw.println(" 座位号：" + this.getSeat());
            sw.println(" 价格：  " + this.schedule.getMovie().getPrice());
            sw.println("***************************");
            /*
            通过控制台输出电影票信息
             */
            System.out.println("***************************");
            System.out.println("        xx影院（学生票）");
            System.out.println(" 电影名： " + this.schedule.getMovie().getName());
            System.out.println(" 时间:   " + this.schedule.getMovie().getTime());
            System.out.println(" 座位号: " + this.getSeat());
            System.out.println(" 价格:   " + this.schedule.getMovie().getPrice());
            System.out.println("***************************");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
