import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

public class BrowserLauncher extends JPanel implements ActionListener {
    private JFrame mainFrame;
    private JLabel clockDisplay;
    private JLabel alarmTime;
    private JButton launchButton;
    private JButton setAlarmButton;
    private JTextField inputTime;
    private AlarmClock alarmclock;

    public BrowserLauncher() {
        alarmclock = new AlarmClock();

        // Main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());

        // Clock panel
        JPanel clockPanel = new JPanel();

        // Components
        launchButton = new JButton("Launch Browser");
        setAlarmButton = new JButton("Set Alarm");
        inputTime = new JTextField(10);
        alarmTime = new JLabel();
        clockDisplay = new JLabel();
        mainFrame = new JFrame();

        // Add action listeners to buttons
        launchButton.addActionListener(this);
        setAlarmButton.addActionListener(this);

        // Add components to panels
        mainPanel.add(launchButton);
        clockPanel.add(clockDisplay);
        clockPanel.add(inputTime);
        clockPanel.add(alarmTime);
        clockPanel.add(setAlarmButton);

        // Add panels to main frame
        mainFrame.getContentPane().add(mainPanel);
        mainPanel.add(clockPanel);

        // Set frame properties
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setAlwaysOnTop(true);
    }

    public void start() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask(){
            public void run(){
                clockDisplay.setText(alarmclock.getTimeStr());
            }
        },0,1000);
    }

    public void setShow() {
        mainFrame.setVisible(true);
    }

    public void setTitle(String str) {
        mainFrame.setTitle(str);
    }

    public void setBounds(int x, int y, int width, int height) {
        mainFrame.setBounds(x, y, width, height);
    }

    public void setSize(int x, int y) {
        mainFrame.setSize(x, y);
    }

    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == launchButton) {
            openURL("http://turedurenaru.com");
        } else if(obj == setAlarmButton) {
            alarmTime.setText(alarmclock.getAlarmTimeStr(Integer.parseInt(inputTime.getText())));
        }
    }

    public void openURL(String strUrl) {
        try {
            URL url = new URL(strUrl);
            Desktop.getDesktop().browse(url.toURI());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
