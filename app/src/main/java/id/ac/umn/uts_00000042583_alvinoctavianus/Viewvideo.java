package id.ac.umn.uts_00000042583_alvinoctavianus;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Viewvideo extends AppCompatActivity {
    TextView textjudul;
    TextView descvid;
    TextView textdesc;
    TextView resvid;
    TextView sumbervid;
    int linkvideo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deskripsivideo);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        textjudul=findViewById(R.id.judulvid);
        descvid=findViewById(R.id.viddeskripsi);
        textdesc=findViewById(R.id.descvideo);
        resvid=findViewById(R.id.resource);
        sumbervid=findViewById(R.id.resourcevid);
        String judulvid = getIntent().getStringExtra("judul");
        String videodesc = getIntent().getStringExtra("viddesc");
        String desc = getIntent().getStringExtra("tulisan");
        String resvideo = getIntent().getStringExtra("resvid");
        String sumbervideo = getIntent().getStringExtra("sumber");
        linkvideo= getIntent().getIntExtra("link", 1);

        textjudul.setText(judulvid);
        descvid.setText(videodesc);
        textdesc.setText(desc);
        resvid.setText(resvideo);
        sumbervid.setText(sumbervideo);
        actionBar.setTitle(judulvid);
        VideoView videoView = findViewById(R.id.Vid);
        String videoPath = "android.resource://" + getPackageName() + "/" + linkvideo;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            case R.id.menuprofile:
                startActivity(new Intent(Viewvideo.this, profile.class));
                break;
            case R.id.menuhome:
                startActivity(new Intent(Viewvideo.this, MainActivity.class));
                break;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
