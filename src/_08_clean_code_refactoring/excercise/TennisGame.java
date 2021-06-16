package _08_clean_code_refactoring.excercise;

public class TennisGame {

    public static String getFinalScore(String player1Name, String player2Name, int player1Score, int player2Score) {
        boolean isEqualScore = player1Score == player2Score;
        boolean isAdvantage = player1Score >= 4 || player2Score >= 4;
        if (isEqualScore) {
            return getEqualScore(player1Score);
        } else if (isAdvantage) {
            return getAdvantage(player1Score, player2Score);
        } else {
            return getDefault(player1Score, player2Score);
        }
    }

    public static String getEqualScore(int player1Score) {
        String finalResult = "";
        switch (player1Score) {
            case 0:
                finalResult = "Love-All";
                break;
            case 1:
                finalResult = "Fifteen-All";
                break;
            case 2:
                finalResult = "Thirty-All";
                break;
            case 3:
                finalResult = "Forty-All";
                break;
            default:
                finalResult = "Deuce";
                break;

        }
        return finalResult;
    }

    public static String getAdvantage(int player1Score, int player2Score) {
        String finalResult = "";
        int differentScore = player1Score - player2Score;

        if (differentScore == 1) {
            finalResult = "Advantage player1";
        } else if (differentScore == -1) {
            finalResult = "Advantage player2";
        } else if (differentScore >= 2) {
            finalResult = "Win for player1";
        } else {
            finalResult = "Win for player2";
        }
        return finalResult;
    }

    public static String getDefault(int player1Score, int player2Score) {
        String finalResult = "";
        int tempScore = 0;
        for (int i = 1; i < 3; i++) {
            if (i == 1) {
                tempScore = player1Score;
            } else {
                finalResult += "-";
                tempScore = player2Score;
            }
            finalResult += checkTempScore(tempScore);
        }
        return finalResult;
    }

    public static String checkTempScore(int tempScore) {
        String finalResult = "";
        switch (tempScore) {
            case 0:
                finalResult += ("Love");
                break;
            case 1:
                finalResult += ("Fifteen");
                break;
            case 2:
                finalResult += ("Thirty");
                break;
            case 3:
                finalResult += ("Forty");
                break;
        }
        return finalResult;
    }
}

