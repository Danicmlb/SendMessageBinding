package com.example.sendmessagebinding.iu;

import android.os.Bundle;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sendmessagebinding.R;
import com.vansuita.materialabout.builder.AboutBuilder;
import com.vansuita.materialabout.views.AboutView;

public class AboutUsActivity extends AppCompatActivity {

    private ViewGroup.LayoutParams layoutParams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        AboutView view = AboutBuilder.with(this)
                .setName(getResources().getString(R.string.username))
                .setSubTitle(getResources().getString(R.string.subtitle))
                .setBrief(getResources().getString(R.string.app_name))
                .setAppIcon(R.mipmap.ic_launcher)
                .setAppName(R.string.app_name)
                .addGitHubLink(getResources().getString(R.string.linkgithub))
                .addFiveStarsAction()
                .setVersionNameAsAppSubTitle()
                .addShareAction(R.string.app_name)
                .setWrapScrollView(true)
                .setLinksAnimated(true)
                .setShowAsCard(true)
                .build();

       // addContentView(view, layoutParams);
        setContentView(view);
    }
}

/**
 *
 * (getResources().getString(R.string.app_name))
 */