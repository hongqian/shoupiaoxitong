import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 放映电影日程
 * Created by 59480 on 2017/4/8.
 */
public class Schedule implements Serializable{
    private static final long serialVersionUID = 1L;
    private Seat seat;
    private Movie movie;

    public Schedule() {
        super();
    }

    public Schedule(Seat seat, Movie movie) {
        this.seat = seat;
        this.movie = movie;
    }

    public Schedule(Movie movie) {
        super();
        this.movie = movie;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
    /*
        输出电影票信息
    */
    public String toString() {
        String ticxx = "\t" + movie.getName() + "\t"
                + movie.getPoster() + "\t" + movie.getDirector() + "\t"
                + movie.getActor() + "\t" + movie.getType() + "\t"
                + movie.getPrice() + "\t" + movie.getTime() + "\t";

        return ticxx;
    }
    /*
    将信息序列化
     */
    public static void outputSchedule(Schedule schedule) throws IOException {
        ObjectOutputStream o = null;

        File file = new File("src/1.obj");
        FileOutputStream fos = new FileOutputStream(file, true);
        /*
        判断是不是第一次写文件，若是则写入头部，否则不写入
         */
        if(file.length()<1){
            o = new ObjectOutputStream(fos);
        }else{
            o = new MyObjectOutputStream(fos);
        }
        o.writeObject(schedule);

        o.close();
    }
    /*
    将信息反序列化
     */
    public static List inputSchedule(){
        List<Schedule> seatl = new ArrayList<>();
        try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream("src/1.obj"))) {
            /*
            通过EOFException判断是否读到文件末
             */
            while (true) {
                Schedule schedule = (Schedule) oi.readObject();
                seatl.add(schedule);
            }
        }catch (EOFException e) {
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return seatl;
    }

    public static void main(String[] args) throws IOException {
        /*Seat seat=new Seat();
                seat.setSeatNum("1asd");
        Schedule schedule= new Schedule(seat,new Movie("1asd","3as"));

        Schedule.outputSchedule(schedule);*/

        List<Schedule> seatl= Schedule.inputSchedule();
        for (Schedule sch: seatl) {
            System.out.println(sch.getMovie().getTime());
        }
    }
}
