import java.io.*;


/**
 * 不写如文件头的ObjectOutputStream类
 * Created by 59480 on 2017/4/8.
 */
class MyObjectOutputStream extends ObjectOutputStream {

    public MyObjectOutputStream() throws IOException {
        super();
    }

    public MyObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        return;
    }
}