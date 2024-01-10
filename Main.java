import java.net.SocketOption;
import java.util.*;
abstract class Employee {
     private String name;
     private int id;

     public Employee(String name,int id) {
         this.name = name;
         this.id = id;
     }
     public String getName() {
        return name;
     }
     public int getId(){
         return id;
    }
    public abstract double calculateSalary();

     @Override
    public String toString()
     {
         return "Employee[name="+name+", id="+id+",salary="+calculateSalary()+"]";
     }


}
class FullTimeEmployee extends Employee{
    private double monthlySalary;
    public FullTimeEmployee(String name,int id,double monthlySalary) {
        super(name,id);
        this.monthlySalary=monthlySalary;
    }
    @Override
    public double calculateSalary()
    {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee{
    private int hoursWorked;
    private double hourlyRate;
    public PartTimeEmployee(String name,int id,int hourlyRate,int hoursWorked)
    {
        super(name,id);
        this.hourlyRate=hourlyRate;
        this.hoursWorked=hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate*hoursWorked*30;
    }
}
class PayrollSystem{
    private ArrayList<Employee>employeeList;
    public PayrollSystem()
    {
        employeeList=new ArrayList<>();
    }
    public void addEmployee(Employee employee)
    {
        employeeList.add(employee);
    }
    public void removeEmployee(int id)
    {
        Employee employeeToRemove=null;
        for(Employee employee: employeeList)
        {
            if(employee.getId()==id)
            {
                employeeToRemove=employee;
                break;
            }
        }
        if(employeeToRemove!=null)
        {
            employeeList.remove(employeeToRemove);
        }
    }
    public void displayEmployees()
    {
        for(Employee emp:employeeList)
        {
            System.out.println(emp);
        }
    }


}
public class Main {
    public static void main(String[] args) {
           PayrollSystem payrollsystem=new PayrollSystem();
           FullTimeEmployee emp1=new FullTimeEmployee("Vikas",1,70000);
           PartTimeEmployee emp2=new PartTimeEmployee("Saurabh",2,40,100);
           FullTimeEmployee emp3=new FullTimeEmployee("Rahul",3,20000);
           FullTimeEmployee emp4=new FullTimeEmployee("Prakash",4,3232321);
           PartTimeEmployee emp6=new PartTimeEmployee("Priya",6,40,1000);
           FullTimeEmployee emp7=new FullTimeEmployee("Shishir",7,323333);
           FullTimeEmployee emp8=new FullTimeEmployee("Ayan Kumar",8,200000);
           PartTimeEmployee emp9=new PartTimeEmployee("RAhilas",9,201,200);
           PartTimeEmployee emp10=new PartTimeEmployee("Bhuvan",10,203,220);
           PartTimeEmployee emp5=new PartTimeEmployee("Narendra",5,400,3000);


           payrollsystem.addEmployee(emp1);
           payrollsystem.addEmployee(emp2);
           payrollsystem.addEmployee(emp3);
           payrollsystem.addEmployee(emp4);
           payrollsystem.addEmployee(emp5);
           payrollsystem.addEmployee(emp6);
           payrollsystem.addEmployee(emp7);
           payrollsystem.addEmployee(emp8);
           payrollsystem.addEmployee(emp9);
           payrollsystem.addEmployee(emp10);

           System.out.println("Initial Employee Details: ");
           payrollsystem.displayEmployees();
           System.out.println("Remove Employee: ");
           payrollsystem.removeEmployee(9);
           payrollsystem.removeEmployee(6);
           System.out.println("Remaining Employee: ");
           payrollsystem.displayEmployees();
        }
    }