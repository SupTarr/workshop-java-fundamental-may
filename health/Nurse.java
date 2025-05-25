package health;

public class Nurse extends Worker implements Health {
    private String department;
    private Float otHours;

    public Nurse(String name, int age, String jobTitle, double salary, String department, float otHours) {
        super(name, age, jobTitle, salary);
        this.department = department;
        this.otHours = otHours;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public float getOtHours() {
        return otHours;
    }

    public void setOtHours(float otHours) {
        this.otHours = otHours;
    }
    
    public double calculateTotalOt() {
        return 15 * otHours;
    }

    public double calculateTotalSalary() {
        return this.getSalary() + this.calculateTotalOt();
    }
}
