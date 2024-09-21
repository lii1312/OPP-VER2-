
package onthi2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class StudentList {
    private  ArrayList<Student> studentList = new ArrayList<>();
    
    public StudentList() {
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }
    
    public void addStudent(Student st){
        studentList.add(st);
    }
    
    public void updateStudent(String updateid){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ID sinh vien can cap nhat: ");
        String id = sc.nextLine();
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId().equals(id)) {
                System.out.println("Cap nhat thong tin sinh vien:");
                Student updatedStudent = studentList.get(i);

                System.out.print("Nhap Ten moi: ");
                updatedStudent.setFullName(sc.nextLine());

                System.out.print("Nhap Nganh moi: ");
                updatedStudent.setMajor(sc.nextLine());

                System.out.print("Nhap GPA moi: ");
                updatedStudent.setGpa(Float.parseFloat(sc.nextLine()));

                System.out.print("Nhap Ngay Sinh moi: ");
                String dobStr = sc.nextLine();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    updatedStudent.setDateOfBirth(sdf.parse(dobStr));
                } catch (Exception e) {
                    System.out.println("Wrong Format!");
                }

                studentList.set(i, updatedStudent);
            }
        }
    }
    public void deleteStudent(String id){
        studentList.removeIf(Student->Student.getId().equals(id));
    }
    public Student findTopStudent(String id){
        for(Student st :studentList){
            if(st.getId().equals(id)){
                return st;
            }
        }
        return null;
    }
    
    public void displayAllStudent() {
        if (studentList.isEmpty()) {
            System.out.println("No students available.");
	}
        for (Student student : studentList) {
            student.displayInfo();
            System.out.println();
        }
    }
    
    public Student findTopStudent(){
        if(studentList.isEmpty()){
            System.out.println("no student available");
            return null;
        }
        Student topStudent = studentList.get(0);
        for(Student student : studentList){
            if(student.getGpa() > topStudent.getGpa()){
                topStudent = student;
            }
        }
        return topStudent;
    }
    
    public ArrayList<Student> findScholarshipStudents() {
        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            if (student.isSchoolarship()) {
                student.displayInfo();
                System.out.println();
            }
        }
        return null;

    }

    public double caculateTuiitionOfAllStudents() {
        long hocPhi = 0;
        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            hocPhi += student.getTuition();
        }
        return hocPhi;
    }
}
