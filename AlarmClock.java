import java.util.Calendar;

public class AlarmClock {

    public String getTimeStr(){
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
        return hour + "時" + minute + "分" + second + "秒";
    }

    public String getAlarmTimeStr(int m){
        String timeStr;
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE,m);
        timeStr = cal.get(Calendar.HOUR_OF_DAY) + "時" + cal.get(Calendar.MINUTE) + "分" + cal.get(Calendar.SECOND) + "秒";
        
        return timeStr;
    }
}
