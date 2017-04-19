package share.imooc.com.facedemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.aip.face.AipFace;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;

import static android.R.attr.left;

public class MainActivity extends AppCompatActivity {
    public static final String APP_ID = "9533153";
    public static final String API_KEY = "Mpwuvu7lwtK4IthxsAyGK51O";
    public static final String SECRET_KEY = "NNpFxxUtahrE8NHHZ6MdRY67hOKzcKDs";
    private Button btn;
    private TextView txt;
    private MyFaceView myFaceView;
    private Rect rect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);
        Bitmap bm= BitmapFactory.decodeResource(this.getResources(), R.mipmap.cluo);
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.PNG,100,baos);
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("max_face_num", "1");
        options.put("face_fields", "age,beauty");
        // 调用API
        initView(client,baos,options);

    }

    private void initView(final AipFace client, final ByteArrayOutputStream baos, final HashMap<String, String> options) {
        myFaceView= (MyFaceView) findViewById(R.id.myfaceview);
        btn= (Button) findViewById(R.id.btn);
        txt= (TextView) findViewById(R.id.txt);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        final JSONObject res = client.detect(baos.toByteArray(),options);
                        Gson gson=new Gson();
                        FaceInfoBean faceInfoBean=gson.fromJson(res.toString(),FaceInfoBean.class);
                        final List<FaceInfoBean.ResultBean> InfoBean=faceInfoBean.getResult();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                for (int i = 0; i <InfoBean.size() ; i++) {
                                    int left=InfoBean.get(i).getLocation().getLeft();
                                    int top=InfoBean.get(i).getLocation().getTop();
                                    int width=InfoBean.get(i).getLocation().getWidth();
                                    int height=InfoBean.get(i).getLocation().getHeight();
                                   /* Log.d("dd", " top: "+top);
                                    Toast.makeText(MainActivity.this, "top:"+top, Toast.LENGTH_SHORT).show();*/
                                    rect=new Rect((int) (left/1.5),(int)(top/2), (int) ((left+width)/1.5),(int)((top+height)/2));
                                    myFaceView.drawFace(rect);
                                }


                                //Log.d("dd",res.toString());

                               ;

                            }
                        });
                        //Log.d("dd",res.toString());
                    }
                }).start();
            }
        });



    }
}
