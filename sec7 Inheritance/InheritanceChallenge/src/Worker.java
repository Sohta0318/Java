public class Worker {
    private String name;
    private String birthDate;
    private String endDate;
    Worker(String name, String birthDate){
        this.name = name;
        this.birthDate = birthDate;
    }
    public int getAge(){
        return 2022 - Integer.parseInt(birthDate.substring(6));
    }

    public double collectPay(){
        return 0.0;
    }
    public void terminate(String endDate){
this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
