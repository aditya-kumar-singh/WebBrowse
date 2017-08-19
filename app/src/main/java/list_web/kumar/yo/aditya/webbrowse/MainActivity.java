package list_web.kumar.yo.aditya.webbrowse;

import android.content.DialogInterface;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

import com.spark.submitbutton.SubmitButton;

public class MainActivity extends AppCompatActivity {
    EditText et;
    SubmitButton sb,sb1,sb2; WebView wb;String w;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = (EditText) findViewById(R.id.edt);
        sb = (SubmitButton) findViewById(R.id.submit);
        sb1=(SubmitButton)findViewById(R.id.back);
        sb2=(SubmitButton)findViewById(R.id.forward);

        wb = (WebView) findViewById(R.id.web);
    }

    public void sub(View v){

        w="http://";
        w=w+et.getText().toString()+".com";
        wb.loadUrl(w);
        wb.getSettings().setJavaScriptEnabled(true);
        wb.setWebViewClient(new BrowseNew());

    }
    public void back(View v){
        if(wb.canGoBack()){
            wb.goBack();
        }
    }
    public void forward(View v){
        if(wb.canGoForward()){
            wb.goForward();
        }
    }


        class BrowseNew extends WebViewClient {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    view.loadUrl(request.getUrl().toString());
                }

return true;
            }


        }

    @Override
    public void onBackPressed() {
        if(wb.canGoBack()){
            wb.goBack();
        }
        else {
            AlertDialog.Builder bui= new AlertDialog.Builder(MainActivity.this);
            bui.setMessage("Are You sure you want to exit?");
            bui.setCancelable(false);
            bui.setPositiveButton("Yes", new DialogInterface.OnClickListener()

            {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    MainActivity.super.onBackPressed();

                }
            }).setCancelable(false);
bui.setNegativeButton("No",null);

            AlertDialog ag=bui.create();
            ag.show();
            ag.getWindow().setBackgroundDrawableResource(android.R.color.background_light);
        }

    }
}




