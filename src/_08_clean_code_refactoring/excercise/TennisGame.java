package _08_clean_code_refactoring.excercise;

public class TennisGame {

    public static String getFinalScore(String player1Name, String player2Name, int player1Score, int player2Score) {
        String finalScore = "";
        boolean equalScore = player1Score == player2Score;
        boolean player1ScoreLargerThanFour = player1Score >= 4;
        boolean player2ScoreLargerThanFour = player2Score >= 4;
        if (equalScore) {
            finalScore = equalScore(player1Score);
        } else if (player1ScoreLargerThanFour || player2ScoreLargerThanFour) {
            finalScore = differentScore(player1Score, player2Score);
        } else {
            finalScore = getDefault(player1Score, player2Score);
        }
        return finalScore;
    }

    public static String equalScore(int player1Score) {
        String finalScore = "";
        switch (player1Score) {
            case 0:
                finalScore = "Love-All";
                break;
            case 1:
                finalScore = "Fifteen-All";
                break;
            case 2:
                finalScore = "Thirty-All";
                break;
            case 3:
                finalScore = "Forty-All";
                break;
            default:
                finalScore = "Deuce";
                break;

        }
        return finalScore;
    }

    public static String differentScore(int player1Score, int player2Score) {
        String finalScore = "";
        int differentScore = player1Score - player2Score;
        if (differentScore == 1) {
            finalScore = "Advantage player1";
        } else if (differentScore == -1) {
            finalScore = "Advantage player2";
        } else if (differentScore >= 2) {
            finalScore = "Win for player1";
        } else {
            finalScore = "Win for player2";
        }
        return finalScore;
    }

    public static String getDefault(int player1Score, int player2Score) {
        String finalScore = "";
        String subtraction  = "-";
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) {
                tempScore = player1Score;
            } else {
                finalScore+= (subtraction);
                tempScore = player2Score;
            }
            switch (tempScore) {
                case 0:
                    finalScore+=("Love");
                    break;
                case 1:
                    finalScore+=("Fifteen");
                    break;
                case 2:
                    finalScore+=("Thirty");
                    break;
                case 3:
                    finalScore+=("Forty");
                    break;
            }
        }
        return finalScore;
    }
}
