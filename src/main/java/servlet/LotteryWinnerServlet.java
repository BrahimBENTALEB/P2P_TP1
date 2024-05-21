package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.LotteryWinnerDAO;
import model.LotteryWinner;
@WebServlet(name = "LotteryWinnerServlet", urlPatterns = {"/lotteryWinner"})
public class LotteryWinnerServlet extends HttpServlet {
    private final LotteryWinnerDAO lotteryWinnerDAO;

    public LotteryWinnerServlet(LotteryWinnerDAO lotteryWinnerDAO) {
        this.lotteryWinnerDAO = lotteryWinnerDAO;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null || action.isEmpty()) {
            response.sendRedirect("list");
            return;
        }

        try {
            switch (action) {
                case "list":
                    listLotteryWinners(request, response);
                    break;
                case "create":
                    showCreateForm(request, response);
                    break;
                case "update":
                    showUpdateForm(request, response);
                    break;
                case "delete":
                    deleteLotteryWinner(request, response);
                    break;
                default:
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
            }
        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            switch (action) {
                case "create":
                    createLotteryWinner(request, response);
                    break;
                
                default:
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
            }
        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        }
    }
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String action = request.getParameter("action");

    try {
        switch (action) {
            case "update":
                updateLotteryWinner(request, response);
                break;
            default:
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
        }
    } catch (SQLException e) {
        throw new ServletException("Database error", e);
    }
}

protected void doDelete(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String action = request.getParameter("action");

    try {
        switch (action) {
            case "delete":
                deleteLotteryWinner(request, response);
                break;
            default:
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
        }
    } catch (Exception e) {
        throw new ServletException("Database error", e);
    }
}


    private void listLotteryWinners(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        List<LotteryWinner> winners = lotteryWinnerDAO.getAllLotteryWinners();
        request.setAttribute("winners", winners);
        request.getRequestDispatcher("/WEB-INF/lotteryWinners.jsp").forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/createLotteryWinner.jsp").forward(request, response);
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        LotteryWinner winner = lotteryWinnerDAO.getLotteryWinnerById(id);
        request.setAttribute("winner", winner);
        request.getRequestDispatcher("/WEB-INF/updateLotteryWinner.jsp").forward(request, response);
    }

    private void deleteLotteryWinner(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        lotteryWinnerDAO.deleteLotteryWinner(id);
        response.sendRedirect("list");
    }

    private void createLotteryWinner(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        LotteryWinner winner = extractLotteryWinnerFromRequest(request);
        lotteryWinnerDAO.createLotteryWinner(winner);
        response.sendRedirect("list");
    }

    private void updateLotteryWinner(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        LotteryWinner winner = extractLotteryWinnerFromRequest(request);
        lotteryWinnerDAO.updateLotteryWinner(winner);
        response.sendRedirect("list");
    }

    private LotteryWinner extractLotteryWinnerFromRequest(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        int userId = Integer.parseInt(request.getParameter("user_id"));
        int lotteryWinnerId = Integer.parseInt(request.getParameter("lottery_winner_id"));
        int winnings = Integer.parseInt(request.getParameter("winnings"));

        LotteryWinner winner = new LotteryWinner();
        winner.setId(id);
        winner.setUserId(userId);
        winner.setLotteryWinnerId(lotteryWinnerId);
        winner.setWinnings(winnings);

        return winner;
    }
}
