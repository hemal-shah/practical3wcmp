package hemal.mukesh.shah.prac1;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by hemal on 28/9/16.
 */
public class NewActivity extends AppCompatActivity{

    SharedPreferences sharedPreferences;
    String user_name, password;
    TextView et_user_name, et_password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_activity);

        sharedPreferences = getSharedPreferences(getString(R.string.app_name), MODE_PRIVATE);
        user_name = sharedPreferences.getString(getString(R.string.KEY_USERNAME), "NULL");
        password = sharedPreferences.getString(getString(R.string.KEY_PASSWORD), "NULL");

        et_user_name = (TextView) findViewById(R.id.new_activity_user_name);
        et_password = (TextView) findViewById(R.id.new_activity_password);

        et_user_name.setText(user_name);
        et_password.setText(password);
    }
}
