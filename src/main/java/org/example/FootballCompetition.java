package org.example;

import java.io.*;
import java.util.*;

public class FootballCompetition {

    public static void main(String[] args) {
        String inputFile = "/Users/prakash/Downloads/codingtest/src/main/resources/input.txt"; // Set the path to your input file here
        Map<String, Team> teams = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                processMatch(line, teams);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        List<Team> teamList = new ArrayList<>(teams.values());
        Collections.sort(teamList);

        printResults(teamList);
    }

    private static void processMatch(String match, Map<String, Team> teams) {
        String[] parts = match.split(";");
        String team1Name = parts[0];
        String team2Name = parts[1];
        String result = parts[2];

        Team team1 = teams.computeIfAbsent(team1Name, Team::new);
        Team team2 = teams.computeIfAbsent(team2Name, Team::new);

        if ("win".equals(result)) {
            team1.recordWin();
            team2.recordLoss();
        } else {
            team2.recordWin();
            team1.recordLoss();
        }
    }

    private static void printResults(List<Team> teams) {
        System.out.println(String.format("%-30s | %2s | %2s | %2s | %2s", "Team", "MP", "W", "L", "P"));
        for (Team team : teams) {
            System.out.println(team);
        }
    }
}

