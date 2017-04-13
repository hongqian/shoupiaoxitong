import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 放映电影日程
 * Created by 59480 on 2017/4/8.
 */
public class Schedule implements Serializable{

    private static final long serialVersionUID = 1L;
    private              Seat seat;
    private              Movie movie;

    public Schedule() {
        super();
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
        return "\t"
                + movie.getName() + "\t"
                + movie.getPoster() + "\t"
                + movie.getDirector() + "\t"
                + movie.getActor() + "\t"
                + movie.getType() + "\t"
                + movie.getPrice() + "\t"
                + movie.getTime() + "\t";
    }

}
