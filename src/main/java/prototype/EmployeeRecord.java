package prototype;

import org.jetbrains.annotations.Nullable;

public class EmployeeRecord implements Prototype {

    private int id;
    private String name, designation;
    private double salary;
    private String address;

    public EmployeeRecord() {
        System.out.println("   Employee Records of Oracle Corporation ");
        System.out.println("---------------------------------------------");
        System.out.println("Eid" + "\t" + "Ename" + "\t" + "Edesignation" + "\t" + "Esalary" + "\t\t" + "Eaddress");
    }

    public EmployeeRecord(int id, String name, String designation, double salary, String address) {
        this();
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
        this.address = address;
    }

    public void showRecord() {
        System.out.println(id + "\t" + name + "\t" + designation + "\t" + salary + "\t" + address);
    }

    @Override
    public Prototype getClone(
            @Nullable Integer passedId,
            @Nullable String passedName,
            @Nullable String passedDesignation,
            @Nullable Double passedSalary,
            @Nullable String passedAddress
    ) {
        if(passedId != null)
            this.id = passedId;
        if(passedName != null)
            this.name = passedName;
        if(passedDesignation != null)
            this.designation = passedDesignation;
        if(passedSalary != null)
            this.salary = passedSalary;
        if(passedAddress != null)
            this.address = passedAddress;
        return new EmployeeRecord(id, name, designation, salary, address);
    }
}
