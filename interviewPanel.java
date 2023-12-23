package console;
import java.util.*;

class Candidate {
    private String name;

    public Candidate(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Interviewer {
    private String name;
    private String role;

    public Interviewer(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }
}

class Panel {
    private Queue<Candidate> candidateQueue;
    private List<Interviewer> interviewers;
    private int interviewerIndex = 0; // To keep track of the current interviewer

    public Panel() {
        this.candidateQueue = new LinkedList<>();
        this.interviewers = new ArrayList<>();
    }

    public void addCandidate(Candidate candidate) {
        candidateQueue.offer(candidate);
        System.out.println("Candidate " + candidate.getName() + " added to the queue.");
    }

    public void addInterviewer(Interviewer interviewer) {
        interviewers.add(interviewer);
        System.out.println("Interviewer " + interviewer.getName() + " added to the panel.");
    }

    public void conductInterview() {
        if (candidateQueue.isEmpty()) {
            System.out.println("No candidates in the queue for interview.");
        } else {
            Candidate candidate = candidateQueue.poll();
            System.out.println("Interviewing candidate: " + candidate.getName());

            if (!interviewers.isEmpty()) {
                Interviewer interviewer = interviewers.get(interviewerIndex);
                System.out.println("Interviewer: " + interviewer.getName() + ", Role: " + interviewer.getRole());

                interviewerIndex = (interviewerIndex + 1) % interviewers.size(); // Move to the next interviewer
            } else {
                System.out.println("No interviewers available.");
            }
        }
    }
}

public class interviewPanel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Panel interviewPanel = new Panel();
        int choice;

        do {
            System.out.println("1. Add Candidate");
            System.out.println("2. Add Interviewer");
            System.out.println("3. Conduct Interview");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter candidate name: ");
                    String candidateName = scanner.next();
                    Candidate candidate = new Candidate(candidateName);
                    interviewPanel.addCandidate(candidate);
                    break;

                case 2:
                    System.out.print("Enter interviewer name: ");
                    String interviewerName = scanner.next();
                    System.out.print("Enter interviewer role: ");
                    String interviewerRole = scanner.next();
                    Interviewer interviewer = new Interviewer(interviewerName, interviewerRole);
                    interviewPanel.addInterviewer(interviewer);
                    break;

                case 3:
                    interviewPanel.conductInterview();
                    break;

                case 4:
                    System.out.println("Exiting the interview panel application. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 4);
    }
}
