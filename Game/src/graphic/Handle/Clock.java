package graphic.Handle;

public class Clock {
    private static int hour = 8, minute = 0, date = 0;

    public static int[] stepForward() {
        minute++;
        if (minute == 60) {
            minute = 0;
            hour++;
            if (hour == 24) {
                hour = 0;
                date++;
            }
        }
        return new int[]{hour, minute, date};
    }

    public static int getHour() {
        return hour;
    }

    public static int getMinute() {
        return minute;
    }

    public static int getDate() {
        return date;
    }

    public Clock(int hour, int minute, int date) {
        Clock.hour = hour;
        Clock.minute = minute;
        Clock.date = date;
    }
}
