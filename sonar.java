// TestSonar.java
public class TestSonar {

    // Badly named variable
    private int xXx = 0;

    public static void main(String[] args) {
        TestSonar ts = new TestSonar();
        ts.doSomething();
        ts.duplicateCode();
        ts.duplicateCode(); // duplicate usage
    }

    // Method with unused variable
    public void doSomething() {
        int unusedVar = 42; // unused variable
        System.out.println("Doing something...");
    }

    // Duplicate method logic
    public void duplicateCode() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Hello SonarQube!");
        }
    }
}
