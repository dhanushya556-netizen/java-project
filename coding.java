import java.util.Scanner;
class GPACalculator4 {

  
    public static String getPerformance(double gpa) {
        if (gpa >= 9) {
            return "Excellent";
        } else if (gpa >= 8) {
            return "Very Good";
        } else if (gpa >= 7) {
            return "Good";
        } else if (gpa >= 6) {
            return "Average";
        } else {
            return "Need Improvement";
        }
    }

        public static double[] calculateGPA(int subjects, Scanner sc) {
        double totalCredits = 0;
        double totalGradePoints = 0;

        for (int i = 1; i <= subjects; i++) {
            System.out.println("\nSubject " + i);

            System.out.print("Enter Credits: ");
            double credit = sc.nextDouble();

            System.out.print("Enter Grade Point: ");
            double grade = sc.nextDouble();

            totalCredits += credit;
            totalGradePoints += (credit * grade);
        }

        // Avoid division by zero
        if (totalCredits == 0) {
            System.out.println("Invalid input (credits cannot be 0)");
            return new double[]{0, 0};
        }

        double gpa = totalGradePoints / totalCredits;

        System.out.println("---------------------------------");
        System.out.println("Semester GPA = " + String.format("%.2f", gpa));
        System.out.println("Performance: " + getPerformance(gpa));
        System.out.println("---------------------------------");

        return new double[]{totalCredits, totalGradePoints};
    }

    public static void main(String[] args) {

       
        Scanner sc = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("     GPA & CGPA CALCULATOR");
        System.out.println("=================================");

        System.out.print("Enter Number of Semesters: ");
        int semesters = sc.nextInt();

        double overallCredits = 0;
        double overallGradePoints = 0;

        for (int i = 1; i <= semesters; i++) {
            System.out.println("\n******** SEMESTER " + i + " ********");

            System.out.print("Enter Number of Subjects: ");
            int subjects = sc.nextInt();


            double[] result = calculateGPA(subjects, sc);

            overallCredits += result[0];
            overallGradePoints += result[1];
        }

        
        if (overallCredits == 0) {
            System.out.println("Cannot calculate CGPA");
        } else {
            double cgpa = overallGradePoints / overallCredits;

            System.out.println("\n=================================");
            System.out.println("        FINAL RESULT");
            System.out.println("=================================");
            System.out.println("Final CGPA = " + String.format("%.2f", cgpa));
            System.out.println("Overall Performance: " + getPerformance(cgpa));
            System.out.println("=================================");
        }

        sc.close();
    }
}
