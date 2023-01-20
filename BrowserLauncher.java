import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.Desktop;
import java.awt.event.*;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

public class BrowserLauncher extends JPanel implements ActionListener{
  private JFrame mainFrame;
  private JLabel clockdispay;
  private AlarmClock alarmclock;
  private JLabel alarmTime;
  private JButton launchButton;
  private JButton setAlarmButton;
  private JTextField inputTime;

  public BrowserLauncher(){
    JPanel mainPanel = new JPanel();
    JPanel clockPanel = new JPanel();
    launchButton = new JButton("Launch Browser");
    setAlarmButton = new JButton("アラーム");
    inputTime = new JTextField(10);
    alarmTime = new JLabel();
    clockdispay = new JLabel();
    mainFrame = new JFrame();
    alarmclock = new AlarmClock();
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    launchButton.addActionListener(this);
    setAlarmButton.addActionListener(this);
    mainPanel.setLayout(new FlowLayout());
    mainPanel.add(launchButton);
    clockPanel.add(clockdispay);
    clockPanel.add(inputTime);
    clockPanel.add(alarmTime);
    clockPanel.add(setAlarmButton);
    mainFrame.getContentPane().add(mainPanel);
    mainPanel.add(clockPanel);
    mainFrame.setAlwaysOnTop(true);
  }
  
  public void start(){
    Timer timer = new Timer();
    timer.scheduleAtFixedRate(new TimerTask(){
      public void run(){
        clockdispay.setText(alarmclock.getTimeStr());
      }
    },0,1000);
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
    Object obj = e.getSource();
    if(obj == launchButton){
      openURL("http://turedurenaru.com");
    }else if(obj == setAlarmButton){
      alarmTime.setText(alarmclock.getAlarmTimeStr(Integer.parseInt(inputTime.getText())));
    }
  }

  public void showTime(String str){
    clockdispay.setText(str);
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
