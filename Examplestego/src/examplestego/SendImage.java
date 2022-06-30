/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examplestego;

/**
 *
 * @author cbibe
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.math.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.event.*;
import javax.swing.filechooser.*;
import java.beans.*;
import java.awt.event.ActionListener;
import java.sql.*;
import java.lang.*;
import java.awt.event.ActionEvent;
import java.awt.font.*;
import java.lang.String;
import java.awt.Component;
import java.awt.geom.*;
import javax.swing.text.EditorKit;
import javax.swing.event.MouseInputAdapter;
import java.awt.image.BufferedImage;
import javax.swing.text.*;
import javax.crypto.Cipher;
import java.security.*;
import java.lang.Exception;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.Serializable;
import java.util.Random;
import java.io.FilterInputStream;
import javax.crypto.*;
import java.math.BigInteger;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStream;
import javax.crypto.spec.*;
import java.security.spec.*;
import java.applet.*;
import java.net.*;
import java.net.SocketException;
import java.net.BindException;

public class SendImage extends JFrame implements ActionListener,Runnable{
    JLabel label1;
    JLabel label2;
    JTextField textfield1;
    JButton button1;
    JButton button2;
    JButton button3;
    JFileChooser filechooser;
    File f,tempfilename,Ofilename,Sfilename;
    InputStream ins;
    OutputStream outs;
    InetAddress ipaddress;
    String address,name;
    int Copened; 
    Thread t;

    public SendImage() {
        SendImageLayout customLayout = new SendImageLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        label1 = new JLabel("Note :: Select only image files like .jpg, .bmp, .gif");
        getContentPane().add(label1);
        label1.setVisible(false);
        label1.setFont(new Font("Century",Font.BOLD,18));

        label2 = new JLabel("IMAGE");
        getContentPane().add(label2);
        label2.setFont(new Font("Garamond",Font.BOLD,18));

        textfield1 = new JTextField();
        getContentPane().add(textfield1);
        textfield1.setFont(new Font("Century",Font.BOLD,15));
        textfield1.setEditable(false);
        textfield1.setBackground(Color.LIGHT_GRAY);
        textfield1.setToolTipText("Choose the encrypted image file");

        button1 = new JButton("BROWSE");
        getContentPane().add(button1);
        button1.setFocusable(true);
        button1.addActionListener(this);
        button1.setRolloverEnabled(true);
        button1.setContentAreaFilled(true);
		button1.setBorderPainted(true);
        button1.setVerifyInputWhenFocusTarget(true);
        button1.setFont(new Font("Garamond", Font.BOLD, 16));

        button2 = new JButton("CANCEL");
        getContentPane().add(button2);
        button2.setFocusable(true);
        button2.addActionListener(this);
        button2.setRolloverEnabled(true);
        button2.setContentAreaFilled(true);
		button2.setBorderPainted(true);
		button2.setToolTipText("Cancels the current operation and returns to the main menu");
        button2.setVerifyInputWhenFocusTarget(true);
        button2.setFont(new Font("Garamond", Font.BOLD, 16));

        button3 = new JButton("SEND");
        getContentPane().add(button3);
        button3.setFocusable(true);
        button3.addActionListener(this);
        button3.setRolloverEnabled(true);
        button3.setContentAreaFilled(true);
		button3.setBorderPainted(true);
        button3.setVerifyInputWhenFocusTarget(true);
        button3.setFont(new Font("Garamond", Font.BOLD, 16));
        
        
        t=new Thread(this);
        t.start();
        
        filechooser=new JFileChooser();
        filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        setSize(getPreferredSize());

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
  public void run()
   {
    try
     {
      recv r=new recv();
     }
    catch(Exception e)
     {
      System.out.println(e);
     }
   }
  
public static void main(String args[]) {
        SendImage si = new SendImage();

        si.setTitle("Upload encrypted image");
        si.pack();
        si.show();
        
        JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		try
		{
		
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		//javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
		}
		catch (Exception ex)
		{
			System.out.println("Failed loading L&F: ");
			System.out.println(ex);
		}
    }    
    
    
public void actionPerformed(ActionEvent e)
    {
       try
    {
       
       String cmd;
       cmd = e.getActionCommand();
	       
	        
    if(cmd.equals("CANCEL"))
    {  
      dispose();
      Stegno s = new Stegno();
      s.show();
      s.pack();
      s.setTitle("Main Menu - Implementation of Steganography");
    }
    if(cmd.equals("BROWSE"))
    {
    	int r=filechooser.showOpenDialog(this);
     tempfilename=filechooser.getSelectedFile(); //File type
     
      if(r==JFileChooser.CANCEL_OPTION)
       JOptionPane.showMessageDialog(this,"FileNotSelected","Error",JOptionPane.ERROR_MESSAGE);
      else
       {
       String name=tempfilename.getName();

        if((!name.endsWith(".jpg")) && !name.endsWith(".gif") && !name.endsWith(".bmp")&& !name.endsWith(".jpeg"))  

          JOptionPane.showMessageDialog(this,"Select Only Image file","Error",JOptionPane.ERROR_MESSAGE);

        else
          {
            Copened=1;
            Ofilename=tempfilename;
            textfield1.setText(name);
            textfield1.setText(tempfilename.getPath());
            textfield1.setFont(new Font("Century",Font.PLAIN,15));
            textfield1.setBackground(Color.LIGHT_GRAY);
            textfield1.setEditable(false);
           }
          }
          }

if(cmd.equals("SEND"))
     {
        address=JOptionPane.showInputDialog("Enter The IP Address of Destination");
        ipaddress=InetAddress.getByName(address);
        Socket socket=new Socket(ipaddress,6000);
        DataOutputStream out=new DataOutputStream(socket.getOutputStream());
        FileInputStream in=new FileInputStream(Ofilename);
        while(true)
         {
          int i=in.read();
          if(i==-1) break;
          out.write(i);
         }
         in.close();
         out.close();
        }
} // end try
    
     catch(Exception xe)
     {
     	//xe.printStackTrace();
JOptionPane.showMessageDialog(this,xe,"Error",JOptionPane.ERROR_MESSAGE);
     }
}


class recv extends JFrame implements Runnable 
 {
   JFileChooser fc;
   ServerSocket ss;
   Socket s;
   InputStream ins;
   OutputStream out;
   byte b[];
   int len;

  public recv() throws Exception
    {

      b=new byte[100];
      fc=new JFileChooser();
      fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
      ss=new ServerSocket(6000);
      
      torun();
    }
  public void torun() throws Exception
     {
      while(true)
       {
        s=ss.accept();
        ins=s.getInputStream();
        String string="You have received an Image File,Save it";
        JOptionPane.showMessageDialog(this,string,"Information",JOptionPane.INFORMATION_MESSAGE);
        int r=fc.showSaveDialog(this);
        File file=fc.getSelectedFile();
        out=new FileOutputStream(file);
        Thread t=new Thread(this);
        t.start();
       }
    }
   public void run()
    {
      try
        {
         while(true)
          {
           int n=ins.read();
 	   if(n==-1) break;
           out.write(n);
          }
         
         ins.close();
         out.close();
         s.close();
         JOptionPane.showMessageDialog(null,"\nYour encrypted image file has been uploaded successfully\n","message",JOptionPane.INFORMATION_MESSAGE);
        }
      catch(Exception e)
        {
           System.out.println(e);
          //e.printStackTrace();
        }
    } // end of run

 } //end of class
}

class SendImageLayout implements LayoutManager {

    public SendImageLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 579 + insets.left + insets.right;
        dim.height = 188 + insets.top + insets.bottom;

        return dim;
    }

    public Dimension minimumLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);
        return dim;
    }

    public void layoutContainer(Container parent) {
        Insets insets = parent.getInsets();

        Component c;
        c = parent.getComponent(0);
        if (c.isVisible()) {c.setBounds(insets.left+70,insets.top+16,550,34);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+46,insets.top+64,96,32);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+112,insets.top+64,330,32);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+448,insets.top+62,114,35);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+152,insets.top+120,124,38);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+295,insets.top+120,124,38);}
    }
}

