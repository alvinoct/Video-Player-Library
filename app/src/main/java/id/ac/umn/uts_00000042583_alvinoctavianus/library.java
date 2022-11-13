package id.ac.umn.uts_00000042583_alvinoctavianus;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class library extends AppCompatActivity implements InfoVideo {
    ArrayList<Videolist> videoList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private BottomSheetDialog dialog;
    private Button btnYes;
    private Button btnNo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menulibrary);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        String message = getIntent().getStringExtra("key").toString();
        setTitle(message);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        Toast.makeText(getApplicationContext(), getIntent().getStringExtra("key").toString(), Toast.LENGTH_SHORT).show();

        videoList.add(new Videolist(R.drawable.logovideo, "Video 1","Video Description :", "【TikTok】SAUSAGE EGG CHEESE SANDWICH 【3.2M views】#Shorts", "Resource Video :", "- Youtube",  R.raw.videosatu));
        videoList.add(new Videolist(R.drawable.logovideo, "Video 2","Video Description :", "Nino Nakano - Dj Break Heart Edit Amv", "Resource Video :", "- Youtube", R.raw.video2));
        videoList.add(new Videolist(R.drawable.logovideo, "Video 3","Video Description :", "absolutely everyone should try it cheese tomato  cup ramen #shorts", "Resource Video :", "- Youtube", R.raw.video3));
        videoList.add(new Videolist(R.drawable.logovideo, "Video 4","Video Description :", "Do You Ever Dream About.. Chili Oil Ramen?", "Resource Video :", "- Youtube", R.raw.video4));
        videoList.add(new Videolist(R.drawable.logovideo, "Video 5","Video Description :", "Marin Kitagawa - NO LIE EDIT [My Dress-Up Darling]", "Resource Video :", "- Youtube", R.raw.videoenam));

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new videoAdapter(videoList, this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        dialog = new BottomSheetDialog(this);
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
                startActivity(new Intent(library.this, profile.class));
                break;
            case R.id.menuhome:
                startActivity(new Intent(library.this, MainActivity.class));
                break;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onItemClick(int position) {
        Intent profileIntent = new Intent(library.this, Viewvideo.class);
        profileIntent.putExtra("judul", videoList.get(position).getText1());
        profileIntent.putExtra("viddesc", videoList.get(position).getViddesc());
        profileIntent.putExtra("tulisan", videoList.get(position).getDeskripsi());
        profileIntent.putExtra("resvid", videoList.get(position).getResvid());
        profileIntent.putExtra("sumber", videoList.get(position).getSumbervid());
        profileIntent.putExtra("link", videoList.get(position).getlinkvideo());
        startActivity(profileIntent);

    }

    @Override
    public void onDeleteClick(int position) {
        openDialog(position);
        dialog.show();
        dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
    }

    public void openDialog(int position) {
        View inflater = getLayoutInflater().inflate(R.layout.menudelete, null, false);
        btnYes  = inflater.findViewById(R.id.yes);
        btnNo  = inflater.findViewById(R.id.no);
        btnYes.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                videoList.remove(position);
                adapter.notifyItemRemoved(position);
                dialog.dismiss();
            }
        });

        btnNo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                dialog.dismiss();
            }
        });

        dialog.setContentView(inflater);
    }

}
