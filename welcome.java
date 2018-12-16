import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;

class welcome extends JFrame implements ActionListener{
	Container c = getContentPane();
	Color c1 = new Color(33,33,33);
	JLabel l1,lb;
	JButton b1,b2;
	welcome(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
     setSize(1366,768);
     setTitle("Vistara");
     setLayout(null);
     
     c.setBackground(Color.white);

     l1 = new JLabel("Welcome to Vistara Airlines");
     l1.setForeground(Color.black);
     l1.setFont(new Font("Arial",Font.BOLD,40));
     add(l1);
     
     l1.setBounds(400,300,600,40);
     
     b1 = new JButton("User login");
     b2 = new JButton("Admin login");
    
     add(b1);
     add(b2);
     b1.setBounds(520,450,120,50);
     b1.setBackground(Color.blue);
     b1.setForeground(Color.white);
     b1.setFont(new Font("Arial",Font.BOLD,15));
     //b2.setBounds(680,500,120,50);
     b2.setBackground(Color.red);
     b2.setForeground(Color.white);
     b2.setFont(new Font("Arial",Font.BOLD,15));
     
     b2.setBounds(690,450,120,50);

     ImageIcon ii = new ImageIcon("airplan2.jpeg");
     lb = new JLabel(ii);
     add(lb);
     lb.setBounds(0,0,1366,750);
     setVisible(true);
     b1.addActionListener(this);
     b2.addActionListener(this);

     setExtendedState(JFrame.MAXIMIZED_BOTH);

	}
	public void actionPerformed(ActionEvent e){
        if(e.getSource()==b1){
            new login("User");
        }else{
        	new login("Admin");
        }
        this.dispose();
	}
	public static void main(String[] args) {
		new welcome();
	}
}