package link;

/*
 *@program:spider
 *:
 *@author：Mr.Peng
 *@creatt:2018-07-17**/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BuffInputStream {


    public static void main(String[] args) throws IOException {
        boolean  state =true;
        String msg = null;
        String a = 32+"";
        System.out.println(Integer.valueOf(a).getClass().getSimpleName());
        BufferedReader buffered=new BufferedReader( new InputStreamReader(System.in));
        while(state){
            msg= buffered.readLine();
            if(msg!=null)
            System.out.println(msg);
            else {
                state=false;
            }
        }

    }


}
