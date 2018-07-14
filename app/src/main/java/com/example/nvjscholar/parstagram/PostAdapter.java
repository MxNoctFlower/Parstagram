package com.example.nvjscholar.parstagram;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.nvjscholar.parstagram.models.Post;

import org.parceler.Parcels;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    private List<Post> posts;
    Context context;

    public PostAdapter(List<Post> post) {

        posts = post;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int ViewType) {

        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View postView = inflater.inflate(R.layout.item_post, parent, false);
        ViewHolder viewHolder = new ViewHolder(postView);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Post post = posts.get(position);

        holder.tvUser.setText(post.getUser().getUsername());
        holder.tvDes.setText(post.getDescription());
        holder.tvDate.setText(post.getCreate());
        Glide.with(context)
                .load(post.getImage().getUrl())
                .into(holder.ibPic);

    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    // Clean all elements of the recycler
    public void clear() {
        posts.clear();
        notifyDataSetChanged();
    }

    // Add a list of items -- change to type used
    public void addAll(List<Post> list) {
        posts.addAll(list);
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView tvUser;
        public TextView tvDes;
        public TextView tvDate;
        public ImageView ibPic;

        public ViewHolder(final View itemView) {
            super(itemView);

            tvUser = (TextView) itemView.findViewById(R.id.tvUser);
            tvDes = (TextView) itemView.findViewById(R.id.tvDes);
            ibPic = (ImageView) itemView.findViewById(R.id.ibPic);
            tvDate = (TextView) itemView.findViewById(R.id.tvDate);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            Post post = posts.get(getAdapterPosition());


            Intent intent = new Intent(context, DetalisActivity.class);
            intent.putExtra("post", Parcels.wrap(post));
            context.startActivity(intent);

        }
    }
}

