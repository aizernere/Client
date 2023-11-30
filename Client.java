import java.util.ArrayList;
import java.util.List;

// Component interface
interface Component {
    void operation();
}

// Leaf class
class Leaf implements Component {
    @Override
    public void operation() {
        System.out.println("Ako ay isang leaf na operasyon");
    }
}

// Composite class
class Composite implements Component {
    private List<Component> children = new ArrayList<>();

    public void add(Component component) {
        children.add(component);
    }

    @Override
    public void operation() {
        System.out.println("Composite operation");

        // Performing recursive operation on child components
        for (Component child : children) {
            child.operation();
        }
    }
}

// Client code
public class Client {
    public static void main(String[] args) {
        // Creating Leaf and Composite objects
        Leaf leafA = new Leaf();
        Leaf leafB = new Leaf();
        Composite compositeA = new Composite();
        Composite compositeB = new Composite();

        // Building a composite structure
        compositeA.add(leafA);
        compositeA.add(leafB);
        compositeA.add(compositeB);

        // Adding more elements to compositeB
        compositeB.add(new Leaf());
        compositeB.add(new Leaf());

        // Client interacts with the composite structure
        compositeA.operation();
    }
}
