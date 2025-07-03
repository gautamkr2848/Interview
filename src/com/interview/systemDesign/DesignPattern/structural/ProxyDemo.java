
package com.interview.systemDesign.DesignPattern.structural;

// The Proxy design pattern is a structural pattern that provides a surrogate or placeholder for another object to
// control access to it. This pattern can be used for various purposes such as controlling access, logging etc.

// Subject Interface
interface Image {
    void display();
}


// RealSubject Class
class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Loading image: " + filename);
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}


// Proxy Class
class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename); // loads only once
        }
        realImage.display();
    }
}


// Usage
public class ProxyDemo {
    public static void main(String[] args) {
        Image image = new ProxyImage("photo.jpg");

        System.out.println("First time:");
        image.display(); // Loads and displays

        System.out.println("\nSecond time:");
        image.display(); // Just displays, doesn't load again
    }
}

//First time:
//Loading image: photo.jpg
//Displaying image: photo.jpg
//
//Second time:
//Displaying image: photo.jpg