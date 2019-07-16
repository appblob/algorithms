package graphs;

import java.util.*;

public class TopologicalSort {


    public static void main(String[] args) {
        Map<String, List<String>> subjects = new HashMap<>();
        subjects.put("CS101", Arrays.asList("DataStructures", "ComputerGraphics", "PrinciplesOfProgrammingLanguage","SoftwareEngineering"));
        subjects.put("Math101", Arrays.asList("Math102", "DataStructures", "ComputerArchitecture"));
        subjects.put("ComputerArchitecture", Arrays.asList("OperatingSystems", "ComputerNetworks"));
        subjects.put("DataStructures", Arrays.asList("OperatingSystems", "ComputerNetworks", "TheoryOfComputation"));
        subjects.put("ElementsOfMechanicalEngineering", Arrays.asList());
        //subjects.put("OperatingSystems", Arrays.asList("ComputerArchitecture"));

        List<String> order = topologicalSort(subjects);
        System.out.println(order);
    }

    private static List<String> topologicalSort(Map<String, List<String>> subjects) {
        Set<String> visited = new HashSet<>();
        Set<String> visiting = new HashSet<>();
        Stack<String> order = new Stack<>();
        List<String> subjectList = new LinkedList<>();

        try {
            for (String subject : subjects.keySet())
                dfs(subject, subjects, visited, visiting, order);

            subjectList = new ArrayList<>(order);
            Collections.reverse(subjectList);

        } catch (RuntimeException ex) {

            System.out.println(ex.getMessage());
        }
        return subjectList;
    }

    private static void dfs(String subject, Map<String, List<String>> subjects, Set<String> visited, Set<String> visiting, Stack<String> order) {

        if (!visited.contains(subject)) {
            visiting.add(subject);

            if (subjects.containsKey(subject)) {

                for (String neighbor : subjects.get(subject)) {

                    if (visiting.contains(neighbor))
                        throw new RuntimeException("There is a cycle between " + subject + " and " + neighbor);


                    dfs(neighbor, subjects, visited, visiting, order);

                }
            }

            // all the neighbors are visited. Mark the subject as visited and add it to the stack.
            visiting.remove(subject);
            visited.add(subject);
            order.push(subject);
        }
    }
}