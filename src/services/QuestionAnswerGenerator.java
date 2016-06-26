package services;

import database.DatabaseConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Sushant on 6/24/2016.
 */
public class QuestionAnswerGenerator {

    public String questionGenerator(int randnum) throws SQLException, ClassNotFoundException {
        System.out.println(randnum);
        Connection databaseconnector = new DatabaseConnector().getConn();
        String currentQuestionline="";
        String sql = "select * from question where id = "+randnum+"";
        Statement stmt = databaseconnector.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);
        while(resultSet.next()){
            currentQuestionline = resultSet.getString("question");
        }
        databaseconnector.close();
        return currentQuestionline;
    }
    public static String[] answerGenerator(int randnum) throws ClassNotFoundException, SQLException {
        Connection databaseconnector = new DatabaseConnector().getConn();
        String[] answers = new String[5];
        int right = 0;
        int lineNumber = 1;
        int[] assignNumber = new int[4];
        int[] assignNumber2 = new int[4];
        String sql = "select * from answer where id="+randnum+"";
        Statement stmt = databaseconnector.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);
        while (resultSet.next()) {
            if(true)
            {

                assignNumber[0]=2;

                for(int i=1;i<4;i++)
                {
                    int nu = (int)(Math.random()*6+2);
                    assignNumber[i]=nu;
                    for(int j=0;j<i;j++)
                    {
                        if(nu==assignNumber[j]){
                            i--;
                            continue;
                        }
                    }
                }
                for(int i=0;i<4;i++)
                {
                    int nums1 = (int)(Math.random()*4);
                    assignNumber2[i]=nums1;

                    for(int j=0;j<i;j++)
                    {
                        if(nums1==assignNumber2[j])
                        {
                            i--;
                            continue;
                        }
                    }
                }
                for(int i=0;i<4;i++)
                {
                    answers[assignNumber2[i]]=resultSet.getString(assignNumber[i]);
                    //System.out.println("answers["+i+"] = " + answers[i]);
                }
                answers[4]=resultSet.getString(2);

            }
        }
        return answers;
    }
}
