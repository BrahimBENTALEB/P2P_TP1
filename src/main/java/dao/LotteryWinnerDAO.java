package dao;

import util.DatabaseConnector;

import model.LotteryWinner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.util.ArrayList;
import java.util.List;

public class LotteryWinnerDAO {
    

   
    public List<LotteryWinner> getAllLotteryWinners() throws SQLException {
        List<LotteryWinner> winners = new ArrayList<>();
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            conn = DatabaseConnector.getConnection();
            preparedStatement = conn.prepareStatement("SELECT * FROM lottery_winners");
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                LotteryWinner winner = new LotteryWinner();
                winner.setId(rs.getInt("id"));
                winner.setUserId(rs.getInt("user_id"));
                winner.setLotteryWinnerId(rs.getInt("lottery_winner_id"));
                winner.setWinnings(rs.getInt("winnings"));
                winners.add(winner);
            }
        } finally {
            // Close resources
            if (rs != null) {
                rs.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (conn != null) {
                DatabaseConnector.closeConnection(conn);
            }
        }
        return winners;
    }
    
    public LotteryWinner getLotteryWinnerById(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            conn = DatabaseConnector.getConnection();
            preparedStatement = conn.prepareStatement("SELECT * FROM lottery_winners WHERE id = " + id);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                LotteryWinner winner = new LotteryWinner();
                winner.setId(rs.getInt("id"));
                winner.setUserId(rs.getInt("user_id"));
                winner.setLotteryWinnerId(rs.getInt("lottery_winner_id"));
                winner.setWinnings(rs.getInt("winnings"));
                return winner;
            }
        } finally {
            // Close resources
            if (rs != null) {
                rs.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (conn != null) {
                DatabaseConnector.closeConnection(conn);
            }
        }
        return null;
    }
    
    public void createLotteryWinner(LotteryWinner winner) throws SQLException{
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
                conn = DatabaseConnector.getConnection();
            preparedStatement = conn.prepareStatement("INSERT INTO lottery_winners (user_id, lottery_winner_id, winnings) VALUES (?, ?, ?)");
            rs = preparedStatement.executeQuery();
            preparedStatement.setInt(1, winner.getUserId());
            preparedStatement.setInt(2, winner.getLotteryWinnerId());
            preparedStatement.setInt(3, winner.getWinnings());
            preparedStatement.executeUpdate();
        }
        finally {
            // Close resources
            if (rs != null) {
                rs.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (conn != null) {
                DatabaseConnector.closeConnection(conn);
            }
        }

    }
    
    public void updateLotteryWinner(LotteryWinner winner) {
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement("UPDATE lottery_winners SET user_id = ?, lottery_winner_id = ?, winnings = ? WHERE id = ?")) {
            stmt.setInt(1, winner.getUserId());
            stmt.setInt(2, winner.getLotteryWinnerId());
            stmt.setInt(3, winner.getWinnings());
            stmt.setInt(4, winner.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            // handle exception
        }
    }
    
    public void deleteLotteryWinner(int id) {
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM lottery_winners WHERE id = ?")) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            // handle exception
        }
    } 
}
    