package tools.wpfang.asynctask01;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MyTextTask extends AsyncTask<Void,Integer,String> {
    ProgressDialog pd;
    Context mContext;
    TextView tv;
    public MyTextTask(Context ct,TextView txt)
    {
        mContext=ct;
        tv=txt;
    }
    @Override
    protected void onPreExecute() {
        pd=new ProgressDialog(mContext);
        pd.setTitle("Downloading");
        pd.setMessage("Please wait!!!");
        pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pd.setButton(ProgressDialog.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                cancel(true);
            }
        });
        pd.setMax(100);
        pd.show();

    }
    @Override
    protected String doInBackground(Void... voids) {
        try {
        for(int i=0;i<=100;i++) {
               Thread.sleep(100);
                publishProgress(i);
                Log.i("ASYNCTASKTHREAD","Thread"+i);
        }
        return "Successful";
        } catch (InterruptedException e) {
            e.printStackTrace();
            return "Failure";
        }
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
          int progress=values[0];
          pd.setProgress(progress);
    }

    @Override
    protected void onPostExecute(String s) {
       tv.setText(s);
        pd.dismiss();
    }
}
