package dao;

import model.User;
import util.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDAO {
    


    public List<User> getAllUsers() throws SQLException{
        List<User> users = new ArrayList<>();
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            
            conn = DatabaseConnector.getConnection();
            preparedStatement = conn.prepareStatement("SELECT * FROM users");
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                users.add(user);
            }
        }finally {
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
        return users;
    }

    public User getUserById(int id) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;


        try {
           
            conn = DatabaseConnector.getConnection();
            preparedStatement = conn.prepareStatement("SELECT * FROM users WHERE id = " + id);
            rs = preparedStatement.executeQuery();


            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                return user;
            }
        } catch (SQLException e) {
            // handle exception
        }
        finally {
            // Close resources
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    // handle exception
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    // handle exception
                }
            }
            if (conn != null) {
                DatabaseConnector.closeConnection(conn);
            }
        }
        return null;
    }

    public void createUser(User user) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
       
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO users (name, email, password) VALUES (?, ?, ?)");
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();
        } catch (SQLException e) {
            // handle exception
        }
        finally {
            // Close resources
            
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    // handle exception
                }
            }
            if (conn != null) {
                DatabaseConnector.closeConnection(conn);
            }
        }
    }

    public void updateUser(User user) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
       
        try {
            PreparedStatement stmt = conn.prepareStatement("UPDATE users SET name = ?, email = ?, password = ? WHERE id = ?");
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setInt(4, user.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            // handle exception
        }
        finally {
            // Close resources
           
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    // handle exception
                }
            }
            if (conn != null) {
                DatabaseConnector.closeConnection(conn);
            }
        }
    }

    public void deleteUser(int id) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
       
        try {
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM users WHERE id = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            // handle exception
        }
        finally {
            // Close resources
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    // handle exception
                }
            }
            if (conn != null) {
                DatabaseConnector.closeConnection(conn);
            }
        }
    }
}