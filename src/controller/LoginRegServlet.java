package controller;

import services.QuestionAnswerGenerator;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Sushant on 6/22/2016.
 */
public class LoginRegServlet extends javax.servlet.http.HttpServlet {
    QuestionAnswerGenerator questionAnswerGenerator = new QuestionAnswerGenerator();
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String randNum = randomNumberGenerator();
        String[] aftersplit;
        String question = "";
        String[] answer = new String[5];
        aftersplit = randNum.split(",", 2);
        String nums = aftersplit[0];
        int num = Integer.parseInt(nums);
        try {
            question = questionAnswerGenerator.questionGenerator(num);
            answer=questionAnswerGenerator.answerGenerator(num);
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
    protected static String randomNumberGenerator() {
        int size = 25;
        String numbers="";
        int[] a = new int[10];
        ArrayList<Integer> list = new ArrayList<Integer>(size);
        for(int i = 1; i <= size; i++) {
            list.add(i);
        }

        Random rand = new Random();
        int i=0;
        while(list.size() > 0&&i<10) {
            int index = rand.nextInt(list.size());
            a[i]=list.remove(index);
            i++;
        }
        numbers+=String.valueOf(a[0]);
        for(int j = 1;j<10;j++){
            numbers=numbers+","+String.valueOf(a[j]);
        }
        return numbers;
    }
}
