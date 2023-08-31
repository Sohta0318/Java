public class Printer {
    private int toneLever;
    private int pagesPrinted;
    private boolean duplex;

    public Printer(int toneLever, boolean duplex) {
        this.pagesPrinted = 0;
        this.toneLever = toneLever <= 100 && toneLever >= 0 ? toneLever : -1;
        this.duplex = duplex;
    }

    public int addToner(int tonerAmount){
        int tempAmount = toneLever + tonerAmount;
        if(tempAmount > 100 || tempAmount < 0){
            return -1;
        }
        toneLever += tonerAmount;
        return toneLever;
    }
    public int printPages(int pages){
        int jobPages = duplex ? pages / 2 + pages % 2 : pages;
        pagesPrinted += jobPages;
        return pagesPrinted;
    }

    public int getPagesPrinted() {
        return pagesPrinted;
    }
}
