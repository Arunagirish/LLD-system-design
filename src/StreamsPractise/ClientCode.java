package StreamsPractise;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ClientCode extends CopyOnWriteArrayList
{
    public static void main( String[] args )
    {
        Employee emp1 = new Employee(1, "Promise", "IT", 40.0);
        Employee emp2 = new Employee(2, "John", "HR", 70.0);
        Employee emp3 = new Employee(3, "Peter", "Facility", 70.0);
        Employee emp4 = new Employee(4, "Tayo", "Facility", 30.0);
        List<Employee> employees = Arrays.asList(emp1, emp2, emp3, emp4);
    }
}
