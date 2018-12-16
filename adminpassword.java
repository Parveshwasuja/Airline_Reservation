import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;


public class adminpassword extends JInternalFrame implements ActionListener{
  Container c1 = getContentPane();
  JButton bt;
  Connection con;
  Statement st;
  JPanel pn ,pn1;
  JPasswordField op1 ,np1,np2;
  JLabel lb1 ,lb2 ,lb3,lb4;
  String user="";
adminpassword(){
  super("Change Password",true,true,true,true);
  setSize(1366,712);
  //setTitle("Change Password");
  //setVisible(true);

  pn =new JPanel();
  lb4 =new JLabel("Admin Chage Password");
  lb4.setFont(new Font("Arial" ,Font.BOLD ,20));
  lb4.setForeground(Color.white);
  pn.setBackground(Color.black);
  pn.add(lb4);
  add(pn ,"North");

  pn1 =new JPanel();
  pn1.setLayout(null);
  bt = new JButton("Change");
  op1 =new JPasswordField(30);
  np1 =new JPasswordField(30);
  np2 =new JPasswordField(30);
  lb1 =new JLabel("Old Password");
  lb2 =new JLabel("New Password");
  lb3 =new JLabel("Confirm New Password");
  pn1.add(bt);
  pn1.add(op1);
  pn1.add(np1);
  pn1.add(np2);
  pn1.add(lb1);
  pn1.add(lb2);
  pn1.add(lb3);
  pn1.setBackground(Color.white);
  add(pn1,"Center");


  c1.setBackground(Color.white);
  c1.setForeground(Color.black);
  bt.setFont(new Font("Arial" ,Font.BOLD ,20));
  bt.setBackground(Color.white);
  lb1.setFont(new Font("Arial" ,Font.BOLD ,20));
  lb2.setFont(new Font("Arial" ,Font.BOLD ,20));
  lb3.setFont(new Font("Arial" ,Font.BOLD ,20));
  op1.setFont(new Font("Arial" ,Font.BOLD ,18));
  np1.setFont(new Font("Arial" ,Font.BOLD ,18));
  np2.setFont(new Font("Arial" ,Font.BOLD ,18));
// bounds       x   y w h
  lb1.setBounds(430  , 100 ,250 , 30);
  op1.setBounds(680 , 100 ,200 , 30);
  lb2.setBounds(430  , 150 ,250 , 30);
  np1.setBounds(680 , 150 ,200 , 30);
  lb3.setBounds(430  , 200 ,250 , 30);
  np2.setBounds(680 , 200 ,200 , 30);
   bt.setBounds(620 , 250 ,120 , 30);

  bt.addActionListener(this);

  //connection WHERE
  try{
    Class.forName("com.mysql.cj.jdbc.Driver");
    con =DriverManager.getConnection("jdbc:mysql://localhost/FlightReservation","root","");
    st = con.createStatement();
  }catch(Exception e){
      JOptionPane.showMessageDialog(this,"Unfortunately, app is workingly stopped");
  }
}


public void actionPerformed(ActionEvent e)
{
      try
      {
          if(e.getSource()==bt)
          {
              // verify the password
              String verify ="SELECT * FROM admin WHERE username ='admin' AND password ='"+op1.getText()+"'";
             
              ResultSet rs =st.executeQuery(verify);
              if(rs.next())
              {
                  if(np1.getText().equals(np2.getText()))
                  {
                      if(!np1.getText().equals(op1.getText()))
                      {
                        if(validation.password(np1.getText())){


                          String update ="UPDATE admin set password='"+np1.getText()+"' WHERE username ='admin'";
                          
                          st.executeUpdate(update);
                          JOptionPane.showMessageDialog(this ,"Password Changed successfully");
                        }
                        else{
                          JOptionPane.showMessageDialog(this ,"Password must be between 5 and 20 character and should consists of one decimal number or more and alphabets");
                        }
                      }
                      else
                      {
                        JOptionPane.showMessageDialog(this ,"New Password Must be Different");
                      }
                  }
                  else
                  {
                      JOptionPane.showMessageDialog(this ,"Password Does Not Match");
                  }
              }
              else
              {
                JOptionPane.showMessageDialog(this ,"Wrong Password");
              }
          }
      }
      catch(Exception ex)
      {
        JOptionPane.showMessageDialog(this,"Unfortunately, app is workingly stopped");
      }
}

}
