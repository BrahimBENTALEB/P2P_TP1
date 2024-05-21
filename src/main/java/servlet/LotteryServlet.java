package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.LotteryDAO;
import model.Lottery;
@WebServlet(name = "LotteryServlet", urlPatterns = {"/lottery"})
public class LotteryServlet extends HttpServlet {
    private LotteryDAO lotteryDAO;

    public LotteryServlet(LotteryDAO lotteryDAO) {
        this.lotteryDAO = lotteryDAO;
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
                    listLotteries(request, response);
                    break;
                case "create":
                    showCreateForm(request, response);
                    break;
                case "update":
                    showUpdateForm(request, response);
                    break;
                case "delete":
                    deleteLottery(request, response);
                    break;
                default:
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
            }
        } catch (Exception e) {
            throw new ServletException("Failed to process request", e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            switch (action) {
                case "create":
                    createLottery(request, response);
                    break;
                
                default:
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
            }
        } catch (Exception e) {
            throw new ServletException("Failed to process request", e);
        }
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String action = request.getParameter("action");

    try {
        switch (action) {
            case "update":
                updateLottery(request, response);
                break;
            default:
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
        }
    } catch (Exception e) {
        throw new ServletException("Failed to process request", e);
    }
}

protected void doDelete(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String action = request.getParameter("action");

    try {
        switch (action) {
            case "delete":
                deleteLottery(request, response);
                break;
            default:
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
        }
    } catch (Exception e) {
        throw new ServletException("Failed to process request", e);
    }
}

    private void listLotteries(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Lottery> lotteries = lotteryDAO.getAllLotteries();
        request.setAttribute("lotteries", lotteries);
        request.getRequestDispatcher("lotteries.jsp").forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("createLottery.jsp").forward(request, response);
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Lottery lottery = lotteryDAO.getLotteryById(id);
        request.setAttribute("lottery", lottery);
        request.getRequestDispatcher("updateLottery.jsp").forward(request, response);
    }

    private void deleteLottery(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        lotteryDAO.deleteLottery(id);
        response.sendRedirect("list");
    }

    private void createLottery(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Lottery lottery = extractLotteryFromRequest(request);
        lotteryDAO.createLottery(lottery);
        response.sendRedirect("list");
    }

    private void updateLottery(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Lottery lottery = extractLotteryFromRequest(request);
        lotteryDAO.updateLottery(lottery);
        response.sendRedirect("list");
    }

    private Lottery extractLotteryFromRequest(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        String lotteryName = request.getParameter("lottery_name");
        LocalDate startDate = LocalDate.parse(request.getParameter("start_date"));
        LocalDate endDate = LocalDate.parse(request.getParameter("end_date"));
        String winningNumbers = request.getParameter("winning_numbers");

        Lottery lottery = new Lottery();
        lottery.setId(id);
        lottery.setLotteryName(lotteryName);
        lottery.setStartDate(startDate);
        lottery.setEndDate(endDate);
        lottery.setWinningNumbers(winningNumbers);

        return lottery;
    }
}
