package com.example.colorfuldays;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;

public class DiaryActivity extends AppCompatActivity
{
    class BtnOnClickListener implements Button.OnClickListener
    {
        @Override
        public void onClick(View view)
        {
            switch (view.getId())
            {
                case R.id.insert_image:
                    Toast.makeText(getApplicationContext(), "Pushed ", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent();
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    startActivityForResult(intent, 1);
                    break;
                case R.id.more:
                    Toast.makeText(getApplicationContext(), "rr Pushed ", Toast.LENGTH_LONG).show();
                    break;
                case R.id.quote:
                case R.id.bold:
                    EditText editText = (EditText) findViewById(R.id.edit_content);
                    Spannable spannable = (Spannable) editText.getText();
                    spannable.setSpan(new StyleSpan(Typeface.BOLD), editText.getSelectionStart(), editText.getSelectionEnd(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    break;
                case R.id.align:
                case R.id.size:
                case R.id.hashtag:
                    break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);

        Intent intent = getIntent();

        TextView date = findViewById(R.id.date);
        date.setText(intent.getStringExtra("date"));

        BtnOnClickListener onClickListener = new BtnOnClickListener();

        ImageButton insert_image = (ImageButton) findViewById(R.id.insert_image);
        insert_image.setOnClickListener(onClickListener);
        ImageButton dividing_line = (ImageButton) findViewById(R.id.more);
        dividing_line.setOnClickListener(onClickListener);
        ImageButton bold = (ImageButton) findViewById(R.id.bold);
        bold.setOnClickListener(onClickListener);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1)
        {
            if (resultCode == RESULT_OK)
            {
                try
                {
                    InputStream in = getContentResolver().openInputStream(data.getData());

                    Bitmap img = BitmapFactory.decodeStream(in);
                    in.close();

                    LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
                    ImageView imageView = new ImageView(DiaryActivity.this);
                    linearLayout.addView(imageView);
                    imageView.setImageBitmap(img);
                } catch (Exception e)
                {

                }
            }
            else if (resultCode == RESULT_CANCELED)
            {
                Toast.makeText(this, "사진 선택 취소", Toast.LENGTH_LONG).show();
            }
        }
    }
}
