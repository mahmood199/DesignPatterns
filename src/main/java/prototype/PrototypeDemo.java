package prototype;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrototypeDemo {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter Employee Id: ");
        int id = Integer.parseInt(br.readLine());
        System.out.print("\n");

        System.out.print("Enter Employee Name: ");
        String name = br.readLine();
        System.out.print("\n");

        System.out.print("Enter Employee Designation: ");
        String designation = br.readLine();
        System.out.print("\n");

        System.out.print("Enter Employee Address: ");
        String address = br.readLine();
        System.out.print("\n");

        System.out.print("Enter Employee Salary: ");
        double salary = Double.parseDouble(br.readLine());
        System.out.print("\n");

        EmployeeRecord employeeRecord1 = new EmployeeRecord(id, name, designation, salary, address);
        employeeRecord1.showRecord();

        EmployeeRecord employeeRecord2 = (EmployeeRecord) employeeRecord1.getClone(
                id, "Mahmood", "Android Developer", null, "Kolkata"
        );
        employeeRecord2.showRecord();
    }

}
