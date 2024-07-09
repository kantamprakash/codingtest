package org.example;

public class Team implements Comparable<Team> {
    private String name;
    private int matchesPlayed;
    private int matchesWon;
    private int matchesLost;
    private int points;

    public Team(String name) {
        this.name = name;
    }

    public void recordWin() {
        matchesPlayed++;
        matchesWon++;
        points += 3;
    }

    public void recordLoss() {
        matchesPlayed++;
        matchesLost++;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public int compareTo(Team other) {
        if (this.points != other.points) {
            return other.points - this.points;
        }
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return String.format("%-30s | %2d | %2d | %2d | %2d", name, matchesPlayed, matchesWon, matchesLost, points);
    }
}

