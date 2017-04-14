import java.io.*;

/**
 * 电影票类
 * Created by 59480 on 2017/4/8.
 */
public abstract class Ticket implements GetTicket {
    private String      seat;//座位号
    private Schedule    schedule;
    private String      type;
    public Ticket() {
    }

    public Ticket(String type) {
        this.type = type;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    /*
        重写GetTicket内的print方法打印全票
         */
    @Override
    public void print() {
        /*
        将电影票写入到src文件夹下
         */
        try (FileWriter fs = new FileWriter(
                "src/"
                        + this.schedule.getMovie().getName()
                        + this.getSeat()
                        + type
                        + ".txt",
                true);
             PrintWriter sw = new PrintWriter(fs)
        ) {
        printfhead(sw);
        printfmo(sw);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printfhead(PrintWriter sw) {
         /*
        将电影票写入到src文件夹下
         */
        sw.println("***************************");
        sw.println("        xx影院" + type);
        sw.println("---------------------------");
        sw.println(" 电影名：" + this.schedule.getMovie().getName());
        sw.println(" 时间：  " + this.schedule.getMovie().getTime());
        sw.println(" 座位号：" + this.getSeat());
            /*
            通过控制台输出电影票信息
             */
        System.out.println("***************************");
        System.out.println("        xx影院" + type);
        System.out.println(" 电影名： " + this.schedule.getMovie().getName());
        System.out.println(" 时间:   " + this.schedule.getMovie().getTime());
        System.out.println(" 座位号: " + this.getSeat());

    }

    public void printfmo(PrintWriter sw) {

            sw.println(" 价格：  " + this.schedule.getMovie().getPrice());
            sw.println("***************************");
            System.out.println(" 价格:   " + schedule.getMovie().getPrice());
            System.out.println("***************************");

    }


}