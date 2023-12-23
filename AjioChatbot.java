package console;
import java.util.Stack;
import java.util.Scanner;

public class AjioChatbot {

    private static final String DEFAULT_RESPONSE = "Sorry, I didn't understand that.";

    public static void main(String[] args) {
        Stack<String> conversationStack = new Stack<>(); // Create a stack to store the conversation history
        Scanner scanner = new Scanner(System.in); // Create a scanner to read user input

        while (true) { // Loop until the user wants to exit
            System.out.print("You: "); // Prompt the user for input
            String userMessage = scanner.nextLine(); // Read the user's input

            String response = handleUserMessage(userMessage); // Process the user's input and generate a response
            conversationStack.push(response); // Add the response to the conversation stack

            System.out.println("Chatbot: " + response); // Display the chatbot's response

            if (userMessage.equals("bye") || userMessage.equals("goodbye")) { // Check if the user wants to exit
                System.out.println("Chatbot: Good bye!");
                break;
            }
        }
    }

    private static String handleUserMessage(String userMessage) { // Process the user's input and generate a response
        if (userMessage.equals("hello") || userMessage.equals("hi")) { // Greetings
            return "Welcome to Ajio! How can I help you today?";
        }else if(userMessage.contains("I have some queries")) {
        	return "sure,Let me know how can i help you :)";
        } else if (userMessage.contains("order status")) { // Order status inquiry
            return "Please provide your order number to check the status.";
        } else if (userMessage.contains("product information")) { // Product information request
            return "Please provide the product name or ID to get more information.";
        } else if (userMessage.contains("return or exchange")) { // Return or exchange inquiry
            return "Our return and exchange policy is very simple. Please visit our website for more details.";
        } else if (userMessage.contains("feedback")) { // Feedback submission
            return "We appreciate your feedback. Please send us an email to support@ajio.com.";
        }else if(userMessage.contains("ok,Thank you")) {
        	return "bye";
        } else { // Default response for unrecognized input
            return DEFAULT_RESPONSE;
        }
    }
}



