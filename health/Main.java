package health;

public class Main {
    public static void main(String[] args) {
        System.out.println("----------------------------------------");

        Doctor doctor = new Doctor("Dr. Smith", 45, "Cardiologist", 120000.0d, "Cardiology", 10.0f);
        System.out.println("Doctor's Name: " + doctor.getName());
        System.out.println("Doctor's Age: " + doctor.getAge());
        System.out.println("Doctor's Job Title: " + doctor.getJobTitle());
        System.out.println("Doctor's Salary: " + doctor.getSalary());
        System.out.println("Doctor's Specialty: " + doctor.getSpecialty());
        System.out.println("Doctor's OT Hours: " + doctor.getOtHours());
        System.out.println("Doctor's Total OT: " + doctor.calculateTotalOt());
        System.out.println("Doctor's Total Salary: " + doctor.calculateTotalSalary());

        System.out.println("----------------------------------------");

        Nurse nurse = new Nurse("Jane Doe", 30, "Nurse", 60000.0d, "OR", 15.0f);
        System.out.println("Nurse's Name: " + nurse.getName());
        System.out.println("Nurse's Age: " + nurse.getAge());
        System.out.println("Nurse's Job Title: " + nurse.getJobTitle());
        System.out.println("Nurse's Salary: " + nurse.getSalary());
        System.out.println("Nurse's Department: " + nurse.getDepartment());
        System.out.println("Nurse's OT Hours: " + nurse.getOtHours());
        System.out.println("Nurse's Total OT: " + nurse.calculateTotalOt());
        System.out.println("Nurse's Total Salary: " + nurse.calculateTotalSalary());
    }
}
