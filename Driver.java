import java.util.Scanner;

public class Driver{
    private Scanner input = new Scanner(System.in);
    private Course course;

    public static void main(String[] args) {
        new Driver();
    }
    public Driver() {
        proccesStudents();
        runMenu();
    }

    private void addStudent() {
        input.nextLine();

        System.out.print("Enter the Student Name:  ");
        String studentName = input.nextLine();
        System.out.print("Enter the Student Number:  ");
        int studentNumber = input.nextInt();
        for(int j=0;j<=6;j++) {
            System.out.print("Enter the Students Average Marks:"+j":");
        }
        double averageMarks[6] = input.nextDouble();
        System.out.print("Is this student currently registered? (y/n): ");
        char currentRegistered = input.next().charAt(0);
        boolean isCurrentlyRegistered = false;
        if((currentRegistered=='y')||(currentRegistered=='Y'))
            isCurrentlyRegistered = true;
       boolean isAdded = course.add(new Student(studentName, studentNumber, averageMarks, isCurrentlyRegistered));
       if (isAdded) {
           ystem.out.println("Student Added Successfully");

      }
       else {
           System.out.println("Student Not Added");
       }
    }

    private void printStudents() {
        System.out.println(course.listStudents());
    }

    private void proccesStudents() {
        System.out.print("How many Students are in the course?");
        int numberStudents = input.nextInt();

        course = new Course(numberStudents);

        for(int i=0;i<numberStudents;i++) {
            addStudent();
        }
    }
    private void printCurrentStudents() {
        System.out.println("List of current Students are":");
        System.out.print(course.listCurrentStudents());
    }
    private void printAverageStudentMark() {
        double averageMark = course.averageStudentMark();
        if(averageMark != -1) {
            System.out.println("The Average Student Mark is: " + averageMark);
        }
        else {
            System.out.println("There are no Students in the Course");
        }
    }
    private void printLowestAverageMark() {
        Student lowestAverageMark = course.lowestAverageMark();
        if(lowestAverageMark != null) {
            System.out.println("The Lowest Average Student Mark is: " + lowestAverageMark.getStudentName());
        }
        else {
            System.out.println("There are no Students in the Course");
        }
    private void printHighestAverageMark() {
        Student highestAverageMark = course.highestAverageMark();
        if(highestAverageMark != null) {
            System.out.println("The Highest Average Student Mark is: " + highestAverageMark.getStudentName());
        }
        else {
            System.out.println("There are no Students in the Course");
        }
    }
    private void printStudentswithAverageMarkAboveGivenMark() {
        System.out.println("View Students with a Higher Average Mark than: ");
        double price = input.nextDouble();
        System.out.println(course.printStudentsAverageAboveAPoint(price));
    }
    private int mainMenu() {
        System.out.print("""
                Shop Menu
                ---------
                    1) List the Students
                    2) List the Currently Registered Students
                    3) List the Students whose Average mark is more than a given Average
                    4) List the Students names with their Average marks
                    5) List Average Student Mark
                    6) List the Student with the Lowest Average mark
                    7) List the Student with the Highest Average mark
                    8) Deregister a Student
                    ==>> """);
        int option = input.nextInt();
        return option;
    }
    private void runMenu() {
        int option = mainMenu();
        while(option !=0) {
            switch(option) {
                case 1 -> printStudents();
                case 2 -> printCurrentStudents();
                case 3 -> printStudentsWithAverageMarkAboveGivenMark();
                case 4 -> printStudentsPlusAverageMark();
                case 5 -> printAverageStudentMark();
                case 6 -> printLowestAverageMark();
                case 7 -> printHighestAverageMark();
                case 8 -> printDeregister();
                default -> System.out.println("Invalid option entered: " + option);
            }
            System.out.println("/nPress enter key to continue...");
            input.nextLine();
            input.nextLine();
            option=mainMenu();
        }
        System.out.println("Exiting...bye");
        System.exit(0);
    }
}
