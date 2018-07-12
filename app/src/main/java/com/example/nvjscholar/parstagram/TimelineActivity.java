package com.example.nvjscholar.parstagram;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.nvjscholar.parstagram.models.Post;
import com.parse.FindCallback;
import com.parse.ParseException;

import java.util.ArrayList;
import java.util.List;

public class TimelineActivity extends AppCompatActivity {

//    private Post post;
    PostAdapter postAdapter;
    ArrayList<Post> posts;
    RecyclerView rvPosts;
//    Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);

//        context = this;

        //find RecyclerView
        rvPosts = (RecyclerView) findViewById(R.id.rvPosts);
        //init the arrayList
        posts = new ArrayList<>();
        //construct the adapter from the data source
        postAdapter = new PostAdapter(posts);


        //setup RecyclerView(layout manager, use adapter)
        rvPosts.setLayoutManager(new LinearLayoutManager(this));
        //set adapter
        rvPosts.setAdapter(postAdapter);
        loadTopPosts();

    }

    private void loadTopPosts(){
        final Post.Query postsQuery = new Post.Query();
        postsQuery.getTop().attachUser();
        postsQuery.findInBackground(new FindCallback<Post>() {
            @Override
            public void done(List<Post> objects, ParseException e) {
                if(e == null){
     //               for(int i = 0; i < objects.size(); i++){
     //                   try {
     //                       Log.d("HomeActivity", "Post[" + i + "] = "
     //                              + objects.get(i).getDescription()
     //                               +"\nusername = " + objects.get(i).getUser().fetchIfNeeded().getUsername());
     //                   } catch (ParseException e1) {
     //                       e1.printStackTrace();
      //                  }
                    postAdapter.addAll(objects);
                    postAdapter.notifyItemInserted(posts.size()-1);
                }
                else{
                    e.printStackTrace();
                }
            }
        });

    }
}
