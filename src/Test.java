import org.dom4j.DocumentException;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 测试类
 * Created by 59480 on 2017/4/8.
 */
public class Test {
    private Seat seat=new Seat();
    private Scanner sc;
    private Operationxml operationxml=new Operationxml();
    private Schedule schedule=new Schedule();
    private String time;//输入时间
    private String name;//输入的电影名
    private String index;//票类型的索引
    private String zName;//赠送人名
    public static void main(String[] args) {
        Test t=new Test();
        t.flow();
}
        /*
        购票流程
         */
    private void flow(){
        while (true) {
            try {
                loadXX();
            } catch (DocumentException e) {
                e.printStackTrace();
            }
            movieName();
            movieTime();
            movieSeat();
            Type();
            saleOfTickets();
            //选择购票结束后选择是否继续
            System.out.println("输入0继续购票，其它键退出");
            sc = new Scanner(System.in);
            if (!sc.nextLine().equals("0")) {
                break;
            }
        }
    }
    /*
    出票方法
     */
    private void saleOfTickets(){
        //调用出票工厂
        GetTicket ticket=TicketFactory.getTicket(index,zName);
        ticket.setSchedule(schedule);//获取电影票信息
        ticket.setSeat(seat.getSeatNum());//获取座位
        ticket.print();//打印票
        Schedule schedule1=new Schedule(seat,new Movie(name,time));
        //将售出票信息写如文件保存
        try {
            Schedule.outputSchedule(schedule1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
    选择电影票类型方法
     */
    private void Type() {
        System.out.println("请输入您所要的电影票类型：1.全票 2.学生票 3.赠送票");
        boolean flag = true;//设置一个flag标记跳出循环
        sc = new Scanner(System.in);
        while (flag == true) {
            index =sc.nextLine();
            switch (index) {
                case "1"://全票
                    flag = false;
                    break;
                case "2"://学生票
                    System.out.println("请输入折扣：1到9折");
                    while (true) {
                        String a = sc.nextLine();
                        //利用正则匹配1-9的数字
                        Pattern p = Pattern.compile("[1-9]");
                        Matcher m = p.matcher(a);
                        //判断输入数字
                        if (!m.matches()) {
                            System.out.println("请输入1到9的整数");
                        } else {
                            //计算并设置学生票价格
                            schedule.getMovie().setPrice((Double.parseDouble(a) /10)*schedule.getMovie().getPrice());
                            break;
                        }
                    }
                    flag = false;
                    break;
                case "3"://赠送票
                    System.out.print("请输入赠票者的姓名:");
                    zName = sc.nextLine();//输入赠票者的姓名
                    flag = false;
                    break;
                default://输入数字非法
                    System.out.println("请输入1，2，3整数");
                    break;
            }
        }
    }
    /*
    选择电影院座位方法
     */
    private void movieSeat() {
        System.out.println("请输入您所要的座位号：");
        boolean flag = true;//设置一个flag标记跳出循环
        int b=0;//设置判断标志
        sc= new Scanner(System.in);
        while (flag == true) {
            List<Schedule> list=null;
            //判断是否有序列化文件,若有则执行反序列化得到Schedule集合
            if (new File("src/1.obj").exists()){
               list= Schedule.inputSchedule();
            }
            seat.setSeatNum(sc.next());
            String seatNum=seat.getSeatNum();
            for (int k = 1; k < 6; k++) {
                for (int j = 1; j < 8; j++) {
                    String s=k + "-" + j;
                    //循环打印座位号判断是否存在该座位号
                    if (seatNum.trim().equals(s.toString().trim())) {
                        if(list==null){
                            flag = false;
                            break;
                        }else {
                            //遍历集合
                        for (Schedule schedule1:list){

                            /*判断相同电影名字相同电影时间的座位号是否在已写
                            入序列化文件的Schedule对象中保存若有则表示该票
                            以售出b=1跳出循环*/
                            if(seatNum.trim().equals(schedule1.getSeat().getSeatNum().trim())&&time.trim().equals(schedule1.getMovie().getTime().trim())&&name.trim().equals(schedule1.getMovie().getName().trim())){
                                b=1;
                                break;
                        }else {
                                b=0;
                            }
                        }if (b==0){
                            flag = false;
                            break;
                        }else {
                            break;
                            }
                        }
                    }
                }
            }
            if (flag == false) {
                break;
            } else {
                if(b==1){
                    System.out.println("该票已售");
                }else  {
                    System.out.println("请输入正确的座位号");
                }
            }
        }

    }

    /*
    选择电影时间方法
     */
    private void movieTime() {
        System.out.println("请输入电影播放时间:");
        boolean flag = true;//设置一个flag标记跳出循环
        sc = new Scanner(System.in);
        while (flag == true) {
           String time = sc.next();
            //调用Operationxml类中的getL方法获取电影信息的集合
            List<Schedule> l = operationxml.getL();
            for (int i = 0; i < l.size(); i++) {
                schedule = l.get(i);
                //判断电影信息中该电影是否有该放映时间
                if (schedule.getMovie().getTime().equals(this.time=time)&&schedule.getMovie().getName().equals(name.trim())) {
                    flag = false;
                    break;
                }
            }
            if (flag == true) {
                System.out.println("电影时间有误，请重新输入时间名称：");
            }
        }
    }
    /*
    选择电影名字的方法
     */
    private void movieName() {
        System.out.print("请输入电影名称：");
        boolean flag = true;//设置一个flag标记跳出循环
        sc = new Scanner(System.in);
        while (flag == true) {
            String movieName = sc.next();
            //调用Operationxml类中的getL方法获取电影信息的集合
            List<Schedule> l = operationxml.getL();
            for (int i = 0; i < l.size(); i++) {
                schedule = l.get(i);
                //判断是否有相应的电影名
                if (schedule.getMovie().getName().equals(name=movieName.trim())) {
                    flag = false;
                    break;
                }
            }
            if (flag == true) {
                System.out.println("电影名称有误，请重新输入电影名称：");
            }
        }
    }
/*
加载电影信息方法
 */
    private void loadXX() throws DocumentException {
        operationxml.load();//调用Operationxml类中的load方法读取xml文件中的电影信息
        List<Schedule> l = operationxml.getL();//调用Operationxml类中的getL方法获取电影信息的集合
        System.out.println("序号\t电影名称\t英文名称\t导演\t 演员\t"+" "+"电影类型\t价格\t"+"     "+"时间\t");
       //遍历集合来输出电影信息
        for (int i = 0; i < l.size(); i++) {
            schedule =  l.get(i);
            System.out.println(i+1+ "." + schedule.toString());
        }
        System.out.println("下面为影院的座位结构图：");
        System.out.println("                  屏幕");
        //通过循环来模拟电影院座位情况
        for (int k = 1; k < 6; k++) {
            for (int j = 1; j < 8; j++) {
                if (j != 7) {
                    System.out.print(k + "-" + j + "   ");
                } else {
                    System.out.println(k + "-" + j);
                }
            }
        }
    }
}