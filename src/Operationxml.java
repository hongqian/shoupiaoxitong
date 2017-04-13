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

    /*
    通过dom4j读取xml中的电影信息
     */
    public static List<Schedule>   load()  {
            List<Schedule>   l            =   new ArrayList<>();//电影日程类的集合
        try {
            Movie            movie        =   new Movie();
            SAXReader        reader       =   new SAXReader();
            Document         doc          =   reader.read(new File("src/NewFile.xml"));
            Element          e            =   doc.getRootElement();
            Element          e1           =   e.element("ShowList");
            List<Element>    l1           =   e1.elements();

        /*
        通过对比标签名来获取对应电影信息
         */
        for (Element e2 :    l1) {

            List<Element>    l2           =   e2.elements();

            for (Element e3 : l2) {
                if (       e3.getName().equals("Name")) {
                    movie.setName(e3.getText());

                } else if (e3.getName().equals("Poster")) {
                    movie.setPoster(e3.getText());

                } else if (e3.getName().equals("Director")) {
                    movie.setDirector(e3.getText());

                } else if (e3.getName().equals("Actor")) {
                    movie.setActor(e3.getText());

                } else if (e3.getName().equals("Type")) {
                    movie.setType(Enum.valueOf(
                            Type.class,
                            e3.getText()));

                } else if (e3.getName().equals("Price")) {
                    movie.setPrice(Double.parseDouble(e3.getText()));

                } else if (e3.getName().equals("Schedule")) {

                    List<Element> l3 = e3.elements();
                    for (Element e4 : l3) {
                        //将获取到的电影信息打包进movie1
                        Movie movie1 = new Movie(
                                movie.getName(),
                                movie.getPoster(),
                                movie.getDirector(),
                                movie.getActor(),
                                movie.getPrice(),
                                movie.getType());

                        movie1.setTime(e4.getText());
                        Schedule schedule = new Schedule();
                        //利用Schedule类获取封装进Movie类的电影信息
                        schedule.setMovie(movie1);
                        //将schedule对象打包到l集合
                        l.add(schedule);
                    }
                }
            }
        }

        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return l;
    }
}
