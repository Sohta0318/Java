package dev.lpa;

import dev.lpa.domain.Employee;
import dev.lpa.domain.EmployeeComparator;
import dev.lpa.domain.StoreEmployee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RunMethods {
    public static void main(String[] args) {
        List<StoreEmployee> storeEmployees = new ArrayList<>(List.of(
                new StoreEmployee(10015, "Meg", 2019, "Target"),
                new StoreEmployee(10515, "Joe", 2021, "Walmart"),
                new StoreEmployee(10105, "Tom", 2020, "Macys"),
                new StoreEmployee(10215, "Marty", 2018, "Walmart"),
                new StoreEmployee(10322, "Bud", 2016, "Target")
        ));

        var c0 = new EmployeeComparator<StoreEmployee>();
        var c1 = new Employee.EmployeeComparator<StoreEmployee>();
        var c2 = new StoreEmployee().new StoreComparatoe<StoreEmployee>();

        // Using local class
        class NameSort<T> implements Comparator<StoreEmployee>{

            @Override
            public int compare(StoreEmployee o1, StoreEmployee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        }

        var c3 = new NameSort<StoreEmployee>();

        // Using Anonymous class
        var c4 = new Comparator<StoreEmployee>(){
            @Override
            public int compare(StoreEmployee o1, StoreEmployee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        sortInt(storeEmployees, c0);
        sortInt(storeEmployees, c1);
        sortInt(storeEmployees, c2);
        sortInt(storeEmployees, c3);
        sortInt(storeEmployees, c4);
        sortInt(storeEmployees, (o1, o2) -> o1.getName().compareTo(o2.getName()));
    }

    public static <T> void sortInt(List<T> list, Comparator<? super T> comparator){
        System.out.println("Sorting with Comparator: " + comparator.toString());
        list.sort(comparator);
        for(var employee :list) {
            System.out.println(employee);
        }
    }
}
