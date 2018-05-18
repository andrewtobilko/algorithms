package com.tobilko.ai.lab24;


import com.google.common.collect.Sets;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toSet;

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
        A_STAR_SEARCH(initialState);
    }

    private static void A_STAR_SEARCH(State initialState) {
        Set<State> closedSet = new HashSet<>();
        Set<State> openSet = new HashSet<>(Arrays.asList(initialState));

        Map<State, State> cameFrom = new HashMap<>();
        Map<State, Integer> gScore = new HashMap<>();
        gScore.put(initialState, 1);

        Map<State, Integer> fScore = new HashMap<>();
        fScore.put(initialState, estimateHeuristicCost(initialState));

        while (openSet.size() > 0) {

            Map.Entry<State, Integer> currentEntry = fScore.entrySet().stream().min(Comparator.comparing(Map.Entry::getValue)).get();
            State currentState = currentEntry.getKey();

            if (currentState.getRightBank().containsAll(ALL)) {
                State cS = new State(currentState.getLeftBank(), currentState.getRightBank(), currentState.isDirection(), currentState.getBoat());
                List<State> states = new ArrayList<State>() {{ add(null);}};
                states.add(cS);

                while (cameFrom.get(cS) != null) {
                    cS = cameFrom.get(cS);
                    states.add(cS);
                }

                //states.stream().filter(Objects::nonNull).forEach(System.out::println);
                System.out.print("A* = ");
                System.out.print(states.size());
                System.out.println(" " + closedSet.size());

                return;
            }

            openSet.remove(currentState);
            closedSet.add(currentState);
            fScore.remove(currentState);


            final Set<Set<String>> combinations = getCombinations(currentState.isDirection() ? currentState.getLeftBank() : currentState.getRightBank());

            final boolean currentDirection = !currentState.isDirection();


            final List<State> neighbors = combinations
                    .stream()
                    .map(c -> new State(new HashSet<>(currentState.getLeftBank()), new HashSet<>(currentState.getRightBank()), currentDirection, c))
                    .collect(Collectors.toList());

            for (State neighbor : neighbors) {

                if (closedSet.contains(neighbor)) {
                    continue;
                }

                if (!openSet.contains(neighbor)) {

                    openSet.add(neighbor);

                    (!currentDirection ? neighbor.getLeftBank() : neighbor.getRightBank()).removeAll(neighbor.getBoat());
                    (!currentDirection ? neighbor.getRightBank() : neighbor.getLeftBank()).addAll(neighbor.getBoat());

//                    if (!neighbor.isValid()) {
//                        continue;
//                    }
                }

//                (!currentDirection ? neighbor.getLeftBank() : neighbor.getRightBank()).removeAll(neighbor.getBoat());
//                (!currentDirection ? neighbor.getRightBank() : neighbor.getLeftBank()).addAll(neighbor.getBoat());

//                if (!neighbor.isValid()) {
//                    continue;
//                }

                int tentativeGScore = gScore.get(currentState) + 1;
                if (tentativeGScore >= gScore.getOrDefault(neighbor, Integer.MAX_VALUE)) {
                    continue;
                }

                cameFrom.put(neighbor, currentState);
                gScore.put(neighbor, tentativeGScore);
                fScore.put(neighbor, gScore.get(neighbor) + estimateHeuristicCost(neighbor));

            }

        }

    }

    private static int estimateHeuristicCost(State from) {
        return ALL.size() - from.getRightBank().size();
    }

    private static void DFS(State initialState) {
        visited.add(initialState);
        goToNextStateDFS(initialState);

        for (int i = solutionSteps.size() - 1; i >= 0; --i) {
            System.out.println(solutionSteps.get(i));
        }
        System.out.println(" DFS = " + solutionSteps.size() + " " + visitedStates);
    }

    private static void BFS(State initialState) {
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
                    //System.out.println("The final state is " + stateFromQueue);
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
        return Sets.powerSet(set).stream().filter(s -> s.size() > 0 && s.size() <= 3 && s.size() <= set.size()).filter(State::isValid).collect(toSet());
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

    public Set<String> getBoat() {
        return boat;
    }

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

    public boolean isValid() {
        return isValid(leftBank) && isValid(rightBank);
    }

    public static boolean isValid(Set<String> bank) {
        if (bank.size() == 0) {
            return true;
        }
        final Set<String> knights = bank.stream().filter(p -> p.substring(0, 1).equals("K")).collect(toSet());
        final Set<String> pages = bank.stream().filter(p -> p.substring(0, 1).equals("P")).collect(toSet());


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
