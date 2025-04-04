package GPA_Calculator;
import java.util.Scanner;

public class calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Define grade points for each letter grade
        double[] gradePoints = {4.0, 4.0, 3.7, 3.3, 3.0, 2.7, 2.3, 2.0, 1.7, 1.3, 1.0, 0.0};
        String[] grades = {"A+","A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "F"};
        
        System.out.println("Welcome to the GPA Calculator!");
        System.out.println("This tool will help you calculate your GPA based on your grades and credits3.");

        // Ask the user for the number of courses
        int numCourses = 0;
        while (numCourses <= 0) {
            System.out.print("Please enter the number of courses: ");
            try {
                numCourses = Integer.parseInt(scanner.nextLine());
                if (numCourses <= 0) {
                    System.out.println("Number of courses must be greater than 0. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }

        // Variables to store total credits and weighted grade points
        double totalCredits = 0;
        double weightedGradePoints = 0;

        // Loop through each course and get the grade and credit hours
        for (int i = 0; i < numCourses; i++) {
            System.out.println("\nEntering details for Course " + (i + 1));

            // Input grade and credit hours for each course
            String grade = "";
            while (!isValidGrade(grade)) {
                System.out.print("Enter grade (A+,A, A-, B+, B, etc.): ");
                grade = scanner.nextLine().toUpperCase();
                if (!isValidGrade(grade)) {
                    System.out.println("Invalid grade entered. Please use one of the following grades: A, A-, B+, B, B-, C+, C, C-, D+, D, F.");
                }
            }

            int creditHours = 0;
            while (creditHours <= 0) {
                System.out.print("Enter credit hours (positive number): ");
                try {
                    creditHours = Integer.parseInt(scanner.nextLine());
                    if (creditHours <= 0) {
                        System.out.println("Credit hours must be a positive number.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter a valid number.");
                }
            }

            // Find the grade point for the entered grade
            double gradePoint = getGradePoint(grade, grades, gradePoints);

            // Add to total credits and weighted grade points
            totalCredits += creditHours;
            weightedGradePoints += gradePoint * creditHours;
        }

        // Calculate GPA
        double GPA = weightedGradePoints / totalCredits;

        // Output the result
        System.out.printf("\nYour GPA is: %.2f\n", GPA);

        scanner.close();
    }

    // Check if the grade is valid
    public static boolean isValidGrade(String grade) {
        String[] validGrades = {"A+","A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "F"};
        for (String validGrade : validGrades) {
            if (validGrade.equals(grade)) {
                return true;
            }
        }
        return false;
    }

    // Get the grade point associated with the grade
    public static double getGradePoint(String grade, String[] grades, double[] gradePoints) {
        for (int i = 0; i < grades.length; i++) {
            if (grades[i].equals(grade)) {
                return gradePoints[i];
            }
        }
        return 0.0; // Default return in case something goes wrong
    }
}
