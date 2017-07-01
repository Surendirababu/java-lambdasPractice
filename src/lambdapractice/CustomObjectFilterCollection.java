package lambdapractice;

import model.Employee;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Created by Surendirababu Janarthanan on 7/1/2017.
 */
public class CustomObjectFilterCollection {

    public static void main(String a[]) throws ParseException {

        SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");

        Employee emp3 = new Employee(3,"chetan",sf.parse("28/06/1990"),"spk@gmail.com","mumbai");
        Employee emp1 = new Employee(1,"babu",sf.parse("28/03/1991"),"bab@gmail.com","Salem");
        Employee emp2 = new Employee(2,"suren",sf.parse("28/05/1990"),"basds@gmail.com","kochi");
        Employee emp4 = new Employee(4,"bhagat",sf.parse("28/07/1990"),"lmer@gmail.com","Salem");

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);
        employeeList.add(emp4);


        //Filter the list by the matching Employee Address
        List<Employee> filteredList = employeeList.stream().filter(input -> input.getAddress().equalsIgnoreCase("Salem")).collect(Collectors.toList());
        //Print the address
        filteredList.stream().forEach(input -> System.out.println("EmpId"+ input.getId()+"EmpName"+input.getName()));

    }
}
