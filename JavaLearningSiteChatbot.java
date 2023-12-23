package console;

import java.util.Stack;

public class JavaLearningSiteChatbot {

    private Stack<String> questions;

    public JavaLearningSiteChatbot() {
        this.questions = new Stack<>();
    }

    public void startChat() {
        greeting();
        handleUserQuestions();
    }

    private void greeting() {
        System.out.println("Welcome to the Java Learning Site Chatbot!");
        System.out.println("Ask me any questions you have about Java programming.");
    }

    private void handleUserQuestions() {
        String input = null;
        while (!input.equals("exit")) {
            System.out.print("Enter your question: ");
            input = System.console().readLine();

            if (!input.equals("exit")) {
                // Push the user's question onto the stack
                questions.push(input);

                // Generate and display the chatbot's response
                String response = generateChatbotResponse();
                System.out.println("Chatbot: " + response);
            }
        }
    }

    private String generateChatbotResponse() {
        String question = questions.pop();

        // Process the user's question and generate an appropriate response
        switch (question) {
            case "What is Java?":
                return "Java is a programming language that is widely used for developing applications, web applications, and enterprise software.";

            case "What are the benefits of using Java?":
                return "Java is a powerful, object-oriented language that is known for its portability, security, and reliability.";

            case "How do I get started with Java?":
                return "There are many resources available to help you learn Java, including online tutorials, books, and coding bootcamps.";

            default:
                return "I'm sorry, I don't understand your question. Please try rephrasing it.";
        }
    }

    public static void main(String[] args) {
        JavaLearningSiteChatbot chatbot = new JavaLearningSiteChatbot();
        chatbot.startChat();
    }
}
