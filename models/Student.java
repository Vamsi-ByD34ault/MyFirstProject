package Revision.models;

public class Student{
  private int rollNumber;
  private String name;
  private String Department;
  public Student(String name, String Department, int rollNumber){
    this.name = name;
    this.Department = Department;
    this.rollNumber = rollNumber;
  }

  public String getStudentName(){
    return this.name;
  }

  public String getStudentDepartment(){
    return this.Department;
  }

  public int getStudentRollNumber(){
    return this.rollNumber;
  }


  public void displayDetails(){
    System.out.println("Name of the Student: " + this.name);
    System.out.println("RollNumber of the Student: " + this.rollNumber);
    System.out.println("Department Of the Student: " + this.Department);
    
  }

}


