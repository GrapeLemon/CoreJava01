import java.io.*;

public class Demo1 {
    public static void main(String[] args) throws IOException {
        File f = new File("src/abc.txt");
        InputStream out = new FileInputStream(f);
        for (int i = out.read(); i != -1; i = out.read()) {
            System.out.println(i);
        }
        out.close();
    }
}
