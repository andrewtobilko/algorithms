package com.tobilko.ai.lab2;


import com.google.common.collect.Sets;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Andrew Tobilko on 3/24/18.
 */
public final class Main {

    private final static Set<String> ALL = new HashSet<>(Arrays.asList("K1", "K2", "K3", "K4", "P1", "P2", "P3", "P4"));
    private final static Set<String> FINAL_STATE = new HashSet<>();

    public static void main(String[] args) {
        final State initialState = new State(new HashSet<>(ALL), FINAL_STATE, true, null);
        DFS(initialState);
        BFS(initialState);
    }

    public static void DFS(State initialState) {
        visited.add(initialState);
        goToNextStateDFS(initialState);

        for (int i = solutionSteps.size() - 1; i >= 0; --i) {
            System.out.println(solutionSteps.get(i));
        }
        System.out.println(" DFS = " + solutionSteps.size() + " " + visitedStates);
    }

    public static void BFS(State initialState) {
        visited = new HashSet<>();
        visited.add(initialState);
        State state = goToNextStateBFS(initialState);
        int count = 0;
        while (map.containsKey(state)) {
            ++count;
            System.out.println(state);
            state = map.get(state);
        }
        System.out.println(state);

        System.out.println("BFS = " + count + " " + visitedStates);

    }


    private static Map<State, State> map = new HashMap<>();

    private static State goToNextStateBFS(State state) {

        final Queue<State> queue = new LinkedList<>();
        queue.add(state);
        while (!queue.isEmpty()) {
            final State stateFromQueue = queue.remove();

            final boolean currentDirection = stateFromQueue.isDirection();
            final Set<Set<String>> nextBoatStates = getCombinations(currentDirection ? stateFromQueue.getLeftBank() : stateFromQueue.getRightBank());

            for (Set<String> boatState : nextBoatStates) {
                final boolean nextDirection = !currentDirection;

                final State nextState = new State(new HashSet<>(stateFromQueue.getLeftBank()), new HashSet<>(stateFromQueue.getRightBank()), nextDirection, boatState);

                (currentDirection ? nextState.getLeftBank() : nextState.getRightBank()).removeAll(boatState);
                (currentDirection ? nextState.getRightBank() : nextState.getLeftBank()).addAll(boatState);


                if (nextState.isValid() && !visited.contains(nextState)) {
                    visited.add(nextState);
                    ++visitedStates;
                    map.put(nextState, stateFromQueue);
                    queue.add(nextState);
                }

                if (isFinalState(stateFromQueue)) {
                    solutionSteps.add(stateFromQueue);
                    System.out.println("The final state is " + stateFromQueue);
                    return stateFromQueue;
                }
            }

        }

        return null;

    }

    private static int visitedStates = 0;
    private static List<State> solutionSteps = new ArrayList<>();
    private static boolean solutionFound;

    public static void goToNextStateDFS(State state) {
        visited.add(state);
        ++visitedStates;
        if (isFinalState(state)) {
            solutionFound = true;
            solutionSteps.add(state);
            System.out.println("The final state is " + state);
            return;
        }

        final boolean currentDirection = state.isDirection();

        final Set<Set<String>> nextBoatStates = getCombinations(currentDirection ? state.getLeftBank() : state.getRightBank());

        for (Set<String> boatState : nextBoatStates) {
            if (solutionFound) {
                break;
            }
            final boolean nextDirection = !currentDirection;

            final State nextState = new State(new HashSet<>(state.getLeftBank()), new HashSet<>(state.getRightBank()), nextDirection, boatState);

            (currentDirection ? nextState.getLeftBank() : nextState.getRightBank()).removeAll(boatState);
            (currentDirection ? nextState.getRightBank() : nextState.getLeftBank()).addAll(boatState);


            if (visited.contains(nextState)) {
                continue;
            }

            if (nextState.isValid()) {
                goToNextStateDFS(nextState);
            }
        }

        if (solutionFound) {
            solutionSteps.add(state);
        }
    }


    private static Set<State> visited = new HashSet<>();

    private static Set<Set<String>> getCombinations(Set<String> set) {
        return Sets.powerSet(set).stream().filter(s -> s.size() > 0 && s.size() <= 3 && s.size() <= set.size()).filter(State::isValid).collect(Collectors.toSet());
    }

    private static boolean isFinalState(State state) {
        return state.getLeftBank().isEmpty() && state.getRightBank().containsAll(ALL) && !state.isDirection();
    }

}

class State {
    private Set<String> leftBank;
    private Set<String> rightBank;
    private Set<String> boat;

    private boolean direction;

    public boolean isDirection() {
        return direction;
    }

    public State(Set<String> leftBank, Set<String> rightBank, boolean direction, Set<String> boat) {
        this.leftBank = leftBank;
        this.rightBank = rightBank;
        this.direction = direction;
        this.boat = boat;
    }

    public Set<String> getLeftBank() {
        return leftBank;
    }

    public Set<String> getRightBank() {
        return rightBank;
    }

    public static boolean isValid(Set<String> l, Set<String> r) {
        return isValid(l) && isValid(r);
    }

    public boolean isValid() {
        return isValid(leftBank) && isValid(rightBank);
    }

    public static boolean isValid(Set<String> bank) {
        if (bank.size() == 0) {
            return true;
        }
        final Set<String> knights = bank.stream().filter(p -> p.substring(0, 1).equals("K")).collect(Collectors.toSet());
        final Set<String> pages = bank.stream().filter(p -> p.substring(0, 1).equals("P")).collect(Collectors.toSet());


        if (knights.size() == 0) {
            return true;
        }

        if (pages.size() > knights.size()) {
            return false;
        }

        for (String page : pages) {
            if (!knights.contains("K" + page.substring(1, 2))) {
                return false;
            }
        }

        return true;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return direction == state.direction &&
                Objects.equals(leftBank, state.leftBank) &&
                Objects.equals(rightBank, state.rightBank);
    }

    @Override
    public int hashCode() {

        return Objects.hash(leftBank, rightBank, direction);
    }

    @Override
    public String toString() {
        return String.format("%s %s((%s)) %s", leftBank, (direction ? "->" : "<-"), (boat == null ? "-" : boat), rightBank);
    }

}
