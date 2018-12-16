import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.awt.event.*;
import java.util.*;

public class createemployee extends JInternalFrame implements ActionListener,FocusListener{
  Container c =getContentPane();
  Connection con;
  Random r = new Random();
  Statement stmt;
  JLabel l0,l1,l2,l3,l4,l5,l6,l7,l8,lb;
  JTextField t1,t2,t3,t4,t5,t6,t7;
  JRadioButton  rb1 ,rb2;
  ButtonGroup bg;
  java.util.Date d1 = new java.util.Date();
  JButton b1,b2;
  String temp;
  String s1;
  SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
  SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");

  createemployee()
  {
    //setDefaultCloseOperation(EXIT_ON_CLOSE);
      super("Create new employee",true,true,true,true);
      setSize(1366,712);
      //setTitle("Create employee");
      setLayout(null);
      c.setBackground(Color.white);

    /**Labels here */
      l1 =new JLabel("Full Name");
      l2 =new JLabel("Address");
      l3 =new JLabel("Contact No");
      l4 =new JLabel("Email ID");
      l5 =new JLabel("Gender");
      l6 =new JLabel("User ID");
      l7 =new JLabel("Password");
      l8 = new JLabel("Date of joining");

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

      /*Buttons here*/
      b1 =new JButton("New");
      b2 =new JButton("Create");

      b1.setForeground(Color.white);
      b1.setBackground(Color.blue);

      b2.setForeground(Color.white);
      b2.setBackground(Color.red);
 
      add(b1);
      add(b2);

    // radio buttons
      rb1 =new JRadioButton("Male" ,true);
      rb2 =new JRadioButton("Female");
      
      add(rb1);
      add(rb2);
      bg =new ButtonGroup();
      bg.add(rb1);
      bg.add(rb2);


    /**TextField*/
    t1 =new JTextField(30);
    t2 =new JTextField(30);
    t3 =new JTextField(30);
    t4 =new JTextField(30);
    t5 =new JTextField(30);
    t6 =new JTextField(30);
    t7 =new JTextField(30);

    t1.setFont(new Font("Arial" ,Font.BOLD ,15));
    t2.setFont(new Font("Arial" ,Font.BOLD ,15));
    t3.setFont(new Font("Arial" ,Font.BOLD ,15));
    t4.setFont(new Font("Arial" ,Font.BOLD ,15));
    t5.setFont(new Font("Arial" ,Font.BOLD ,15));
    t6.setFont(new Font("Arial" ,Font.BOLD ,15));
    t7.setFont(new Font("Arial" ,Font.BOLD ,15));


    add(t1);
    add(t2);
    add(t3);
    add(t4);
    add(t5);
    add(t6);
    add(t7);


      // b1.setBounds(40,520,70,25);
      // b2.setBounds(150,520,70,25);
      // b3.setBounds(260,520,70,25);
      // b4.setBounds(370,520,70,25);
      // b5.setBounds(350,560,90,25);
      l1.setBounds(440,100,250,30);
      l2.setBounds(440,150,250,30);
      l3.setBounds(440,200,250,30);
      l4.setBounds(440,250,250,30);
      l5.setBounds(440,300,250,30);
      l6.setBounds(440,350,250,30);
      l7.setBounds(440,400,250,30);
      l8.setBounds(440,450,250,30);

      t1.setBounds(680,100,200,30);
      t2.setBounds(680,150,200,30);
      t3.setBounds(680,200,200,30);
      t4.setBounds(680,250,200,30);
      rb1.setBounds(680,300,90,30);
      rb2.setBounds(770,300,100,30);
      t5.setBounds(680,350,200,30);
      t6.setBounds(680,400,200,30);
      t7.setBounds(680,450,200,30);

      b1.setBounds(560,550,100,30);
      b2.setBounds(680,550,100,30);

      b1.setFont(new Font("Arial",Font.BOLD,15));
      b2.setFont(new Font("Arial",Font.BOLD,15));

      b1.addActionListener(this);
      b2.addActionListener(this);
      t1.setEditable(false);
      t2.setEditable(false);
      t3.setEditable(false);
      t4.setEditable(false);
      t5.setEditable(false);
      t6.setEditable(false);
      t7.setEditable(false);
      b2.setEnabled(false);


      int a = r.nextInt(255);
      int b = r.nextInt(255);
      int c = r.nextInt(255);
      int d = r.nextInt(255);

      //connection WHERE
      try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        con =DriverManager.getConnection("jdbc:mysql://localhost/FlightReservation","root","");
        stmt = con.createStatement();

      }catch(Exception e){
           JOptionPane.showMessageDialog(this,"Unfortunately, app is workingly stopped");
      }

      t4.addFocusListener(this);
      ImageIcon ii = new ImageIcon("airplan2.jpeg");
          lb = new JLabel(ii);
          add(lb);
          lb.setBounds(0,0,1366,750);

      //setVisible(true);
  }

  public void focusGained(FocusEvent e){
       
  }
  public void focusLost(FocusEvent e){
       String emailid = t4.getText();
       int index = emailid.indexOf('@');
       String userid = emailid.substring(0,index);
       t5.setText(userid);
       t6.setText(temp);
  }

public void actionPerformed(ActionEvent e)
{
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
       rb1.setSelected(true);
       t1.requestFocus(true);
        String p = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        temp="";
      for(int i=0;i<5;i++){
        temp+=p.charAt(r.nextInt(61));
      }
       Calendar d2 = Calendar.getInstance();
       s1 = format(String.valueOf(d2.get(Calendar.DATE)))+"-"+format(String.valueOf(d2.get(Calendar.MONTH)+1))+"-"+String.valueOf(d2.get(Calendar.YEAR));
       t7.setText(s1);
  }
  if(e.getSource()==b2){

       if(t1.getText().trim().length()==0 || t2.getText().trim().length()==0 || t3.getText().trim().length()==0 || t4.getText().trim().length()==0 || t5.getText().trim().length()==0 || t6.getText().trim().length()==0){
         JOptionPane.showMessageDialog(this,"Fields can not be empty");
       }
       else{
        if(!validation.checkname(t1.getText())){
          JOptionPane.showMessageDialog(this,"Name should consists of alphabets only");
        }
        else{
          if(!validation.validaddress(t2.getText())){
            JOptionPane.showMessageDialog(this,"Enter valid address");
          }
          else{
          if(!validation.checkcontact(t3.getText())){
           JOptionPane.showMessageDialog(this,"Contact number should be in 10 digits and consists of decimal numbers only");
          }
          else{
            if(!validation.checkemail(t4.getText())){
               JOptionPane.showMessageDialog(this,"Enter a valid e-mail");
            }
            else{
              d1 = sdf1.parse(s1);   
        String doj = sdf2.format(d1);
        String gen = "";
           if(rb1.isSelected()){
            gen = "male";
           }
           else{
            gen = "female";
          }
        String s2 = "insert into employee values('"+t1.getText()+"','"+t2.getText()+"','"+t3.getText()+"','"+t4.getText()+"','"+gen+"','"+t5.getText()+"','"+t6.getText()+"','"+doj+"')";
        stmt.executeUpdate(s2);
        JOptionPane.showMessageDialog(this,"Created successfully");
        b2.setEnabled(false);
            }
          }
        }

        }
        
        
       }
  }
  }
  catch(Exception ex){
    JOptionPane.showMessageDialog(this,"Unfortunately, app is workingly stopped");
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
