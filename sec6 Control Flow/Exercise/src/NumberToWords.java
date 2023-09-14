public class NumberToWords {
    public static void main(String[] args) {
//System.out.println(getDigitCount(1));
        numberToWords(123);
    }

    public static void numberToWords(int number){
        if(number < 0){
            System.out.println("Invalid Value");
        }
        int reversed = reverse(number);
        int digits = getDigitCount(number);
        int count = 0;
        while(count < digits){
            int a = reversed % 10;
            String digit = "Zero";
switch(a){
    case 0 : digit = "Zero"; break;
    case 1 : digit ="One"; break;
    case 2 : digit ="Two";break;
    case 3 : digit ="Three";break;
    case 4 : digit ="Four";break;
    case 5 :digit ="Five";break;
    case 6 : digit ="Six";break;
    case 7 : digit ="Seven";break;
    case 8 : digit ="Eight";break;
    case 9 : digit ="Nine";break;
}
System.out.println(digit);
reversed /= 10;
count++;
        }
    }

    public static int reverse(int number){
        int reversed = 0;
        while(number != 0){
            reversed = (reversed * 10) +( number % 10);
            number /= 10;
        }
        return reversed;
    }

    public static int getDigitCount(int number){
        if(number < 0){
            return -1;
        } else if (number == 0) {
            return 1;
        }
        int count = 0;
        while(number > 0){
            number /= 10;
            count++;
        }
        return count;
    }
}
