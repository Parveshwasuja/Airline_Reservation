import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.awt.event.*;
import java.util.*;

public class timmingmaster extends JInternalFrame implements ActionListener,ItemListener,FocusListener{
    Container c = getContentPane();
    Connection con;
    Statement stmt;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,lb;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JButton b1,b2;
    JComboBox cb1;
    SimpleDateFormat sdf1 = new SimpleDateFormat("H:m");
    java.util.Date d1 = new java.util.Date();
    java.util.Date d2 = new java.util.Date();
    java.util.Date d3 = new java.util.Date();
    int flag=0;

    timmingmaster(){
      super("set time-table",true,true,true,true);
      //setDefaultCloseOperation(EXIT_ON_CLOSE);
      setSize(1366,712);
      //setTitle("Route master");
      setLayout(null);
      c.setBackground(Color.white);
      l1 = new JLabel("Aircraft code");
      l2 = new JLabel("Route code");
      l3 = new JLabel("Source");
      l4 = new JLabel("Destination");
      l5 = new JLabel("Distance");
      l6 = new JLabel("Departure time");
      l7 = new JLabel("Journey Hours");
      l8 = new JLabel("Arrival time");

      add(l1);
      add(l2);
      add(l3);
      add(l4);
      add(l5);
      add(l6);
      add(l7);
      add(l8);

      l1.setFont(new Font("Arial" ,Font.BOLD ,18));
      l2.setFont(new Font("Arial" ,Font.BOLD ,18));
      l3.setFont(new Font("Arial" ,Font.BOLD ,18));
      l4.setFont(new Font("Arial" ,Font.BOLD ,18));
      l5.setFont(new Font("Arial" ,Font.BOLD ,18));
      l6.setFont(new Font("Arial" ,Font.BOLD ,18));
      l7.setFont(new Font("Arial" ,Font.BOLD ,18));
      l8.setFont(new Font("Arial" ,Font.BOLD ,18));

      l1.setBounds(440,100,250,30);
      l2.setBounds(440,150,250,30);
      l3.setBounds(440,200,250,30);
      l4.setBounds(440,250,250,30);
      l5.setBounds(440,300,250,30);
      l6.setBounds(440,350,250,30);
      l7.setBounds(440,400,250,30);
      l8.setBounds(440,450,250,30);

      t1 =new JTextField(30);
      t2 =new JTextField(30);
      t3 =new JTextField(30);
      t4 =new JTextField(30);
      t5 =new JTextField(30);
      t6 =new JTextField(30);
      t7 =new JTextField(30);

      t1.setEditable(false);
      t2.setEditable(false);
      t3.setEditable(false);
      t4.setEditable(false);
      t5.setEditable(false);
      t6.setEditable(false);
      t7.setEditable(false);

      add(t1);
      add(t2);
      add(t3);
      add(t4);
      add(t5);
      add(t6);
      add(t7);

      t1.setBounds(680,150,150,30);
      t2.setBounds(680,200,150,30);
      t3.setBounds(680,250,150,30);
      t4.setBounds(680,300,150,30);
      t5.setBounds(680,350,150,30);
      t6.setBounds(680,400,150,30);
      t7.setBounds(680,450,150,30);

      t1.setFont(new Font("Arial" ,Font.BOLD ,15));
      t2.setFont(new Font("Arial" ,Font.BOLD ,15));
      t3.setFont(new Font("Arial" ,Font.BOLD ,15));
      t4.setFont(new Font("Arial" ,Font.BOLD ,15));
      t5.setFont(new Font("Arial" ,Font.BOLD ,15));
      t6.setFont(new Font("Arial" ,Font.BOLD ,15));
      t7.setFont(new Font("Arial" ,Font.BOLD ,15));

      cb1 = new JComboBox();
      cb1.setFont(new Font("Arial" ,Font.BOLD ,15)); 
      cb1.setBackground(Color.white);
      cb1.addItem("Select");
      add(cb1);
	  cb1.addItemListener(this);
      cb1.setBounds(680,100,150,30);

      b1 =new JButton("New");
      b2 =new JButton("Create");

      add(b1);
      add(b2);

      b1.setForeground(Color.white);
      b1.setBackground(Color.blue);

      b2.setForeground(Color.white);
      b2.setBackground(Color.red);

      b1.setBounds(560,520,100,30);
      b2.setBounds(680,520,100,30);

      b1.addActionListener(this);
      b2.addActionListener(this);
      t6.addFocusListener(this);

      try{
      	Class.forName("com.mysql.cj.jdbc.Driver");
        con =DriverManager.getConnection("jdbc:mysql://localhost/FlightReservation","root","");
        stmt = con.createStatement();
        String insert="select a_code from route";
        ResultSet rs = stmt.executeQuery(insert);
        while(rs.next()){
           cb1.addItem(rs.getString(1));
        }
      }
      catch(Exception ex){
      	JOptionPane.showMessageDialog(this,"Unfortunately, app is workingly stopped");
      }
      b2.setEnabled(false);

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
        t6.setText("");
        t7.setText("");
	}
	public void focusGained(FocusEvent e){
       
    }
	public void focusLost(FocusEvent e){
		try
		{
			/*int length = t5.getText().length();
			int index = t5.getText().indexOf(':');
			int ah = Integer.valueOf(t5.getText().substring(0,index));
			int am = Integer.valueOf(t5.getText().substring(index+1,length));

			length = t6.getText().length();
			index = t6.getText().indexOf(':');
			int ah1 = Integer.valueOf(t6.getText().substring(0,index));
			int am1 = Integer.valueOf(t6.getText().substring(index+1,length));

			ah=ah+ah1;
			am=am+am1;*/

       d1 = sdf1.parse(t5.getText());
       d2 = sdf1.parse(t6.getText());
       int ah=d1.getHours()+d2.getHours();
       int am=d1.getMinutes()+d2.getMinutes();// use 24 hour format in system*/
       
       if(ah==23){
       	if(am>=60){
       		am=am-60;
       		ah=0;
       	}
       }
       while(ah>=24){
       	  ah=ah-24;
          System.out.println(ah);
       	  if(am>=60){
       	  	am=am-60;
       	  	ah=ah+1;
       	  }  
       }
       if(ah<23 && am>=60){
       	   ah=ah+1;
       	   am=am-60;
       }
       t7.setText(format(String.valueOf(ah))+":"+format(String.valueOf(am)));

          
    	}
    	catch(Exception ee)
    	{
    		JOptionPane.showMessageDialog(this,"Enter correct time format hh:mm");
    	}
    }

    public void itemStateChanged(ItemEvent e){
    	if(e.getSource()==cb1 && e.getStateChange()==ItemEvent.SELECTED){
    		if(cb1.getSelectedIndex()==0){
				clear();
				cb1.setSelectedIndex(0);
			}else{
				try{
					String put = "select * from route where a_code='"+cb1.getSelectedItem()+"'";
					ResultSet rs = stmt.executeQuery(put);
					if(rs.next()){
						t1.setText(rs.getString(1));
						t2.setText(rs.getString(3));
						t3.setText(rs.getString(4));
						t4.setText(rs.getString(6));
					}
          String check="select * from timing where a_code='"+cb1.getSelectedItem()+"'";
          ResultSet rs2 = stmt.executeQuery(check);
					if(!rs2.next()){
            t5.setText("");
            t6.setText("");
            t7.setText("");
            flag=0;
            b2.setText("Create");
						
					}
          else{
            t5.setText(rs2.getString(3));
            t6.setText(rs2.getString(5));
            t7.setText(rs2.getString(4));
            b2.setText("Modify");
            b2.setEnabled(true);
            flag=1;
          }
					t5.setEditable(true);
          t6.setEditable(true);

				}
				catch(Exception ex){
          JOptionPane.showMessageDialog(this,"Unfortunately, app is workingly stopped");

				}
			}

        }
    }
    public void actionPerformed(ActionEvent e){
    	if(e.getSource()==b1){
    		t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            t6.setText("");
            t7.setText("");
            b2.setEnabled(true);
            t5.setEditable(true);
            t6.setEditable(true);
            cb1.setSelectedIndex(0);
            b2.setText("Create");
    	}
    	if(e.getSource()==b2){
    		if(t1.getText().trim().length()==0 || t2.getText().trim().length()==0 || t3.getText().trim().length()==0 || t4.getText().trim().length()==0 || t5.getText().trim().length()==0 ||cb1.getSelectedIndex()==0 || t6.getText().trim().length()==0 || t7.getText().trim().length()==0){
                JOptionPane.showMessageDialog(this,"Fields can not be empty");
             }
            else{
              try{
              if(flag==0){
                String insert="insert into timing value('"+cb1.getSelectedItem()+"','"+t1.getText()+"','"+t5.getText()+"','"+t7.getText()+"','"+t6.getText()+"')";
                stmt.executeUpdate(insert);
                JOptionPane.showMessageDialog(this,"created successfully");
                b2.setText("Modify");
                b2.setEnabled(false);             
              }
              else{
                String update="update timing set departure='"+t5.getText()+"', arrival='"+t7.getText()+"',j_hours='"+t6.getText()+"'";
                stmt.executeUpdate(update);
                JOptionPane.showMessageDialog(this,"Updated successfully");
                b2.setText("Modify");
                b2.setEnabled(false);
              }
            }
            catch(Exception ex1){
              JOptionPane.showMessageDialog(this,"Unfortunately, app is workingly stopped");
            }

            }
    	}

    }
    public String format(String x){
      if(x.length()>1){
        return x;
      }
      else{
        return "0"+x;
      }
    }

}