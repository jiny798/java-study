package BOJ.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열_폭발 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer str = new StringBuffer(br.readLine());
        String bomb = br.readLine();
        int index;
        while (str.indexOf(bomb) != -1) { // 1234 에 12가 있다는 뜻
            index = str.indexOf(bomb);
            str.replace(index,index+bomb.length(),"");
            if(str.length() ==0){
                break;
            }
        }

        if(str.length()==0){
            str.append("FRULA");
        }

        System.out.println(str);

    }
}
