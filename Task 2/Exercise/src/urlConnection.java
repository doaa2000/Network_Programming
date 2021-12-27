import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class urlConnection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter a url ");
        String url = scanner.nextLine();
        accessWebsite(url);
    }

    private static void accessWebsite(String url) {
        File file = new File("da.txt");
        try {
            URL my_url = new URL(url);
            URLConnection urlConnection = my_url.openConnection();
            InputStream isr = urlConnection.getInputStream();
            OutputStream out = new FileOutputStream(file);

            int i;
            while ((i= isr.read()) != 0) {
                out.write(i);
            }
            isr.close();
            out.close();
        } catch (IOException exception) {
            System.out.println("\n Cannot access URL");
            System.exit(1);
        } finally {
            System.out.println("\n Closing the connection");

            System.exit(1);

        }
    }
}