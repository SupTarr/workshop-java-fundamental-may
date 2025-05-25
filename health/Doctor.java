package health;

public class Doctor extends Worker implements Health {
    private String specialty;
    private Float otHours;

    public Doctor(String name, int age, String jobTitle, double salary, String specialty, float otHours) {
        super(name, age, jobTitle, salary);
        this.specialty = specialty;
        this.otHours = otHours;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public float getOtHours() {
        return otHours;
    }

    public void setOtHours(float otHours) {
        this.otHours = otHours;
    }

    public double calculateTotalOt() {
        return 20 * otHours;
    }

    public double calculateTotalSalary() {
        return this.getSalary() + this.calculateTotalOt();
    }
}
