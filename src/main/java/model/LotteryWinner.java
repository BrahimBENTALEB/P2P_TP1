package model;

public class LotteryWinner {
    private int id;
    private int userId;
    private int lotteryWinnerId;
    private int winnings;

    // getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getLotteryWinnerId() {
        return lotteryWinnerId;
    }

    public void setLotteryWinnerId(int lotteryWinnerId) {
        this.lotteryWinnerId = lotteryWinnerId;
    }

    public int getWinnings() {
        return winnings;
    }

    public void setWinnings(int winnings) {
        this.winnings = winnings;
    }
}