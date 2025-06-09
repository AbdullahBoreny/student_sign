import java.sql.*;
import java.util.ArrayList;

public class DataBase {

    public static void connectToDatabase() {
        try {// create a connection with database
            // mysql: database type
            // localhost:3306: database address and port
            //Database Schema name is java
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "12291229n");
            System.out.println("Database Connection Success");
            Statement stm = con.createStatement();
            String qurey = String.format("CREATE TABLE IF NOT EXISTS advanced_programming (" + "student_name VARCHAR(100), " + "mark INT)");
            stm.execute(qurey);
            qurey = String.format("CREATE TABLE IF NOT EXISTS embedded_systems (" + "student_name VARCHAR(100), " + "mark INT)");
            stm.execute(qurey);
            qurey = String.format("CREATE TABLE IF NOT EXISTS machine_learning (" + "student_name VARCHAR(100), " + "mark INT)");
            stm.execute(qurey);
            stm.close();
        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }
    public static void addTo(int index, String name, int mark) {
        String[] tableNames = {"advanced_programming", "embedded_systems", "machine_learning"};
        String tableName = tableNames[index];
        String query = "INSERT INTO " + tableName + " (student_name, mark) VALUES ('" + name + "', " + mark + ");";        System.out.println(query);
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "12291229n");
            Statement stm = con.createStatement();
            stm.execute(query);
            stm.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static ArrayList show(int index)
    {
        String[] tableNames = {"advanced_programming", "embedded_systems", "machine_learning"};
        ArrayList list = new ArrayList();
        String tableName = tableNames[index];
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "12291229n");
            Statement stm = con.createStatement();
            String qurey = "SELECT * FROM "+ tableName;
            ResultSet rs = stm.executeQuery( qurey);
            while(rs.next())
            {
                String st=rs.getString("student_name");
                int ma = rs.getInt("mark");
                list.add(st);
                list.add(ma);
            }
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (list);
    }

    public static ArrayList SerchByMark(int index,int mark)
    {
        String[] tableNames = {"advanced_programming", "embedded_systems", "machine_learning"};
        ArrayList list = new ArrayList();
        String tableName = tableNames[index];
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "12291229n");
            Statement stm = con.createStatement();
            String qurey = "SELECT * FROM "+ tableName;
            ResultSet rs = stm.executeQuery( qurey);
            while(rs.next())
            {
                String st=rs.getString("student_name");
                int ma = rs.getInt("mark");
                if(ma == mark)
                {
                    list.add(st);
                    list.add(ma);
                }
            }
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (list);
    }
    public static ArrayList SerchByName(int index,String name)
    {
        String[] tableNames = {"advanced_programming", "embedded_systems", "machine_learning"};
        ArrayList list = new ArrayList();
        String tableName = tableNames[index];
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "12291229n");
            Statement stm = con.createStatement();
            String qurey = "SELECT * FROM "+ tableName;
            ResultSet rs = stm.executeQuery( qurey);
            while(rs.next())
            {
                String st=rs.getString("student_name");
                int ma = rs.getInt("mark");
                if(st.equals(name))
                {
                    list.add(st);
                    list.add(ma);
             }
            }
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (list);
    }
}
