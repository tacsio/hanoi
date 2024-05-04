package io.tacsio;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<Step> steps = new ArrayList<>();

    public static void main(String[] args) {
        var lvl = 8;
        solve(lvl, "A", "C", "B");

        steps.forEach(System.out::println);
    }

    public static void solve(int lvl, String origin, String destination, String aux) {
        if (lvl == 1) {
            steps.add(new Step(steps.size() + 1, origin, destination));
        } else {
            solve(lvl - 1, origin, aux, destination);
            steps.add(new Step(steps.size() + 1, origin, destination));
            solve(lvl - 1, aux, destination, origin);
        }
    }
}

record Step(int index, String from, String to) {
}