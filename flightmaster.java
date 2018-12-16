import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.util.*;

public class flightmaster extends JInternalFrame implements ActionListener,ItemListener{
    Container c =getContentPane();
    Connection con;
    Statement stmt;
    JLabel l1,l2,l3,l4,l5,l6,l7,lb;
    JTextField t1,t2,t3,t4,t5,t6;
    JButton b1,b2;
    JComboBox cb;
    flightmaster(){
      super("Create new flight",true,true,true,true);
      //setDefaultCloseOperation(EXIT_ON_CLOSE);
      setSize(1366,712);
      //setTitle("Flight master");
      setLayout(null);
      c.setBackground(Color.white);

      l1 = new JLabel("Aircraft code");
      l2 = new JLabel("Aircraft name");
      l3 = new JLabel("Class E seats");
      l4 = new JLabel("Class B seats");
      l5 = new JLabel("Weight E cap");
      l6 = new JLabel("Weight B cap");
      l7 = new JLabel("Search Aircraft");

      add(l1);
      add(l2);
      add(l3);
      add(l4);
      add(l5);
      add(l6);
      add(l7);

      l1.setFont(new Font("Arial" ,Font.BOLD ,18));
      l2.setFont(new Font("Arial" ,Font.BOLD ,18));
      l3.setFont(new Font("Arial" ,Font.BOLD ,18));
      l4.setFont(new Font("Arial" ,Font.BOLD ,18));
      l5.setFont(new Font("Arial" ,Font.BOLD ,18));
      l6.setFont(new Font("Arial" ,Font.BOLD ,18));
      l7.setFont(new Font("Arial" ,Font.BOLD ,18));

      l1.setBounds(440,100,250,30);
      l2.setBounds(440,150,250,30);
      l3.setBounds(440,200,250,30);
      l4.setBounds(440,250,250,30);
      l5.setBounds(440,300,250,30);
      l6.setBounds(440,350,250,30);
      l7.setBounds(440,500,250,30);

      t1 =new JTextField(30);
      t2 =new JTextField(30);
      t3 =new JTextField(30);
      t4 =new JTextField(30);
      t5 =new JTextField(30);
      t6 =new JTextField(30);

      add(t1);
      add(t2);
      add(t3);
      add(t4);
      add(t5);
      add(t6);

      t1.setFont(new Font("Arial" ,Font.BOLD ,15));
      t2.setFont(new Font("Arial" ,Font.BOLD ,15));
      t3.setFont(new Font("Arial" ,Font.BOLD ,15));
      t4.setFont(new Font("Arial" ,Font.BOLD ,15));
      t5.setFont(new Font("Arial" ,Font.BOLD ,15));
      t6.setFont(new Font("Arial" ,Font.BOLD ,15));

      t1.setBounds(680,100,150,30);
      t2.setBounds(680,150,150,30);
      t3.setBounds(680,200,150,30);
      t4.setBounds(680,250,150,30);
      t5.setBounds(680,300,150,30);
      t6.setBounds(680,350,150,30);

      t1.setEditable(false);
      t2.setEditable(false);
      t3.setEditable(false);
      t4.setEditable(false);
      t5.setEditable(false);
      t6.setEditable(false);

      b1 =new JButton("New");
      b2 =new JButton("Create");

      add(b1);
      add(b2);

      b1.setForeground(Color.white);
      b1.setBackground(Color.blue);

      b2.setForeground(Color.white);
      b2.setBackground(Color.red);

      b1.setBounds(560,450,100,30);
      b2.setBounds(680,450,100,30);

      b1.addActionListener(this);
      b2.addActionListener(this);

      cb = new JComboBox();
      cb.setFont(new Font("Arial" ,Font.BOLD ,15)); 
      cb.setBackground(Color.white);
      cb.addItem("Select");
      add(cb);
	  cb.addItemListener(this);

	  cb.setBounds(680,500,150,30);
	  b2.setEnabled(false);

      try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        con =DriverManager.getConnection("jdbc:mysql://localhost/FlightReservation","root","");
        stmt = con.createStatement();
        String s = "Select * from fleetinfo";
        ResultSet rs = stmt.executeQuery(s);
          while(rs.next()){
          	cb.addItem(rs.getString(1));
          }
      }catch(Exception e){
         JOptionPane.showMessageDialog(this,"Unfortunately, app is workingly stopped");
      }
      ImageIcon ii = new ImageIcon("airplan2.jpeg");
          lb = new JLabel(ii);
          add(lb);
          lb.setBounds(0,0,1366,750);
       
      //setVisible(true);
    }
    public void clear(){
		t1.setText("");
		t2.setText("");
		t3.setText("");
		t4.setText("");
		t5.setText("");
		t6.setText("");
	}
    public void itemStateChanged(ItemEvent e){
    	if(e.getSource()==cb && e.getStateChange()==ItemEvent.SELECTED){
    		if(cb.getSelectedIndex()==0){
				clear();
				cb.setSelectedIndex(0);
			}else{
				try{
					b2.setEnabled(false);
					t1.setEditable(false);
                    t2.setEditable(false);
                    t3.setEditable(false);
                    t4.setEditable(false);
                    t5.setEditable(false);
                    t6.setEditable(false);
					String s = "select * from fleetinfo where a_code='"+cb.getSelectedItem()+"'";
        		    ResultSet rs = stmt.executeQuery(s);
        		    if(rs.next()){
        			t1.setText(rs.getString(1));
        			t2.setText(rs.getString(2));
        			t3.setText(rs.getString(3));
        			t4.setText(rs.getString(4));
        			t5.setText(rs.getString(5));
        			t6.setText(rs.getString(6));	
        		}

				}
				catch(Exception ex){
					JOptionPane.showMessageDialog(this,"Unfortunately, app is workingly stopped");
				}
			}

    	}
    }

    public void actionPerformed(ActionEvent e){
    	try{
    	if(e.getSource()==b1){
    		t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            t6.setText("");
            b2.setEnabled(true);
            t1.setEditable(true);
            t2.setEditable(true);
            t3.setEditable(true);
            t4.setEditable(true);
            t5.setEditable(true);
            t6.setEditable(true);
            t1.requestFocus();
            cb.setSelectedIndex(0);
    	}
    	if(e.getSource()==b2){
    		if(t1.getText().trim().length()==0 || t2.getText().trim().length()==0 || t3.getText().trim().length()==0 || t4.getText().trim().length()==0 || t5.getText().trim().length()==0 || t6.getText().trim().length()==0){
                JOptionPane.showMessageDialog(this,"Fields can not be empty");
              }
            else{
            	String check = "select * from fleetinfo where a_code='"+t1.getText()+"'";
            	ResultSet rs2 = stmt.executeQuery(check);
            	if(rs2.next()){
                   JOptionPane.showMessageDialog(this,"Aircraft code already exists");
                }else{
                  boolean pw3 = validation.checkintegerwithoutdecimal(t3.getText());
                  boolean pw4 = validation.checkintegerwithoutdecimal(t4.getText());
                  boolean pw5 = validation.checkintegerwithoutdecimal(t5.getText());
                  boolean pw6 = validation.checkintegerwithoutdecimal(t6.getText());
                  if( pw3==false || pw4==false || pw5== false || pw6==false){
                    JOptionPane.showMessageDialog(this,"All entries should be integers and greater than 10");

                  }
                  else{


                String create = "insert into fleetinfo values('"+t1.getText()+"','"+t2.getText()+"',"+t3.getText()+","+t4.getText()+","+t5.getText()+","+t6.getText()+",'y')";
                stmt.executeUpdate(create);
                JOptionPane.showMessageDialog(this,"Created successfully");
                b2.setEnabled(false);
                cb.addItem(t1.getText());
               }
                
                }   	      
    	      }
            }
        }
        catch(Exception ex){
  	     JOptionPane.showMessageDialog(this,"Unfortunately, app is workingly stopped");
        }
    }
}