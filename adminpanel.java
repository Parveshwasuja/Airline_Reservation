import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;


class adminpanel extends JFrame implements ActionListener{

    Container c= getContentPane();
    JMenu m1 , m2 , m3 , m4 ,m5 ,m6;
    JMenuItem i1 ,i2 ,i3, i4,i5,i6,i7,i8,i9,i10,i11,i12;
    JRadioButtonMenuItem r1 ,r2 ,r3, r4,r5,r6,r7,r8;
    JMenuBar mb;
    JDesktopPane pane = new JDesktopPane();
    adminpanel()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        mb =new JMenuBar();
        mb.setBackground(Color.white);
        m1 =new JMenu("User");
        m2 =new JMenu("Master Entries");
        m3 =new JMenu("Views");
        m4 =new JMenu("Exit");

        i1  =new JMenuItem("Create New User");
        i2  =new JMenuItem("Drop User");
        i3  =new JMenuItem("Change Password");

        i4  =new JMenuItem("Flight Master");
        i5  =new JMenuItem("Route Master");
        i6  =new JMenuItem("Assign Routes");
        i7  =new JMenuItem("Time Table");
        i8  =new JMenuItem("Booking Master");

        i9  =new JMenuItem("Fligth All details");
        i10 =new JMenuItem("Date wise Booking");
        i11 =new JMenuItem("Tickets");
        i12 = new JMenuItem("Log out");


        i1.addActionListener(this);
        i2.addActionListener(this);
        i3.addActionListener(this);
        i4.addActionListener(this);
        i5.addActionListener(this);
        i6.addActionListener(this);
        i7.addActionListener(this);
        i8.addActionListener(this);
        i9.addActionListener(this);
        i10.addActionListener(this);
        i11.addActionListener(this);
        i12.addActionListener(this);
        setSize(1366,768);
        setTitle("Admin Panel");

         setContentPane(pane);
          // ADDING ITEMS I1-I4 TO m1
          m1.add(i1);
          m1.add(i2);
          m1.add(i3);
          m2.add(i4);
          m2.add(i5);
          m2.add(i6);
          m2.add(i7);
          m2.add(i8);

          m3.add(i9);
          m3.add(i10);
          m3.add(i11);
          m4.add(i12);

          m1.setFont(new Font("Arial",Font.PLAIN,15));
          m2.setFont(new Font("Arial",Font.PLAIN,15));
          m3.setFont(new Font("Arial",Font.PLAIN,15));
          m4.setFont(new Font("Arial",Font.PLAIN,15));

          


          //ADDING ALL m1 , m2 , m5 ,m6 to mb
          mb.add(m1);
          mb.add(m2);
          mb.add(m3);
          mb.add(m4);
          setJMenuBar(mb);

          mb.add(Box.createRigidArea(new Dimension(100,30)));
          setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
      if(e.getSource()==i1){
       createemployee obj =  new createemployee();
       obj.show();
       try{
         obj.setMaximum(true);
       }
       catch(Exception ex){
           
       }
       pane.add(obj);
      }
      if(e.getSource()==i2){
        dropemployee obj1 = new dropemployee();
        obj1.show();
        try{
         obj1.setMaximum(true);
       }
       catch(Exception ex){
           
       }
       pane.add(obj1);
      }
      if(e.getSource()==i3){

        adminpassword obj2 = new adminpassword();
        obj2.show();
        try{
         obj2.setMaximum(true);
       }
       catch(Exception ex){
           
       }
       pane.add(obj2);
      }
      if(e.getSource()==i4){
       flightmaster obj3 =  new flightmaster();
       obj3.show();
       try{
         obj3.setMaximum(true);
       }
       catch(Exception ex){
           
       }
       pane.add(obj3);

      }
      if(e.getSource()==i5){
       routeset obj4 =  new routeset();
       obj4.show();
       try{
         obj4.setMaximum(true);
       }
       catch(Exception ex){
           
       }
       pane.add(obj4);

      }
      if(e.getSource()==i6){
        routemaster obj5 =  new routemaster();
        obj5.show();
        try{
         obj5.setMaximum(true);
       }
       catch(Exception ex){
           
       }
       pane.add(obj5);
      }
      if(e.getSource()==i7){
        timmingmaster obj6 = new timmingmaster();
        obj6.show();
         try{
         obj6.setMaximum(true);
       }
       catch(Exception ex){
           
       }
       pane.add(obj6);
      }
      if(e.getSource()==i8){
       booking obj7 =  new booking(pane);
       obj7.show();
        try{
         obj7.setMaximum(true);
       }
       catch(Exception ex){
           
       }
       pane.add(obj7);
      }
      if(e.getSource()==i9){
        flightalldetails obj8 = new flightalldetails();
        obj8.show();
        try{
         obj8.setMaximum(true);
       }
       catch(Exception ex){
           
       }
       pane.add(obj8);
      }
      if(e.getSource()==i10){
        datewiseflights obj9 = new datewiseflights();
        obj9.show();
        try{
         obj9.setMaximum(true);
       }
       catch(Exception ex){
           
       }
       pane.add(obj9);
      }
      if(e.getSource()==i11){
        aircodedatewiseflights obj10 =  new aircodedatewiseflights();
        obj10.show();
       try{
         obj10.setMaximum(true);
       }
       catch(Exception ex){
           
       }
       pane.add(obj10);
      }
      if(e.getSource()==i12){
        new welcome();
        this.dispose();
        
      }
    }


  public static void main(String[] args) {
    new adminpanel();
  }
}
