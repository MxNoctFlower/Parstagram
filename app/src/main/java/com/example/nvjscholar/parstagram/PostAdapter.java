package com.example.nvjscholar.parstagram;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.nvjscholar.parstagram.models.Post;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder>{

    private List<Post> posts;
    Context context;

    public PostAdapter( List<Post> post) {

        posts = post;
    }

   @NonNull
   @Override
   public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int ViewType){

        context = parent.getContext();
       LayoutInflater inflater = LayoutInflater.from(context);
       View postView = inflater.inflate(R.layout.item_post, parent, false);
       ViewHolder viewHolder = new ViewHolder(postView);
       return  viewHolder;

   }

   @Override
   public void onBindViewHolder(@NonNull ViewHolder holder, int position){

        Post post = posts.get(position);


        holder.tvUser.setText(post.getUser().getUsername());
        holder.tvDes.setText(post.getDescription());
        Glide.with(context)
                .load(post.getImage().getUrl())
                .into(holder.ivPic);
   }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public void addAll(List<Post> posts) {
       posts.clear();
       posts.addAll(posts);
       notifyDataSetChanged();

    }



    public static class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView ivPic;
        public TextView tvUser;
        public TextView tvDes;

        public ViewHolder(final View itemView){
            super(itemView);

            ivPic = (ImageView) itemView.findViewById(R.id.ivPic);
            tvUser = (TextView) itemView.findViewById(R.id.tvUser);
            tvDes = (TextView) itemView.findViewById(R.id.tvDes);
        }
    }
}
