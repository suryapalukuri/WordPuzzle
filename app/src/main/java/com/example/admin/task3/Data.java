package com.example.admin.task3;

public class Data {
    String words[][]={{"S","O","W","N"},
            {"A","R","N","I"},
            {"S","I","H","P"},{"C","U","E","L"}};
    static String correctAnswer[]={"SNOW","RAIN","SHIP","CLUE"};
    public String getWords1(int a){
       String word=words[a][0];
       return word;

    }
    public String getWords2(int a){
        String word=words[a][1];
        return word;

    }
    public String getWords3(int a){
        String word=words[a][2];
        return word;

    }
    public String getWords4(int a){
        String word=words[a][3];
        return word;

    }

    public String getCorrectAnswer(int a) {
        String answer=correctAnswer[a];
        return answer;
    }
}
