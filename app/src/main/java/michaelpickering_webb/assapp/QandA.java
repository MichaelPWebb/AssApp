package michaelpickering_webb.assapp;

/**
 * Created by michael on 11/08/2016.
 */
public class QandA {

    private String Question = "";
    private String Answer = "";
    private String Answer1 = "";
    private String Answer2 = "";
    private String Answer3 = "";
    private String Answer4 = "";

    public QandA(String Q, String A, String A1, String A2, String A3, String A4){

        Question = Q;
        Answer = A;
        Answer1 = A1;
        Answer2 = A2;
        Answer3 = A3;
        Answer4 = A4;

    }

    public String getQuestion(){

        return Question;
    }

    public String getAnswer(){

        return Answer;
    }

    public String getAnswer1(){

        return Answer1;
    }

    public String getAnswer2(){

        return Answer2;
    }

    public String getAnswer3(){

        return Answer3;
    }

    public String getAnswer4(){

        return Answer4;
    }

}
