import java.io.Serializable;


/**
 * 电影信息类
 * Created by 59480 on 2017/4/8.
 */
public class Movie implements Serializable{
    private static final long              serialVersionUID = 1L;
    private              String            name;//电影名字
    private              String            poster;//海报
    private              String            director;//导演
    private              String            actor;//演员
    private              double            price;//价格
    private              Type              type;//类型
    private              String            time;//时间
    public Movie() {
    }


    public Movie(
                         String            name,
                         String            poster,
                         String            director,
                         String            actor,
                         double            price,
                         Type              type)
    {
                         this.name       = name;
                         this.poster     = poster;
                         this.director   = director;
                         this.actor      = actor;
                         this.price      = price;
                         this.type       = type;

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
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
