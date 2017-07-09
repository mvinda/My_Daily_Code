package jin.jin;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    static {
        System.loadLibrary("MyJni");//导入生成的链接库文件
    }


    public native String getStringFromNative();//本地方法
    public native String getString_From_c();


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.myjni);
        System.out.println(getStringFromNative());
    }

    public void onClick(View view) {
        System.out.println(getString_From_c());
        Toast.makeText(this, getStringFromNative(), Toast.LENGTH_LONG).show();
    }

}


