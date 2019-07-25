package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SocketServer {
    public static void main(String[] args) throws IOException {
        int port = 7111;
        int clientNo = 1;

        /**
            这个port应该是客户端的端口，也就是客户端先发波http请求，然后我从请求中把一些值（例如端口）拿出来建立socket
            这样就可以在服务器和客户端之间一直传输数据了!
         */
        ServerSocket serverSocket = new ServerSocket(port);

        //创建线程池
        ExecutorService executorService = Executors.newCachedThreadPool();

        try{
            while(true){
                Socket socket = serverSocket.accept();
                executorService.execute(new SingleServer(socket,clientNo));
                clientNo++;
            }
        }finally {
            serverSocket.close();
        }

    }
}

class SingleServer implements Runnable{
    private Socket socket;
    private int clientNo;

    public SingleServer(Socket socket, int clientNo) {
        this.socket = socket;
        this.clientNo = clientNo;
    }

    @Override
    public void run() {
        try {
            DataInputStream dataInputStream = new DataInputStream(
                    new BufferedInputStream(socket.getInputStream()));
            DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            do{
                double length = dataInputStream.readDouble();
                System.out.println("从客户端" + clientNo + "接收到的边长数据为：" + length);
                double result = length * length;
                dataOutputStream.writeDouble(result);
                dataOutputStream.flush();   //毕竟是缓冲流嘛，搞完了就 flush一下，相当于把流里面的东西全部搞出去给别人
            }while(dataInputStream.readInt() != 0);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("与客户端" + clientNo + "通信结束");
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
