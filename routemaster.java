import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.awt.event.*;
import java.util.*;

public class routemaster extends JInternalFrame implements ActionListener,ItemListener{
    Container c =getContentPane();
    Connection con;
    Statement stmt;
    JLabel l1,l2,l3,l4,l5,l6,l7,lb;
    JTextField t2,t3,t4,t5,t6,t7;
    JButton b1,b2;
    JComboBox cb1,cb2,cb3;

    routemaster(){
      super("Set flight for route",true,true,true,true);
      //setDefaultCloseOperation(EXIT_ON_CLOSE);
      setSize(1366,712);
      //setTitle("Route master");
      setLayout(null);
      c.setBackground(Color.white);

      l1 = new JLabel("Route code");
      l2 = new JLabel("Source");
      l3 = new JLabel("Destination");
      l4 = new JLabel("Aircraft code");
      l5 = new JLabel("Distance");
      l6 = new JLabel("Base price");
      l7 = new JLabel("Search");

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

      //t1 =new JTextField(30);
      t2 =new JTextField(30);
      t3 =new JTextField(30);
      t4 =new JTextField(30);
      t5 =new JTextField(30);
      t6 = new JTextField(30);
      t7 = new JTextField(30);

      //add(t1);
      add(t2);
      add(t3);
      add(t4);
      add(t5);
      add(t6);
      add(t7);

      //t1.setFont(new Font("Arial" ,Font.BOLD ,15));
      t2.setFont(new Font("Arial" ,Font.BOLD ,15));
      t3.setFont(new Font("Arial" ,Font.BOLD ,15));
      t4.setFont(new Font("Arial" ,Font.BOLD ,15));
      t5.setFont(new Font("Arial" ,Font.BOLD ,15));
      t6.setFont(new Font("Arial" ,Font.BOLD ,15));
      t7.setFont(new Font("Arial" ,Font.BOLD ,15));


      
      t2.setBounds(680,150,150,30);
      t3.setBounds(680,200,150,30);
      t4.setBounds(680,350,150,30);
      t5.setBounds(680,300,150,30);
      t6.setBounds(680,250,150,30);
      t7.setBounds(680,100,150,30);

      //t1.setEditable(false);
      t2.setEditable(false);
      t3.setEditable(false);
      t4.setEditable(false);
      t5.setEditable(false);
      t6.setVisible(false);
      t7.setVisible(false);

      b1 =new JButton("New");
      b2 =new JButton("Create");

      add(b1);
      add(b2);

      b1.setForeground(Color.white);
      b1.setBackground(Color.blue);

      b2.setForeground(Color.white);
      b2.setBackground(Color.red);

      b1.setBounds(560,420,100,30);
      b2.setBounds(680,420,100,30);

      b1.addActionListener(this);
      b2.addActionListener(this);

      cb1 = new JComboBox();
      cb1.setFont(new Font("Arial" ,Font.BOLD ,15)); 
      cb1.setBackground(Color.white);
      cb1.addItem("Select");
      add(cb1);
	    cb1.addItemListener(this);
      cb1.setBounds(680,250,150,30);

      cb2 = new JComboBox();
      cb2.setFont(new Font("Arial" ,Font.BOLD ,15)); 
      cb2.setBackground(Color.white);
      cb2.addItem("Select");
      add(cb2);
      cb2.addItemListener(this);

      cb3 = new JComboBox();
      cb3.setFont(new Font("Arial" ,Font.BOLD ,15)); 
      cb3.setBackground(Color.white);
      cb3.addItem("Select");
      add(cb3);
      cb3.addItemListener(this);
      cb3.setBounds(680,100,150,30);

	  cb2.setBounds(680,500,150,30);
	  b2.setEnabled(false);

      try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        con =DriverManager.getConnection("jdbc:mysql://localhost/FlightReservation","root","");
        stmt = con.createStatement();
        String s = "Select * from route";
        ResultSet rs = stmt.executeQuery(s);
          while(rs.next()){
          	cb2.addItem(rs.getString(2));
          }
          String s1 = "select * from fleetinfo where status = 'y'";
                ResultSet rs1 = stmt.executeQuery(s1);
                while(rs1.next()){
                  cb1.addItem(rs1.getString(1));
                }
        String insert1 = "select * from routemaster"; 
        ResultSet rs2 = stmt.executeQuery(insert1);
        while(rs2.next()){
            cb3.addItem(rs2.getString(1));
          }       
      }catch(Exception e){
         JOptionPane.showMessageDialog(this,"Unfortunately, app is workingly stopped");
      }
      cb1.setEnabled(false);
      cb3.setEnabled(false);
      ImageIcon ii = new ImageIcon("airplan2.jpeg");
          lb = new JLabel(ii);
          add(lb);
          lb.setBounds(0,0,1366,750);
      //setVisible(true);
    }
    public void clear(){
		//t1.setText("");
		t2.setText("");
		t3.setText("");
		t4.setText("");
		t5.setText("");
    t6.setText("");
    t7.setText("");
     }
	
    public void itemStateChanged(ItemEvent e){
    	if(e.getSource()==cb2 && e.getStateChange()==ItemEvent.SELECTED){
    		if(cb2.getSelectedIndex()==0){
				clear();
				cb2.setSelectedIndex(0);
			}else{
				try{
					          b2.setEnabled(false);
					          //t1.setEditable(false);
                    t2.setEditable(false);
                    t3.setEditable(false);
                    t4.setEditable(false);
                    t5.setEditable(false);
                    t6.setVisible(true);
                    t6.setEditable(false);
                    t7.setVisible(true);
                    t7.setEditable(false);
					String s = "select * from route where a_code='"+cb2.getSelectedItem()+"'";
        		    ResultSet rs = stmt.executeQuery(s);
        		    if(rs.next()){
        			String c1 = rs.getString(1);
              String c = rs.getString(2);
        			t2.setText(rs.getString(3));
        			t3.setText(rs.getString(4));
        			t4.setText(rs.getString(5));
        			t5.setText(rs.getString(6));
              t6.setText(c);
              t7.setText(c1);	
              //cb3.setSelectedItem(c1);
        		}

				}
				catch(Exception ex){
					JOptionPane.showMessageDialog(this,"Unfortunately, app is workingly stopped");
				}
			}

    	}
      if(e.getSource()==cb3 && e.getStateChange()==ItemEvent.SELECTED){
        if(cb3.getSelectedIndex()==0){
          t2.setText("");
          t3.setText("");
          cb3.setSelectedIndex(0);

        }else{
          try{
            String emailid = "select * from routemaster where r_code='"+cb3.getSelectedItem()+"'";
            ResultSet rs = stmt.executeQuery(emailid);
            if(rs.next()){
               t2.setText(rs.getString(2));
               t3.setText(rs.getString(3));
             }

          }
          catch(Exception ex1){
            JOptionPane.showMessageDialog(this,"Unfortunately, app is workingly stopped");
          }
        }

      }
    }

    public void actionPerformed(ActionEvent e){
    	try{
    	if(e.getSource()==b1){
    		    //t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            b2.setEnabled(true);
            t4.setEditable(true);
            t5.setEditable(true);
            cb3.setEnabled(true);
            cb1.setEnabled(true);
            cb1.setVisible(true);
            t6.setVisible(false);
            t7.setVisible(false);
            cb1.setSelectedIndex(0);
            cb2.setSelectedIndex(0);
            cb3.setSelectedIndex(0);
    	}
    	if(e.getSource()==b2){
    		if(cb3.getSelectedIndex()==0 || t2.getText().trim().length()==0 || t3.getText().trim().length()==0 || t4.getText().trim().length()==0 || t5.getText().trim().length()==0 ||cb1.getSelectedIndex()==0){
                JOptionPane.showMessageDialog(this,"Fields can not be empty");
              }
            else{
                boolean pw1 = validation.checkinteger(t4.getText().trim());
                boolean pw2 = validation.checkinteger(t5.getText().trim());
                if(pw1==false || pw2==false){
                  if(pw1==false){
                     JOptionPane.showMessageDialog(this,"Price should be in integer");
                  }else{
                    if(pw2==false){
                     JOptionPane.showMessageDialog(this,"Distance should be positive decimal number");
                    }
                  }


                }
                else{


                String create = "insert into route values('"+cb3.getSelectedItem()+"','"+cb1.getSelectedItem()+"','"+t2.getText()+"','"+t3.getText()+"',"+t4.getText()+","+t5.getText()+")";
                stmt.executeUpdate(create);
                JOptionPane.showMessageDialog(this,"Created successfully");
                cb2.addItem(cb1.getSelectedItem());
                clear();
                b2.setEnabled(false);

                 

                String update = "update fleetinfo set status='n' where a_code='"+cb1.getSelectedItem()+"'";
                cb1.removeItem(cb1.getSelectedItem());               
                cb1.setSelectedIndex(0);
                cb3.setSelectedIndex(0);
                stmt.executeUpdate(update); 
              }
                	      
    	       }
           }
        }
        catch(Exception ex){
  	     JOptionPane.showMessageDialog(this,"Unfortunately, app is workingly stopped");
        }
    }

}