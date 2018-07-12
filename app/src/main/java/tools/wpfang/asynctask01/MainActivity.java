package tools.wpfang.asynctask01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    int counter=0;
    MyTextTask myTextTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.data_txt);
    }


    public void doChange(View view) {
        myTextTask=new MyTextTask(this,tv);
        myTextTask.execute();
    }
}
