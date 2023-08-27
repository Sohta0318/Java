public class MegaBytesConverter {
    public static void main(String[] args) {
printMegaBytesAndKiloBytes(2500);
    }
    public static void printMegaBytesAndKiloBytes(int kiloBytes){
        if(kiloBytes < 0){
            System.out.println("Invalid Value");
        }else {
            int mb = 1024;
            int b = Math.round(kiloBytes / mb);
            int rest = kiloBytes % mb;
            System.out.println(kiloBytes + " KB = " + b + " MB and " + rest + " KB");
        }
    }
}
