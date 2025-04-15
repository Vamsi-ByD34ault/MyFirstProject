package Revision.managers;

import Revision.models.Student;
import Revision.exceptions.StudentAlreadyExistsException;
import Revision.exceptions.StudentNotFoundException;

import java.util.Scanner;

public class StudentManager{

  private int maxStrength;
  private Student[] students;
  public  StudentManager(int maxStrength){
    this.maxStrength = maxStrength;
    students = new Student[maxStrength];
  }
  private int count = 0;
  public boolean addStudent(Scanner sc){
    boolean isadded = false;
    if(this.count< maxStrength){
      System.out.print("Enter the name of the Student: ");
      String name = sc.nextLine();
      int rollNumber = getValidatedRollNumber(sc,"Enter the RollNumber of the Student: ");
        try{
          checkifStudentExist(rollNumber);
        }
        catch(StudentAlreadyExistsException e){
          System.out.println(e.getMessage());
          return isadded;
        }
      System.out.print("Enter the Department of the Student: ");
      String department = sc.nextLine();
      Student student = new Student(name, department, rollNumber);
      students[count] = student;
      count ++;
      System.out.println("Student added successfully.\n");
      return isadded = true;
    }
    else{
      System.out.println("Class is Full, can't add further students");
      return isadded = true;
    }
  }

  public void viewStudents(){
    System.out.println("\n---Details of the Students---");
    for(int i=0;i< this.count;i++){
      System.out.println();
      if(students[i] != null){
        students[i].displayDetails();
      }
    }
    System.out.println("\n---END---");
  } 

  public void checkifStudentExist(int rollNumber) throws StudentAlreadyExistsException{
    boolean found = false;
    for(int i=0;i< count; i++){
      if(students[i].getStudentRollNumber() == rollNumber){
        found = true;
        break;
      }
    }
    if(found){
      throw new StudentAlreadyExistsException("A Student with this rollNumber has already enrolled.");
    }
  }
 
  public void deleteStudent(int rollNumber) throws StudentNotFoundException {
    boolean found = false;
    for (int i = 0; i < count; i++) {
        if (students[i] != null && students[i].getStudentRollNumber() == rollNumber) {
            // Shift elements to fill the gap
            for (int j = i; j < count - 1; j++) {
                students[j] = students[j + 1];
            }
            students[count - 1] = null;
            count--;
            found = true;
            break;
        }
    }
    if (!found) {
        throw new StudentNotFoundException("Student not Found");
    }
  }

  public static int getValidatedRollNumber(Scanner sc, String prompt) {
    while (true) {
        System.out.print(prompt);
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid integer Roll Number.");
        }
    }
  }

}
