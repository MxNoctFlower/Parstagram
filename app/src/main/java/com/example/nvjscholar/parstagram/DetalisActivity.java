package com.example.nvjscholar.parstagram;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.nvjscholar.parstagram.models.Post;

import org.parceler.Parcels;

import java.util.ArrayList;

public class DetalisActivity extends AppCompatActivity {

    PostAdapter postAdapter;
    ArrayList<Post> posts;
    ImageView ivPic;
    TextView tvUser;
    TextView tvDes;
    TextView tvDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalis);

        //find RecyclerView
        ivPic = (ImageView) findViewById(R.id.ivPic);
        tvUser = (TextView) findViewById(R.id.tvUser);
        tvDes = (TextView) findViewById(R.id.tvDes);
        tvDate = (TextView) findViewById(R.id.tvDate);
        //init the arrayList
        posts = new ArrayList<>();
        //construct the adapter from the data source
        postAdapter = new PostAdapter(posts);

        Post post = (Post) Parcels.unwrap(getIntent().getParcelableExtra("post"));

        tvUser.setText(post.getUser().getUsername());
        tvDes.setText(post.getDescription());
        tvDate.setText(post.getCreatedAt().toString());
        Glide.with(this)
                .load(post.getImage().getUrl())
                .into(ivPic);
    }
}
