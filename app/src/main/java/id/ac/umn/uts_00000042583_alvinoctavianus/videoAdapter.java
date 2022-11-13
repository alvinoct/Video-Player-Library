package id.ac.umn.uts_00000042583_alvinoctavianus;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class videoAdapter extends RecyclerView.Adapter<videoAdapter.videoViewHolder>{
    private final InfoVideo infoVideo;
    private ArrayList<Videolist> list;

    public static class videoViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView judulVideo;
        public ImageView btnDelete;

        public videoViewHolder(View itemView, InfoVideo infoVideo){
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            judulVideo = itemView.findViewById(R.id.judulVideo);
            btnDelete = itemView.findViewById(R.id.delete);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(infoVideo != null){
                        int pos = getAdapterPosition();
                        if (pos != RecyclerView.NO_POSITION){
                            infoVideo.onItemClick(pos);
                        }
                    }
                }
            });

            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(infoVideo != null){
                        int pos = getAdapterPosition();
                        if (pos != RecyclerView.NO_POSITION){
                            infoVideo.onDeleteClick(pos);
                        }
                    }
                }
            });
            }
        }

        public videoAdapter(ArrayList<Videolist> videoList, InfoVideo infoVideo){
            list = videoList;
            this.infoVideo = infoVideo;
        }
        @NonNull
        @Override
        public videoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listvideo, parent, false);
            videoViewHolder vh = new videoViewHolder(view, infoVideo);
            return vh;
    }

        @Override
        public void onBindViewHolder(@NonNull videoViewHolder holder, int position) {
            Videolist currentitem = list.get(position);

            holder.imageView.setImageResource(currentitem.getImageResource());
            holder.judulVideo.setText(currentitem.getText1());

        }

        @Override
        public int getItemCount() {
            return list.size();
        }

    }


