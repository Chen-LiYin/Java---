
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Image;

import java.text.SimpleDateFormat;   
import java.util.Date;  

      

public class LoginFrame extends JFrame {
	JButton button = new JButton ((Morning()) ? "Morning Time": "All Day Menu");
	
	class LoginOKAction implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			new maintop();

			setVisible(false);
		}

        }
        public LoginFrame(){
		super();
                int width=120,height=100;
                JLabel jlb=new JLabel();
                
                ImageIcon image=new ImageIcon("image/66.jpg");
                image.setImage(image.getImage().getScaledInstance(width,height,Image.SCALE_DEFAULT));
                Image img =image.getImage();
                img=img.getScaledInstance(width,height,Image.SCALE_DEFAULT);
                image.setImage(img);
                jlb.setIcon(image);
                
                this.add(jlb);
                jlb.setSize(width,height);	
                jlb.setBounds(110,50,170,100);  //(int x,int y,int width,int height)

                this.setResizable(false);
		this.setSize(new Dimension(350, 400));
		this.setTitle("Fast Food Order");
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocation(350, 200);
                
                JLabel currenttime=new JLabel(getTime_1());
                currenttime.setBounds(120,110,150,150);
                this.add(currenttime);
		this.setVisible(true);
                
		
		this.getContentPane().add(button,null);
		button.setBounds(new Rectangle(120, 200, 100, 30));  //(int x,int y,int width,int height)
		button.addActionListener(new LoginOKAction());

	}
	public static void main(String[] args) {
	       new LoginFrame();
           
	}
	//system time
	public static String getTime_1(){   
        
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss" );   
		Date currentTime = new Date();
		String timeStr = formatter.format(currentTime); 
		return    timeStr;
	}
	//if Moring Time
   	public static boolean Morning() {   
		String Now = getTime_1(); 
		String time= Now.split(" ")[1];
		int h = Integer.parseInt( time.split(":")[0]);
		int m = Integer.parseInt( time.split(":")[1]);
		boolean mor;

		if(h<10 ||(h==10 && m <= 30)){
			mor=true;
		}else{
			mor=false;				
 		}
	return mor;
	}   
 
}
