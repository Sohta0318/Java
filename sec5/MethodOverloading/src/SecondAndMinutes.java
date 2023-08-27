public class SecondAndMinutes {
    public static void main(String[] args) {
        String time = getDurationString(3945);
        System.out.println(time);
        String time2 = getDurationString(70, 20);
        System.out.println(time2);
    }
    public static String getDurationString(int seconds){
        if(seconds < 0){
            return "Invalid seconds";
        }
//        int hours = seconds / 3600;
//        int minutes = (seconds % 3600) / 60;
//        int second = (seconds % 3600) % 60;
        //         return (hours + "h " + minutes + "m "+ second + "s");
        int minutes = seconds / 60;
        int second = seconds % 60;
        return getDurationString(minutes, second);
    }

    public static String getDurationString(int minutes, int seconds){
if(minutes < 0 || seconds < 0 || seconds > 59){
return "Invalid minutes or seconds";
}
int hours = minutes / 60;
int minute = minutes % 60;
        return hours + "h " + minute + "m " + seconds + "s";
    }
}
