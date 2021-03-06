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
public class CustomObjectSorting {

    public static void main(String a[]) throws ParseException {

        SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");

        Employee emp3 = new Employee(3,"chetan",sf.parse("28/06/1990"),"spk@gmail.com","mumbai");
        Employee emp1 = new Employee(11,"babu",sf.parse("28/03/1991"),"bab@gmail.com","Salem");
        Employee emp2 = new Employee(2,"suren",sf.parse("28/05/1990"),"basds@gmail.com","kochi");
        Employee emp4 = new Employee(4,"bhagat",sf.parse("28/07/1990"),"lmer@gmail.com","Salem");

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);
        employeeList.add(emp4);

        //Sort By DOB
        TreeSet<Employee> employeeTreeSetSortByDOB = new TreeSet<>((o1, o2) -> {
            if(o1.getDob().after(o2.getDob()))
                return 1;
            else if (o1.getDob().before(o2.getDob()))
                return -1;
            else return 0;
        });
        //Add the Collection to the TreeSet Object to perform sorting
        employeeTreeSetSortByDOB.addAll(employeeList);
        //Print the list
        System.out.println("Employee Sort by DOB");
        employeeTreeSetSortByDOB.stream().forEach(input -> System.out.println("EmpId"+ input.getId()+ " "+"EmpName"+input.getName()));

        System.out.println();
        //Sort By ID-Desc Order
        TreeSet<Employee> employeeTreeSetSortById = new TreeSet<>((o1, o2) -> o2.getId() - o1.getId());
        employeeTreeSetSortById.addAll(employeeList);
        System.out.println("Employee Sort by Id");
        employeeTreeSetSortById.stream().forEach(input -> System.out.println("EmpId"+ input.getId()+" "+"EmpName"+input.getName()));

        System.out.println();

        //Sort By Name
        TreeSet<Employee> employeeTreeSetSortByName = new TreeSet<>((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
        employeeTreeSetSortByName.addAll(employeeList);
        System.out.println("Employee Sort by Name");
        employeeTreeSetSortByName.stream().forEach(input -> System.out.println("EmpId"+ input.getId()+" "+"EmpName"+input.getName()));

    }
}
