package hr.fvlahov.barsapp.dal;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    private Connection connection;

    private static final String host = "ec2-54-155-35-88.eu-west-1.compute.amazonaws.com";  // For Amazon Postgresql
    private static final String database = "da8s7fm18q597n";
    private static final int port = 5432;
    private static final String user = "bdglvkjmhxcqto";
    private static final String pass = "96e7968129143b145a40ff1b9a7b2b8809f7d0d44b32408d9168ffd4bff9077e";
    //private String url = "jdbc:postgresql://%s:%d/%s";
    private static String url = "postgres://bdglvkjmhxcqto:96e7968129143b145a40ff1b9a7b2b8809f7d0d44b32408d9168ffd4bff9077e@ec2-54-155-35-88.eu-west-1.compute.amazonaws.com:5432/da8s7fm18q597n";
    private static boolean status;

    private void connect() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Class.forName("org.postgresql.Driver");
                    connection = DriverManager.getConnection(url, user, pass);
                    status = true;
                    System.out.println("connected:" + status);
                } catch (Exception e) {
                    status = false;
                    System.out.print(e.getMessage());
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (Exception e) {
            e.printStackTrace();
            this.status = false;
        }
    }

    public static Connection getConnection(){
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return c;
    }
}
