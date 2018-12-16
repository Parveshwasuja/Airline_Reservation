import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class login extends JFrame implements ActionListener{
	Container c = getContentPane();
	JLabel l1,l2,lb,l3;
	JTextField tx1;
	JPasswordField tx2;
	JButton b,b1;
	Connection conn;
	Statement stmt;
	JPanel p1;
	String user="";
	login(String name){
		//super("Create new employee",true,true,true,true);
		user=name;
      setSize(1366,768);
      setTitle(user+"Login");
      //setLayout(null);
      l1 = new JLabel("User Id : ");
	  l1.setFont(new Font("Arial",Font.BOLD,25));
	  l2 = new JLabel("Password : ");
	  l2.setFont(new Font("Arial",Font.BOLD,25));
	  l3 = new JLabel("Enter your login details");
	  l3.setFont(new Font("Arial",Font.BOLD,30));
	  l3.setForeground(Color.white);

	  p1 = new JPanel();
	  p1.setBackground(Color.black);
      p1.add(l3);
	  add(p1,"North");

	  tx1 = new JTextField(50);
	  tx2 = new JPasswordField(50);
	  tx1.setFont(new Font("Arial",Font.BOLD,20));
	  tx2.setFont(new Font("Arial",Font.BOLD,20));
	  b = new JButton("Login");
	  b1 = new JButton("Back");
   	  b.setFont(new Font("Arial",Font.BOLD,15));
   	  b1.setFont(new Font("Arial",Font.BOLD,15));
	  add(l1);
	  add(tx1);
	  add(l2);
	  add(tx2);
	  add(b);
	  add(b1);
	  l1.setBounds(430,320,500,80);
	  l2.setBounds(430,400,500,80);
	  l1.setForeground(Color.black);
	  l2.setForeground(Color.black);
	  tx1.setBounds(680,340,200,40);
	  tx2.setBounds(680,420,200,40);
	  b.setBounds(630,500,80,30);
	  b.addActionListener(this);
	  b.setForeground(Color.white);
	  b.setBackground(Color.blue);
	  b1.setBounds(730,500,80,30);
	  b1.addActionListener(this);
	  b1.setForeground(Color.white);
	  b1.setBackground(Color.red);
	  ImageIcon ii = new ImageIcon("airplan2.jpeg");
     lb = new JLabel(ii);
     add(lb);
     lb.setBounds(0,0,1366,750);

      setVisible(true);
      try{
     		Class.forName("com.mysql.cj.jdbc.Driver");
    		conn= DriverManager.getConnection("jdbc:mysql://localhost/FlightReservation","root","");
    		stmt=conn.createStatement();
     }
     catch(Exception e){
     	JOptionPane.showMessageDialog(this,"Unfortunately, app is workingly stopped");
     }
     setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
	public void actionPerformed(ActionEvent e){
		try{
        if(e.getSource()==b){
        	if(user.equals("User")){
        		String checkuser = "select * from employee where userid='"+tx1.getText()+"' and password='"+tx2.getText()+"'";
        	    ResultSet rs2 = stmt.executeQuery(checkuser);
        	    if(rs2.next()){
        	    	userpanel obj = new userpanel(tx1.getText());
        	    	this.dispose();
        	    }
        	    else{
        	    	JOptionPane.showMessageDialog(this,"Invalid Credentials");
        	    }
        	}
        	else if(user.equals("Admin")){
        		String check = "Select * from admin where username='"+tx1.getText()+"' and password='"+tx2.getText()+"'";
            ResultSet rs = stmt.executeQuery(check);
            if(rs.next()){
            	adminpanel obj1 = new adminpanel();
            	this.dispose();
            	//JOptionPane.showMessageDialog(this,"Logged in successfully");
            }
            else{
            	JOptionPane.showMessageDialog(this,"Invalid Credentials");
            }

        	}
        	
        }
        if(e.getSource()==b1){
        	this.dispose();
        	new welcome();
        }
      }
      catch(Exception ex){
          JOptionPane.showMessageDialog(this,"Unfortunately, app is workingly stopped");
      }
	}
	public static void main(String[] args) {
		new login("");
	}
} 
