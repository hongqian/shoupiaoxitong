import java.io.*;


/**
 * 座信息位类
 * Created by 59480 on 2017/4/8.
 */
public class Seat implements Serializable{
    private String seatNum;//座位号
    public Seat() {
    }

    public Seat(String seatNum) {
        this.seatNum = seatNum;
    }

    public String getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(String seatNum) {
        this.seatNum = seatNum;

    }

   /* public static void outputSeat(Seat seat) throws IOException {
        ObjectOutputStream oo = null;

        File file = new File("src/1.obj");
        FileOutputStream fos = new FileOutputStream(file, true);

        if(file.length()<1){
            oo = new ObjectOutputStream(fos);
        }else{
            oo = new MyObjectOutputStream(fos);
        }
            oo.writeObject(seat);

            oo.close();
    }
    public static List inputSeat(){
        List<Seat> seatl = new ArrayList<>();
        try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream("src/1.obj"))) {
            int a=0;
while (true) {
    Seat seat = (Seat) oi.readObject();

    seatl.add(seat);
}
        }catch (EOFException e) {
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

            return seatl;
    }*/

    /*public static void main(String[] args) throws IOException {

       *//* Seat.outputSeat(new Seat("23"));
        Seat.outputSeat(new Seat("123"));*//*
        List<Seat> l=Seat.inputSeat();
        for (Seat s:
             l) {
            System.out.println(s.getSeatNum());
        }
    }*/

}
