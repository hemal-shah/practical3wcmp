package hemal.mukesh.shah.prac1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    RelativeLayout rl;
    TextInputLayout userName, passWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.editText);
        password = (EditText) findViewById(R.id.editText2);
        userName = (TextInputLayout) findViewById(R.id.textInputLayout);
        passWord = (TextInputLayout) findViewById(R.id.textInputLayout2);
        rl = (RelativeLayout) findViewById(R.id.rl);
    }

    public void login(View view) {
        String uname = username.getText().toString();
        String pass = password.getText().toString();

        if (uname.length() == 0) {
            userName.setError("Please enter username!");
            return;
        } else {
            userName.setErrorEnabled(false);
        }

        if (pass.length() == 0) {
            passWord.setError("Please enter password!");
            return;
        } else {
            passWord.setErrorEnabled(false);
        }

        Intent intent = new Intent(MainActivity.this, NewActivity.class);
        SharedPreferences sp = getSharedPreferences(getString(R.string.app_name), MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(getString(R.string.KEY_USERNAME), uname);
        editor.putString(getString(R.string.KEY_PASSWORD), pass);
        editor.apply();
        startActivity(intent);
    }
}
