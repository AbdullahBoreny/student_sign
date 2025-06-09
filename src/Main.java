import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        DataBase.connectToDatabase();
        Frame1 frame=new Frame1();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}
