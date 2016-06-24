package controller;

import services.QuestionAnswerGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Sushant on 6/24/2016.
 */
public class QuestionAnswerServlet extends HttpServlet {
    QuestionAnswerGenerator questionAnswerGenerator;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String randNum = request.getParameter("randNum");
        String correct = request.getParameter("correct");
        String choosen = request.getParameter("man");
        System.out.println("choosen + correct = " + choosen + correct);
        String[] aftersplit;
        String question = "";
        String[] answer = new String[5];
        aftersplit = randNum.split(",", 2);
        try {
            question = questionAnswerGenerator.questionGenerator(Integer.parseInt(aftersplit[0]));
            answer=questionAnswerGenerator.answerGenerator(Integer.parseInt(aftersplit[0]));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.setAttribute("answer1",answer[0]);
        request.setAttribute("answer2",answer[1]);
        request.setAttribute("answer3",answer[2]);
        request.setAttribute("answer4",answer[3]);
        request.setAttribute("correct",answer[4]);
        request.setAttribute("question",question);
        request.setAttribute("randNum",aftersplit[1]);
        request.getRequestDispatcher("/views/quizPage.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
