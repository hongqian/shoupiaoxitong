import java.io.Serializable;


/**
 * 电影信息类
 * Created by 59480 on 2017/4/8.
 */
public class Movie implements Serializable{
    private String        Name;//电影名字
    private String        Poster;//海报
    private String        Director;//导演
    private String        Actor;//演员
    private double        price;//价格
    private Type          type;//类型
    private String        time;//时间
    public Movie() {
    }

    public Movie(
            String        name,
            String        time)
    {
            Name        = name;
            this.time   = time;
    }

    public Movie(
            String        name,
            String        poster,
            String        director,
            String        actor,
            double        price,
            Type          type)
    {
            Name        = name;
            Poster      = poster;
            Director    = director;
            Actor       = actor;
            this.price  = price;
            this.type   = type;

    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPoster() {
        return Poster;
    }

    public void setPoster(String poster) {
        Poster = poster;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public String getActor() {
        return Actor;
    }

    public void setActor(String actor) {
        Actor = actor;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
