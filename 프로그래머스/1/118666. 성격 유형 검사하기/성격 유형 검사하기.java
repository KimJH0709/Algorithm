class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        int len = survey.length;
        
        int[] score = new int[4];
        // RT, CF, JM, AN
        
        for (int i = 0; i < len; i++) {
            if(survey[i].equals("RT")) score[0] -= choices[i] - 4;
            if(survey[i].equals("CF")) score[1] -= choices[i] - 4;
            if(survey[i].equals("JM")) score[2] -= choices[i] - 4;
            if(survey[i].equals("AN")) score[3] -= choices[i] - 4;
            
            if(survey[i].equals("TR")) score[0] += choices[i] - 4;
            if(survey[i].equals("FC")) score[1] += choices[i] - 4;
            if(survey[i].equals("MJ")) score[2] += choices[i] - 4;
            if(survey[i].equals("NA")) score[3] += choices[i] - 4;
        }
        
        if(score[0] >= 0) answer+= "R"; else answer+= "T";
        if(score[1] >= 0) answer+= "C"; else answer+= "F";
        if(score[2] >= 0) answer+= "J"; else answer+= "M";
        if(score[3] >= 0) answer+= "A"; else answer+= "N";
        
        return answer;
    }
}


/*
RT
CF
JM
AN
*/