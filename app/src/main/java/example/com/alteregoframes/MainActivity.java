package example.com.alteregoframes;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //obtain references to all the clickable fields
        TextView phone = findViewById(R.id.phone);
        TextView email = findViewById(R.id.email);
        ImageButton instaButton = findViewById(R.id.instagram);
        ImageButton fbButton = findViewById(R.id.facebook);
        ImageButton youtubeButton = findViewById(R.id.youtube);

        //set OnClickListener for the clickable fields to respond to user click event
        phone.setOnClickListener(this);
        email.setOnClickListener(this);
        instaButton.setOnClickListener(this);
        fbButton.setOnClickListener(this);
        youtubeButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        //call a private method to handle click events
        startActivity(v.getId());
    }

    /**
     * starts an implicit intent upon click of phone/email textview or social media buttons
     *
     * @param resourceId reference to the view ID which generated the click event
     */
    private void startActivity(int resourceId) {
        //create new Intent with action : ACTION_VIEW
        Intent intent = new Intent(Intent.ACTION_VIEW);

        //declare a variable to hold URL for the intent
        String url = "";

        //declare a variable to store the phone or email text
        String param = "";
        if (findViewById(resourceId) instanceof TextView) {
            param = ((TextView) (findViewById(resourceId))).getText().toString();
        }

        switch (resourceId) {
            case R.id.phone:
                url = "tel:" + param;
                break;
            case R.id.email:
                url = "mailto:" + param;
                break;
            case R.id.instagram:
                url = "https://www.instagram.com/alteregoframes/";
                break;
            case R.id.facebook:
                url = "https://www.facebook.com/AlterEgoFrames/";
                break;
            case R.id.youtube:
                url = "https://www.youtube.com/channel/UC6BctLtw6sqY1syTJZCBrrQ";
                break;
        }
        intent.setData(Uri.parse(url));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
