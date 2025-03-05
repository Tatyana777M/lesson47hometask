import java.util.*;

public class Main {
    private static java.util.Collections Collections;

    public static void main(String[] args) {


        List<Programmer> programmers = new ArrayList<>();
        programmers.add(new Programmer("John", "Berlin", List.of(
                new Task(1, "Fix bug", "In progress", 10),
                new Task(2, "Write tests", "Done", 3),
                new Task(3, "Refactor code", "Done", 7)))
        );
        programmers.add(null);
        programmers.add(new Programmer("Nikita", "Berlin", null));
        programmers.add(new Programmer("Jack", "Berlin", List.of(
                new Task(3, "Refactor code", "Done", 7),
                new Task(4, "Deploy application", "In Progress", 2)))
        );
        programmers.add(new Programmer("Charlie", "Munich", List.of(
                new Task(5, "Code review", "In Progress", 6))));


        Map<Integer, Task> createTaskMap;
        createTaskMap(programmers);

        System.out.println("----------- Карта всіх завдань --------");
        createTaskMap().forEach((key, value) -> System.out.println("Ключ: " + key + ", Значення: " + value));
    }

    private static Map<Object, Object> createTaskMap() {
        return null;
    }

    public static Map<Integer, Task> createTaskMap(List<Programmer> programmers) {
        if (programmers == null || programmers.isEmpty()) {
            return Collections.emptyMap();
        }

        int dayLimit = 0;
        return (Map<Integer, Task>) programmers.stream()
                .filter(p -> Objects.nonNull(p) && Objects.nonNull(p.getTasks()) && p.getCity().equals(p.getCity()))
                //.filter(p->p.getCity().equals(city))
                .flatMap(p -> p.getTasks().stream())
                .filter(t -> Objects.nonNull(t) && !t.getStatus().equalsIgnoreCase("done") && t.getDaysInProcessing() > dayLimit)
                .distinct()
                .toList();
    }

    public static <E> void print(Collection<E> list) {
        list.forEach(a -> System.out.println(a));
    }

}

