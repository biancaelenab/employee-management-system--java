import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeService {

    private ArrayList<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee){
            employees.add(employee);
    }

    public Employee findById(int id){
        for (Employee e:employees){
            if(e.getId()==id){
                return e;
            }
        }
        return null;
    }

    public void deleteEmployeeById(int id) {
        Employee e = findById(id);
        if (e != null) {
            employees.remove(e);
        }
    }
    public void updateEmployee(int id, String name, String department, double salary) {
        Employee empToUpdate = findById(id);
        if (empToUpdate == null) {
            System.out.println("Employee not found.");
            return;
        }
        empToUpdate.setName(name);
        empToUpdate.setDepartment(department);
        empToUpdate.setSalary(salary);

    }


    public ArrayList<Employee> getAllEmployees () {
        return employees;
        }
    }

