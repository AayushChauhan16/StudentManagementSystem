import java.util.*;

public class StudentManagementSystem {

    static ArrayList<Integer> studentrollno = new ArrayList<>();
    static ArrayList<String> studentName = new ArrayList<>();
    static ArrayList<int[]> studentMarks = new ArrayList<>();
    static ArrayList<Integer> totalMarks = new ArrayList<>();
    static ArrayList<Float> percentages = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n===STUDENT MANAGEMENT SYSTEM===");

        int choice = 0;

        while (choice != 6) {
            System.out.println("1. Add Student: ");
            System.out.println("2. Display All Student:");
            System.out.println("3. Search Student by Rollno: ");
            System.out.println("4. Calculate result: ");
            System.out.println("5. Check Ranks:");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    displayStudent();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    calculateResult();
                    break;

                case 5:
                    checkRanks();
                    break;

                case 6:
                    System.out.println("\nThank you for using Student Management System.");
                    System.out.println("Program terminated...\n");
                    break;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
        sc.close();
    }

    public static void addStudent() {

        System.out.print("\nEnter Roll Number: ");
        studentrollno.add(sc.nextInt());

        sc.nextLine();

        System.out.print("Enter Name: ");
        studentName.add(sc.nextLine());

        int marks[] = new int[3];
        int total = 0;

        System.out.println("Enter Marks of 3 subject : ");
        for (int i = 0; i < 3; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
            total += marks[i];
        }

        float percentage = total / 3.0f;

        studentMarks.add(marks);
        totalMarks.add(total);
        percentages.add(percentage);

        System.out.println("\nStudent Added!\n");
    }

    public static void displayStudent() {
        if (studentrollno.isEmpty()) {
            System.out.println("\nNo student record found.");
            return;
        }

        System.out.println("\n--------------------------------------------------------------");
        System.out.println("Rollno\tName\tM1\tM2\tM3\tTotal\tPercentage");
        System.out.println("--------------------------------------------------------------");

        for (int i = 0; i < studentrollno.size(); i++) {

            int[] marks = studentMarks.get(i);

            System.out.println(
                    studentrollno.get(i) + "\t" +
                            studentName.get(i) + "\t" +
                            marks[0] + "\t" +
                            marks[1] + "\t" +
                            marks[2] + "\t" +
                            totalMarks.get(i) + "\t" +
                            percentages.get(i) + "\n");
        }
    }

    public static void searchStudent() {

        System.out.print("\nEnter rollno to search: ");
        int r = sc.nextInt();

        for (int i = 0; i < studentrollno.size(); i++) {

            int[] marks = studentMarks.get(i);
            if (studentrollno.get(i) == r) {
                System.out.println("\nStudent Found!\n");
                System.out.println("Rollno: " + studentrollno.get(i));
                System.out.println("Name: " + studentName.get(i));
                System.out.println("Marks of subject-1: " + marks[0]);
                System.out.println("Marks of subject-2: " + marks[1]);
                System.out.println("Marks of subject-3: " + marks[2]);
                System.out.println("Total: " + totalMarks.get(i));
                System.out.println("Percentage: " + percentages.get(i) + "\n");
            }

        }

        if (studentrollno.isEmpty()) {
            System.out.println("Student not found!");
            return;
        }
    }

    public static void calculateResult() {
        System.out.print("\nEnter rollno to search: ");
        int r = sc.nextInt();

        for (int i = 0; i < studentrollno.size(); i++) {
            if (studentrollno.get(i) == r) {
                System.out.println("Total marks: " + totalMarks.get(i));
                System.out.println("Percentage: " + percentages.get(i));
                if (percentages.get(i) >= 75)
                    System.out.println("Grade: Distinction\n");
                else if (percentages.get(i) >= 60)
                    System.out.println("Grade: First Class\n");
                else if (percentages.get(i) >= 50)
                    System.out.println("Grade: Second Class\n");
                else
                    System.out.println("Grade: Fail\n");
            }
        }
    }

    public static void checkRanks() {
        if (studentrollno.isEmpty()) {
            System.out.println("\nNo student records found!");
            return;
        }

        ArrayList<Integer> rank = new ArrayList<>();

        for (int i = 0; i < totalMarks.size(); i++) {
            rank.add(i);
        }

        for (int i = 0; i < rank.size() - 1; i++) {
            for (int j = i + 1; j < rank.size(); j++) {
                if (totalMarks.get(rank.get(j)) > totalMarks.get(rank.get(i))) {
                    int temp = rank.get(j);
                    rank.set(i, rank.get(j));
                    rank.set(j, rank.get(i));
                }
            }
        }
        System.out.println("\n===== STUDENT RANKS =====\n");

        for (int i = 0; i < rank.size(); i++) {

            int index = rank.get(i);

            System.out.println(" Rank : " + (i + 1) + " "
                    + studentName.get(index)
                    + " (Roll No: " + studentrollno.get(index)
                    + ", Total: " + totalMarks.get(index)
                    + ")\n");
        }
    }

}
