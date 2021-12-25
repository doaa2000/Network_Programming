import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
public class TcpEchoServer
{
    public static ServerSocket serverSocket;
    public static final int port =6699;

    public static void main(String[] args) {

        System.out.println("opening port.....");
        try
        {
            serverSocket=new ServerSocket(port);
            System.out.println("port opened successfuly");
        }
        catch(Exception ex)
        {
            System.out.println("failed to connect to port");

        }
        do
        {
            handelConnection();
        }while(true);
    }
    public static void  handelConnection()
    {
        Socket link=null;
        try {
            link = serverSocket.accept();
            Scanner input = new Scanner(link.getInputStream());
            PrintWriter out = new PrintWriter(link.getOutputStream(), true);
            String userName = input.nextLine();
            String password = input.nextLine();


            while (!userName.equals("End") && !password.equals("End")) {

                if (check(userName,password)) {
                    System.out.println("You are logged in successfully");
                    out.println(" Hello\n " + userName );
                } else {
                    out.println("Invalid Try Again!");
                }
                userName = input.nextLine();
                password = input.nextLine();
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally {
            try {
                System.out.println("Closing Connection");
                link.close();
            }catch (IOException e){
                System.out.println("Unable to Connect");
                System.exit(1);
            }
        }
    }
    public static boolean  check(String user,String pass) {

        String[] ch = {"doaa","1234"};
        String u=user,p=pass;
        if ((u.equals(ch[0]) && (p.equals(ch[1]))))
            return true;
        else
            return false;
    }
}



