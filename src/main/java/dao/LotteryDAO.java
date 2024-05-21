package dao;
import util.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import model.Lottery;

import java.util.ArrayList;
import java.util.List;
import java.sql.Date;


public class LotteryDAO {
    public void createLottery(Lottery lottery) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "INSERT INTO lotteries (lottery_name, start_date, end_date, winning_numbers) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, lottery.getLotteryName());
            stmt.setDate(2, Date.valueOf(lottery.getStartDate()));
            stmt.setDate(3, Date.valueOf(lottery.getEndDate()));
            stmt.setString(4, lottery.getWinningNumbers());
            stmt.executeUpdate();
        } catch (SQLException e) {
            // handle exception
        }
    }
    public void updateLottery(Lottery lottery) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "UPDATE lotteries SET lottery_name = ?, start_date = ?, end_date = ?, winning_numbers = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, lottery.getLotteryName());
            stmt.setDate(2,Date.valueOf(lottery.getStartDate()) );
            stmt.setDate(3,Date.valueOf(lottery.getEndDate()) );
            stmt.setString(4, lottery.getWinningNumbers());
            stmt.setInt(5, lottery.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            // handle exception
        }
    }

    public void deleteLottery(int id) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "DELETE FROM lotteries WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            // handle exception
        }
    }
    public List<Lottery> getAllLotteries() {
        List<Lottery> lotteries = new ArrayList<>();
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "SELECT * FROM lotteries";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Lottery lottery = new Lottery();
                lottery.setId(rs.getInt("id"));
                lottery.setLotteryName(rs.getString("lottery_name"));
                lottery.setStartDate(LocalDate.parse(rs.getDate("start_date").toString()));
                lottery.setEndDate(LocalDate.parse(rs.getDate("end_date").toString()));
                lottery.setWinningNumbers(rs.getString("winning_numbers"));
                lotteries.add(lottery);
            }
        } catch (SQLException e) {
            // handle exception
        }
        return lotteries;
    }

    public Lottery getLotteryById(int id) {
        Lottery lottery = new Lottery();
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "SELECT * FROM lotteries WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                lottery.setId(rs.getInt("id"));
                lottery.setLotteryName(rs.getString("lottery_name"));
                lottery.setStartDate(LocalDate.parse(rs.getDate("start_date").toString()));
                lottery.setEndDate(LocalDate.parse(rs.getDate("end_date").toString()));
                lottery.setWinningNumbers(rs.getString("winning_numbers"));
            }
        } catch (SQLException e) {
            // handle exception
        }
        return lottery;
    }
}