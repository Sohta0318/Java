public class LeapYear {
    public static void main(String[] args) {

    }

    public static boolean isLeapYear (int year) {
        if (year >= 1 && year <= 9999) {
int evenFour = year % 4;
if(evenFour == 0){
    int evenHund = year % 100;
    if(evenHund == 0){
int evenFourHund = year % 400;
if(evenFourHund == 0){
    return true;
}
    }else {
return true;
    }
}else {
return false;
}
        }
        return false;
    }
}
