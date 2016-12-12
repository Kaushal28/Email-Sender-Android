package purvil12c.email0;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

/**
 * Created by kaushal28 on 9/11/16.
 */

public class task extends AsyncTask<MimeMessage, Integer,Long>{



    @Override
    protected Long doInBackground(MimeMessage... strings) {
        try{
            System.out.println("in background");
            Transport.send(strings[0]);
        }
        catch (Exception e){
        //    Toast.makeText(c,e.getMessage(),Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
        return null;
    }
}
