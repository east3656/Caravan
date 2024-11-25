package view;

import java.util.ArrayList;
import java.util.List;

public class CompositeDisplay implements Display {
  
    private final List<Display> components = new ArrayList<>();

    public void addComponent(Display component) {
        components.add(component);
    }

    @Override
    public String render() {
        StringBuilder sb = new StringBuilder();
        for (Display component : components) {
            sb.append(component.render()).append("\n");
        }
        return sb.toString();
    }
}
