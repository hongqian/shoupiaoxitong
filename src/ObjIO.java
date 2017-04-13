import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 59480 on 2017/4/13.
 */
public class ObjIO {
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
        try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream("src/1.obj")))
        {

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
}
