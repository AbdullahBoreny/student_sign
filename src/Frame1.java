import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class Frame1 extends JFrame {

    private JList c;
    private JButton add;

    private JTextField name;

    private JTextField mark;
    private JButton show;
    private JButton src;
    private JButton search;

    private String names;
    private int marks;
    private JButton exit;
    private JTextArea t;

    private JLabel logo;
    private Icon fet;
    ArrayList list =new ArrayList();
    private  String[] n = {"Advanced programming", "Embedded systems", "Machine learning"};
    public Frame1()
    {
        super("تسجيل العلامات");
        setLayout(new GridLayout(4,3,5,10)); // set frame layout

        fet = new ImageIcon(getClass().getResource("fet.png"));
        logo = new JLabel("نظام العلامات",fet,SwingConstants.CENTER);
        logo.setHorizontalTextPosition(SwingConstants.CENTER);
        logo.setVerticalTextPosition(SwingConstants.BOTTOM);
        add(new JLabel());
        add(logo);
        add(new JLabel());
        mark = new JTextField("علامة الطالب من 100");
        add(mark);
        name = new JTextField("اسم الطالب");
        add(name);
        add = new JButton( "اضف الطالب" );
        add(add);
        search = new JButton( "بحث حسب الاسم" );
        add ( search );
        src = new JButton( "بحث حسب العلامة" );
        add( src );
        show = new JButton( "عرض" );
        add( show );
        exit = new JButton("خروج");
        add(exit);
        t=new JTextArea(10,20);
        add(new JScrollPane(t));
        c = new JList(n);
        c.setVisibleRowCount(3);
        add(c);

        ButtonHandler handler = new ButtonHandler();
        add.addActionListener( handler );
        show.addActionListener( handler );
        src.addActionListener( handler );
        search.addActionListener( handler );
        exit.addActionListener(handler);

    }
    private class ButtonHandler implements ActionListener
    {
        // handle button event
        public void actionPerformed( ActionEvent event )
        {
            if(event.getSource()==add) {
                names = name.getText();
                marks = Integer.parseInt(mark.getText());
                DataBase.addTo(c.getSelectedIndex(),names,marks);
            }
            if(event.getSource()==show) {
                list = DataBase.show(c.getSelectedIndex());
                t.setText("");
                for(int i = 0; i < list.size(); i+=2)
                {
                    String st = String.format(list.get(i).toString()+ " " +list.get(i+1).toString() +"\n");
                    t.append(st);
                }
            }
            if(event.getSource()==src) {
                int k= Integer.parseInt(JOptionPane.showInputDialog("Enter mark to search"));
                list = DataBase.SerchByMark(c.getSelectedIndex(),k);
                t.setText("");
                for(int i = 0; i < list.size(); i+=2)
                {
                    String st = String.format(list.get(i).toString()+ " " +list.get(i+1).toString() +"\n");
                    t.append(st);
                }
            }
            if(event.getSource()==search) {
                String k= JOptionPane.showInputDialog("Enter name to search");
                list = DataBase.SerchByName(c.getSelectedIndex(),k);
                t.setText("");
                for(int i = 0; i < list.size(); i+=2)
                {
                    String st = String.format(list.get(i).toString()+ " " +list.get(i+1).toString() +"\n");
                    t.append(st);
                }

            }
            if(event.getSource()==exit)
            {
                System.exit(0);
            }

        } // end method actionPerformed
    } // end private inner class ButtonHandler

}