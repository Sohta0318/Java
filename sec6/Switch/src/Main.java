public class Main {
    public static void main(String[] args) {
//        int value = 1;
//        if(value == 1){
//            System.out.println("Value was 1");
//        } else if (value == 2) {
//            System.out.println("Value was 2");
//        }else{
//            System.out.println("Value was not 1 or 2");
//        }
        int switchValue = 1;
//        switch (switchValue) {
//            case 1:
//                System.out.println("Value was 1");
//                break;
//            case 2:
//                System.out.println("Value was 2");
//                break;
//            case 3: case 4: case 5:
//                System.out.println("Value was 3 or 4 or 5");
//                break;
//            default:
//                System.out.println("Value was not 1 or 2 or 3 or 4 or 5");
//        }
        switch(switchValue){
            case 1 -> System.out.println("Value was 1");
            case 2 -> System.out.println("Value was 2");
            case 3, 4,5 ->{
                System.out.println("Value was 3 or 4 or 5");
                System.out.println("Value was " + switchValue);
            }
            default -> System.out.println("Value was not 1,2,3,4,5");
        }

        String month = "APRIL";
        System.out.println(month + " is in the " + getQuarters(month) + " quarter");

    }

    public static String getQuarters(String month){
        return switch (month) {
            case "JANUARY", "FEBRUARY", "MARCH" -> {
                yield "1st";
            }
            case "APRIL", "MAY", "JUNE" -> "2nd";
            case "JULY", "AUGUST", "SEPTEMBER" -> "3rd";
            case "OCTOBER", "NOVEMBER", "DECEMBER" -> "4th";
            default -> {
                String badMonth = month + " is bad";
                yield badMonth;
            }
        };
    }


}
