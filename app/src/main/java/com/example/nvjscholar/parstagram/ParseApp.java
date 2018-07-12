package com.example.nvjscholar.parstagram;

import android.app.Application;

import com.example.nvjscholar.parstagram.models.Post;
import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApp extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        ParseObject.registerSubclass(Post.class);

        final Parse.Configuration configuration = new Parse.Configuration.Builder(this)
                .applicationId("gracelee")
                .clientKey("nvj1297gamj0606")
                .server("http://vangram.herokuapp.com/parse")
                .build();
        Parse.initialize(configuration);
    }
}
