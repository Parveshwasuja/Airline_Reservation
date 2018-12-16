import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class dropemployee extends JInternalFrame implements ItemListener,ActionListener{
	SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	Container c = getContentPane();
	Statement stmt;
	Connection conn;
	java.util.Date d1 = new java.util.Date();
	JTextField t1,t2,t3,t4,t5;
	JLabel l1,l2,l3,l4,l5,l6,lb;
	JComboBox cb;
	JButton b1,b2;
	dropemployee(){
       super("Drop employee",true,true,true,true);
       setSize(1366,712);
       //setTitle("Drop employee");
       setLayout(null);
       c.setBackground(Color.white);
      
      l1 =new JLabel("User ID");
      l2 =new JLabel("Name");
      l3 =new JLabel("Contact No");
      l4 =new JLabel("Email ID");
      l5 =new JLabel("Gender");
      l6 =new JLabel("Date of joining");

      t1 =new JTextField(30);
      t2 =new JTextField(30);
      t3 =new JTextField(30);
      t4 =new JTextField(30);
      t5 =new JTextField(30);

      cb = new JComboBox();
	  cb.addItem("Select");
      add(cb);
	  cb.addItemListener(this);

      b1 = new JButton("Drop");
      b2 = new JButton("Cancel");

      b1.addActionListener(this);
      b2.addActionListener(this);

      add(l1);
      add(l2);
      add(l3);
      add(l4);
      add(l5);
      add(l6);

      add(t1);
      add(t2);
      add(t3);
      add(t4);
      add(t5);

      add(b1);
      add(b2);

      l1.setFont(new Font("Arial" ,Font.BOLD ,18));
      l2.setFont(new Font("Arial" ,Font.BOLD ,18));
      l3.setFont(new Font("Arial" ,Font.BOLD ,18));
      l4.setFont(new Font("Arial" ,Font.BOLD ,18));
      l5.setFont(new Font("Arial" ,Font.BOLD ,18));
      l6.setFont(new Font("Arial" ,Font.BOLD ,18));

      l1.setBounds(440,100,250,30);
      l2.setBounds(440,150,250,30);
      l3.setBounds(440,200,250,30);
      l4.setBounds(440,250,250,30);
      l5.setBounds(440,300,250,30);
      l6.setBounds(440,350,250,30);
      
      cb.setFont(new Font("Arial" ,Font.BOLD ,18)); 
      cb.setBackground(Color.white);

      cb.setBounds(680,100,200,30);
      t1.setBounds(680,150,200,30);
      t2.setBounds(680,200,200,30);
      t3.setBounds(680,250,200,30);
      t4.setBounds(680,300,200,30);
      t5.setBounds(680,350,200,30);

      b1.setBounds(550,450,100,30);
      b2.setBounds(680,450,100,30);

      try{
          Class.forName("com.mysql.cj.jdbc.Driver");
          conn = DriverManager.getConnection("jdbc:mysql://localhost/FlightReservation","root","");
          stmt = conn.createStatement();
          String s = "Select * from employee";
          ResultSet rs = stmt.executeQuery(s);
          while(rs.next()){
          	cb.addItem(rs.getString(6));
          }
        }
        catch(Exception e){
          JOptionPane.showMessageDialog(this,"Unfortunately, app is workingly stopped");
        }
        t1.setEditable(false);
        t2.setEditable(false);
        t3.setEditable(false);
        t4.setEditable(false);
        t5.setEditable(false);

      //setVisible(true);
      ImageIcon ii = new ImageIcon("airplan2.jpeg");
          lb = new JLabel(ii);
          add(lb);
          lb.setBounds(0,0,1366,750);   
	}
	public void clear(){
		t1.setText("");
		t2.setText("");
		t3.setText("");
		t4.setText("");
		t5.setText("");
	}
	public void itemStateChanged(ItemEvent e){
		if(e.getSource()==cb && e.getStateChange()==ItemEvent.SELECTED){
			if(cb.getSelectedIndex()==0){
				clear();
				cb.setSelectedIndex(0);
			}else{
        	try{
        		String s = "select * from employee where userid='"+cb.getSelectedItem()+"'";
        		ResultSet rs = stmt.executeQuery(s);

        		if(rs.next()){
        			t1.setText(rs.getString(1));
        			t2.setText(rs.getString(3));
        			t3.setText(rs.getString(4));
        			t4.setText(rs.getString(5));
        			d1 = sdf2.parse(rs.getString(8));
        			String doj1 = sdf1.format(d1);
        			t5.setText(doj1);
        		}

        	}
        	catch(Exception f){
             JOptionPane.showMessageDialog(this,"Unfortunately, app is workingly stopped");
        	}
          }
        }
	}

	public void actionPerformed(ActionEvent e){
		try{
			if(e.getSource()==b1){
        if(cb.getSelectedIndex()!=0){
				
				int n = JOptionPane.showConfirmDialog(this,"Do you really want to drop userid "+cb.getSelectedItem()+" ?");
			    if(n==0){
			    	try{
              String item = String.valueOf(cb.getSelectedItem());
			    	String drop  ="delete from employee where userid='"+cb.getSelectedItem()+"'";
				    stmt.executeUpdate(drop);
				    JOptionPane.showMessageDialog(this,"user-id " +cb.getSelectedItem()+" dropped successfully");
				    clear();
            cb.removeItem(item);
				   }
				   catch(Exception ex1){
				   	JOptionPane.showMessageDialog(this,"Unfortunately, can't drop the user-id at the moment");
				   }
			    }
        }
        else{
          JOptionPane.showMessageDialog(this,"Please firstly select userid");
        }
			}
			if(e.getSource()==b2){
				clear();
				cb.setSelectedIndex(0);
				

			}

		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(this,"Unfortunately, app is workingly stopped");
		}

	}

}