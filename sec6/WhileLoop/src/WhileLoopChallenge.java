public class WhileLoopChallenge {
    public static void main(String[] args) {
int count = 5;
int evenNumber = 0;
int oddNumber = 0;
while(count <= 20){
//    if(isEvenNumber(count)){
//        System.out.println("Event number " + count);
//    }
    count++;
    if(!isEvenNumber(count)){
        oddNumber++;
        continue;
    }
    if(evenNumber == 5){
        break;
    }
    System.out.println("Even number " + count);
    evenNumber++;
}
        System.out.println("Odd number " + oddNumber);
        System.out.println("Even number " + evenNumber);
    }
    public static boolean isEvenNumber (int num){
        return num %2 == 0;
    }
}
