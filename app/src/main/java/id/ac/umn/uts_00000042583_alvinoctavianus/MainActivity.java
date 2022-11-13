package id.ac.umn.uts_00000042583_alvinoctavianus;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    private Button btnProfile,btnLibrary, btnLogin;
    private EditText loginnama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnProfile = findViewById(R.id.profile);
        btnLibrary = findViewById(R.id.library);
        btnLibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog(view);
            }
        });
    }
    public void btnProfile(View view){
        Intent profileIntent = new Intent(MainActivity.this, profile.class);
        startActivity(profileIntent);
    }

    public void openDialog(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        View inflater = LayoutInflater.from(view.getContext()).inflate(R.layout.login, null);
        builder.setView(inflater)
                .setTitle("Login Page");
        AlertDialog alertDialog = builder.show();
        loginnama = inflater.findViewById(R.id.insertnama);
        btnLogin = inflater.findViewById(R.id.login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = loginnama.getText().toString();
                if(nama.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Name must be entered", Toast.LENGTH_SHORT).show();
                }else {
                    Intent libraryIntent = new Intent(MainActivity.this, library.class);
                    String message = "Hello" + ", " + loginnama.getText().toString();
                    libraryIntent.putExtra("key", message);
                    startActivity(libraryIntent);
                }
                alertDialog.dismiss();
            }
        });
    }

}