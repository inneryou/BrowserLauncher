import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.Desktop;
import java.awt.event.*;
import java.net.URL;

public class BrowserLauncher extends JPanel implements ActionListener{
  
  JFrame mainFrame = new JFrame();
  JButton launchButton = new JButton("Launch Browser");
  JPanel mainPanel = new JPanel();
  
  public BrowserLauncher(){
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    launchButton.addActionListener(this);
    mainPanel.setLayout(new FlowLayout());
    mainPanel.add(launchButton);
    mainFrame.getContentPane().add(mainPanel);
    mainFrame.setAlwaysOnTop(true);
  }
  
  public void setShow(){
    mainFrame.setVisible(true);
  }

  public void setTitle(String str){
    mainFrame.setTitle(str);
  }

  public void setBounds(int x,int y, int width, int height){
    mainFrame.setBounds(x,y,width,height);
  }

  public void setSize(int x,int y){
    mainFrame.setSize(x,y);
  }

  public void actionPerformed(ActionEvent e){
    openURL("http://turedurenaru.com");
  }
  public void openURL(String strUrl){
    try{
      URL url = new URL(strUrl);
      Desktop.getDesktop().browse(url.toURI());
    }catch(Exception e){
      e.printStackTrace();
    }
  }
}
