import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 操作xml类
 * Created by 59480 on 2017/4/8.
 */
public class Operationxml {
    private List<Schedule> l;//电影日程类的集合
    private Schedule schedule;
    private Movie movie;

    public Operationxml(List<Schedule> l, Schedule schedule, Movie movie) {
        this.l = l;
        this.schedule = schedule;
        this.movie = movie;
    }

    public Operationxml() {

    }

    public List<Schedule> getL() {
        return l;
    }

    public void setL(List<Schedule> l) {
        this.l = l;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    /*
    通过dom4j读取xml中的电影信息
     */
    public void load() throws DocumentException {
        SAXReader reader = new SAXReader();
        Document doc = reader.read(new File("src/NewFile.xml"));
        Element e = doc.getRootElement();
        Element e1 = e.element("ShowList");
        List<Element> l1 = e1.elements();
        l = new ArrayList<>();
        movie = new Movie();
        /*
        通过对比标签名来获取对应电影信息
         */
        for (Element e2 : l1) {
            List<Element> l2 = e2.elements();
            for (Element e3 : l2) {
            if (e3.getName().equals("Name")) {
                movie.setName(e3.getText());
            } else if (e3.getName().equals("Poster")) {
                movie.setPoster(e3.getText());
            } else if (e3.getName().equals("Director")) {
                movie.setDirector(e3.getText());
            } else if (e3.getName().equals("Actor")) {
                movie.setActor(e3.getText());
            } else if (e3.getName().equals("Type")) {
                movie.setType(Enum.valueOf(Type.class, e3.getText()));
            } else if (e3.getName().equals("Price")) {
                movie.setPrice(Double.parseDouble(e3.getText()));
            } else if (e3.getName().equals("Schedule")) {
                List<Element> l3 = e3.elements();
                for (Element e4 : l3) {
                   //将获取到的电影信息打包进movie1
                    Movie movie1=new Movie(movie.getName()
                            ,movie.getPoster()
                            ,movie.getDirector()
                            ,movie.getActor()
                            ,movie.getPrice()
                            ,movie.getType());
                    movie1.setTime(e4.getText());
                    schedule=new Schedule();
                    //利用Schedule类获取封装进Movie类的电影信息
                    schedule.setMovie(movie1);
                    //将schedule对象打包到l集合
                    l.add(schedule);
                }
            }
        }
        }
    }
    /*public static void main(String[] args) throws DocumentException {
        new Operationxml().load();
    }*/
}
