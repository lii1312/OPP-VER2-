
package onthi2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Student extends Person{
    
    private float gpa;
    private String major;
    private double tuition;
    private boolean schoolarship;

    public Student() {
        super();
    }

    public Student(float gpa, String major, double tuition, boolean schoolarship, String id, String fullName, Date dateOfBirth) {
        super(id, fullName, dateOfBirth);
        this.gpa = gpa;
        this.major = major;
        this.tuition = caculateTuition();
        this.schoolarship = (gpa >=9.0);
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
        this.tuition = caculateTuition();
        this.schoolarship = caculateSchoolarship();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getTuition() {
        return tuition;
    }

    public void setTuition(double tuition) {
        this.tuition = tuition;
    }

    public boolean isSchoolarship() {
        return schoolarship;
    }

    public void setSchoolarship(boolean schoolarship) {
        this.schoolarship = schoolarship;
    }
    
    private boolean caculateSchoolarship(){
        return gpa >= 9.0;
    }
    public void addStudent(){
        Scanner sc = new Scanner(System.in);
        System.out.println("ID");
        String id =sc.nextLine();
        this.setId(id);
        System.out.println("full Name");
        String fullName = sc.nextLine();
        this.setFullName(fullName);
        System.out.println("date of birth");
        String dobs = sc.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date dateOfBirth = sdf.parse(dobs);
            this.setDateOfBirth(dateOfBirth);
        } catch (Exception e) {
            System.out.println("wrong fomat!");
        }
        System.out.println("GPA");
        float gpa = Float.parseFloat(sc.nextLine());
        this.setGpa(gpa);
        System.out.println("major");
        String major = sc.nextLine();
    }
    public double caculateTuition(){
        if(gpa>=9.0){
            return 5000000;
        }else{
            return 10000000;
        }
    }
    
    public void displayInfo(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("hien thi thong tin sinh vien:");
        System.out.println("Enter id:"+this.getId());
        System.out.println("Enter full name:"+this.getFullName());
        System.out.println("Enter date of birth:"+sdf.format(dateOfBirth));
        System.out.println("Enter gpa:"+this.getGpa());
        System.out.println("Enter major:"+this.getMajor());
        System.out.println("Enter gpa:"+(long)this.getTuition());
        System.out.println("schoolarship");
        if(schoolarship){
            System.out.println("student schoolarship");
        }else{
            System.out.println("student no schoolarship");
        }
        
    }
}
