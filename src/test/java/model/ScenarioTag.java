package model;

public record ScenarioTag(String label, String value) {

    @Override
    public String toString() {
        return "ScenarioTag{" +
                "label='" + label + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
