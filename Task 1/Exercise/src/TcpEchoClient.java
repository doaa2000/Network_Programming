import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
public class TcpEchoClient{
    public static InetAddress host;
    public static final int port=6699;
    public static void main(String[] args) {

        try
        {
            host=InetAddress.getLocalHost();

        }catch(Exception ex)
        {
            System.out.println("host not found");
            System.exit(1);
        }
        accessServer();
    }
    public static void accessServer()
    {
        Socket link=null;
        try{
            link=new Socket(host,port);

            Scanner input=new Scanner(link.getInputStream());
            PrintWriter out=new PrintWriter(link.getOutputStream(),true);
            Scanner in=new Scanner(System.in);
            String userName="",password,resp ;
            while(!userName.equals("End"))
            {
                System.out.println("Log in");
                System.out.println("Enter user name : ");
                userName=in.nextLine();
                out.println(userName);
                System.out.println("Enter Password");
                password=in.nextLine();
                out.println(password);
                resp=input.nextLine();
                System.out.println("\nSERVER> "+resp);

            }

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally {
            try {
                System.out.println("Closing Connection...");
                link.close();
            }catch (IOException e){
                System.out.println("Unable to Connect...");
                System.exit(1);
            }
        }
    }}


