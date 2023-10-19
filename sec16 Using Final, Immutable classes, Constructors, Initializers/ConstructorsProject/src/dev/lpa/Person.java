package dev.lpa;

public record Person(String name, String dob) {
//    public Person(String name, String dob) {
//        this.name = name;
//        this.dob = dob.replace('-', '/');
//    }

    public Person(Person p) {
        this(p.name, p.dob);
    }


    public Person {
        if(dob == null) throw new IllegalArgumentException("Bad data");
        dob = dob.replace("-", "/"); // this dob is accessing colonical constructor dob

//        this.dob = dob; // this is accessing instance field which will be error -> final
    }
}
