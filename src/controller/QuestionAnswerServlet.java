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
    QuestionAnswerGenerator questionAnswerGenerator  = new QuestionAnswerGenerator();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String randNum = request.getParameter("randNum");
        String correct = request.getParameter("correct");
        String choosen = request.getParameter("choosen");
        System.out.println("choosen = " + choosen);
        System.out.println(" randNum = "+ randNum);
        if(choosen == correct){
            String[] aftersplit;
            String question = "";
            String[] answer = new String[5];
            if(randNum.length()>3 && randNum!=""){
                System.out.println("1");
                aftersplit = randNum.split(",", 2);
            }
            else if (randNum.length() >= 1){
                aftersplit = (randNum.split(","));
                System.out.println("2");
            }
            else {
                System.out.println("3");
                randNum="-,-";
                aftersplit = randNum.split(",");
            }
            for(String item: aftersplit){
                System.out.println("item = " + item);
            }
            if(aftersplit[0].equals("-")&&aftersplit[1].equals("-")){
                request.setAttribute("score",100);
                request.getRequestDispatcher("/views/lastPage.jsp").forward(request,response);
            }
            else{
                try {
                    question = questionAnswerGenerator.questionGenerator(Integer.parseInt(aftersplit[0]));
                    System.out.println("question = " + question);
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
                if(aftersplit.length>1){
                    request.setAttribute("randNum",aftersplit[1]);
                }
                else{
                    request.setAttribute("randNum","");
                }
                request.getRequestDispatcher("/views/quizPage.jsp").forward(request, response);
            }
        }
        else{
            int score = 0;
            score = (9 - (randNum.length()/2+1))*10;
            request.setAttribute("score",score);
            request.getRequestDispatcher("/views/lastPage.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
