import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    EmployeeService service = new EmployeeService();

    int option;
    do {
        System.out.println("\n=== Employee Management System ===");
        System.out.println("1. Add employee");
        System.out.println("2. Show all employees");
        System.out.println("3. Search employee by ID");
        System.out.println("4. Delete employee");
        System.out.println("5. Update employee  ");
        System.out.println("0. Exit");

        System.out.print("Choose an option: ");
        option = scanner.nextInt();
        scanner.nextLine();
        switch (option) {
            case 1:
                System.out.print("Enter ID: ");
                int id = scanner.nextInt();
                if (service.findById(id) != null) {
                    System.out.println("Employee with this ID already exists.");
                    break;
                }
                scanner.nextLine();

                System.out.print("Enter Name: ");
                String name = scanner.nextLine();

                System.out.print("Enter Department: ");
                String department = scanner.nextLine();

                System.out.print("Enter Salary: ");
                double salary = scanner.nextDouble();
                if (salary < 0) {
                    System.out.println("Salary cannot be negative.");
                    break;
                }
                scanner.nextLine();

                Employee employee = new Employee(id, name, department, salary);
                service.addEmployee(employee);
                System.out.println("Employee added successfully!");
                break;

            case 2:
                System.out.println("\n--- All Employees ---");
                if (service.getAllEmployees().isEmpty())
                    System.out.println("There are no employees yet.");
                else {
                    for (Employee e : service.getAllEmployees()) {
                        System.out.println(e);
                    }
                }
                break;

            case 3:
                System.out.print("Enter ID to search: ");
                int searchId = scanner.nextInt();
                scanner.nextLine();

                Employee found = service.findById(searchId);
                if (found != null) {
                    System.out.println("Employee found: " + found);
                } else {
                    System.out.println("Employee not found.");
                }
                break;

            case 4:
                System.out.print("Enter ID to delete: ");
                int deleteId = scanner.nextInt();
                scanner.nextLine();

                Employee toDelete = service.findById(deleteId);
                if (toDelete != null) {
                    service.deleteEmployeeById(deleteId);
                    System.out.println("Employee deleted successfully!");
                } else {
                    System.out.println("Employee not found.");
                }
                break;
            case 5:
                System.out.print("Enter ID: ");
                int idToUpdate = scanner.nextInt();
                Employee existing = service.findById(idToUpdate);
                if (existing == null) {
                    System.out.println("Employee not found.");
                    break;
                }
                scanner.nextLine();

                System.out.print("Enter Name: ");
                String nameToUpdate = scanner.nextLine();

                System.out.print("Enter Department: ");
                String departmentToUpdate = scanner.nextLine();

                System.out.print("Enter Salary: ");
                double salaryToUpdate = scanner.nextDouble();

                if (salaryToUpdate < 0) {
                    System.out.println("Salary cannot be negative.");
                    break;
                }
                scanner.nextLine();
                service.updateEmployee(idToUpdate, nameToUpdate, departmentToUpdate, salaryToUpdate);
                System.out.println("Employee updated successfully!");
                break;
            case 0:
                System.out.println("Exiting...");
                break;

            default:
                System.out.println("Invalid option! Try again.");

        }
    } while (option != 0) ;


    scanner.close();
    }
}
