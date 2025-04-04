package GPA_Calculator;

import java.util.Scanner;

public class calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Define grade points for each letter grade
        double[] gradePoints = {4.0, 3.7, 3.3, 3.0, 2.7, 2.3, 2.0, 1.7, 1.3, 1.0, 0.0};
        String[] grades = {"A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "F"};
        
        // Ask the user for the number of courses
        System.out.print("Enter the number of courses: ");
        int numCourses = scanner.nextInt();
        
        // Variables to store total credits and weighted grade points
        double totalCredits = 0;
        double weightedGradePoints = 0;
        
        // Loop through each course
        for (int i = 0; i < numCourses; i++) {
            System.out.println("Enter details for course " + (i + 1) + ": ");
            
            // Input grade and credit hours for each course
            System.out.print("Enter grade (A, A-, B+, B, etc.): ");
            String grade = scanner.next().toUpperCase();
            System.out.print("Enter credit hours: ");
            int creditHours = scanner.nextInt();
            
            // Find the grade point for the entered grade
            double gradePoint = 0.0;
            for (int j = 0; j < grades.length; j++) {
                if (grades[j].equals(grade)) {
                    gradePoint = gradePoints[j];
                    break;
                }
            }
            
            // Add to total credits and weighted grade points
            totalCredits += creditHours;
            weightedGradePoints += gradePoint * creditHours;
        }
        
        // Calculate GPA
        double GPA = weightedGradePoints / totalCredits;
        
        // Output the result
        System.out.printf("Your GPA is: %.2f\n", GPA);
        
        scanner.close();
    }
}
