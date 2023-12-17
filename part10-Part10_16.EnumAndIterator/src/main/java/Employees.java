/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andre
 */
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class Employees {
    private ArrayList<Person> employees;

    public Employees() {
        this.employees = new ArrayList<>();
    }
    
    public void add(Person personToAdd) {
        this.employees.add(personToAdd);
    }
    
    public void add(List<Person> peopleToAdd) {
        peopleToAdd.forEach(employees::add);
    }
    
    public void print() {
        this.employees.forEach(System.out::println);
    }
    
    public void print(Education education) {
        Iterator<Person> iterator = employees.iterator();
        while(iterator.hasNext()) {
            Person next = iterator.next();
            if (next.getEducation() == education) {
                System.out.println(next);
            }
        }
    }
    
    public void fire(Education education) {
        Iterator<Person> iterator = employees.iterator();
        while(iterator.hasNext()) {
            if (iterator.next().getEducation() == education) {
                iterator.remove();
            }
        }
    }

}
