package com.interview.systemDesign.DesignPattern.behavioural;

// The Chain of Responsibility pattern allows a request to be passed along a chain of handlers, where each handler
// decides either to process the request or pass it to the next handler in the chain.

// It decouples the sender and receiver:
    //The sender doesn’t know which object will handle the request.
    //Multiple handlers get a chance to process the request.

// Characteristics:
    // Follows the “pass the request along the chain” principle.
    // Promotes loose coupling between sender and receiver.
    // Used when multiple objects can handle a request, but the handler isn’t known in advance.

// Real-World Analogy:
    //Think of customer support escalation:
        //Level 1 support tries to solve your issue.
        //If they can’t, it goes to Level 2.
        //If not resolved, escalates to Level 3 manager.

// When to Use Chain of Responsibility:
    // When multiple objects can handle a request, but you don’t want to specify the handler explicitly.
    // When requests should be handled in a flexible, dynamic order.
    // Common in logging, authentication, validation, and request filtering.

public class ChainofResponsibility {

    public static void main(String[] args) {
        Handler manager = new Manager();
        Handler director = new Director();
        Handler ceo = new CEO();
        // Build chain: Manager -> Director -> CEO
        manager.setNextHandler(director);
        director.setNextHandler(ceo);
        // Send requests
        manager.handleRequest("LeaveApproval");       // Manager handles
        manager.handleRequest("BudgetApproval");      // Director handles
        manager.handleRequest("CompanyAcquisition");  // CEO handles
        manager.handleRequest("UnknownRequest");      // Nobody handles
    }
}

// Step 1: Handler interface
abstract class Handler {
    protected Handler nextHandler;

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
    public abstract void handleRequest(String request);
}

// Step 2: Concrete Handlers
class Manager extends Handler {
    public void handleRequest(String request) {
        if (request.equals("LeaveApproval")) {
            System.out.println("Manager approved the leave request.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}

class Director extends Handler {
    public void handleRequest(String request) {
        if (request.equals("BudgetApproval")) {
            System.out.println("Director approved the budget request.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}

class CEO extends Handler {
    public void handleRequest(String request) {
        if (request.equals("CompanyAcquisition")) {
            System.out.println("CEO approved the company acquisition.");
        } else {
            System.out.println("Request could not be handled.");
        }
    }
}
