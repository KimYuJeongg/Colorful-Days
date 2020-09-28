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

import java.io.File;
import java.io.InputStream;

public class DiaryActivity extends AppCompatActivity
{
    class BtnOnClickListener implements Button.OnClickListener
    {
        @Override
        public void onClick(View view)
        {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
            switch (view.getId())
            {
                case R.id.insert_image:
                    Intent intent = new Intent();
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                    startActivityForResult(intent, 1);
                    break;
                case R.id.more:
                    ImageView more = new ImageView(DiaryActivity.this);
                    more.setBackgroundResource(R.drawable.ic_more);
                    linearLayout.addView(more);
                    break;
                case R.id.quote:
                    ImageView quote = new ImageView(DiaryActivity.this);
                    quote.setBackgroundResource(R.drawable.ic_quote);
                    linearLayout.addView(quote);
                    break;
                case R.id.bold:
                    EditText editText = (EditText) findViewById(R.id.edit_content);
                    Spannable spannable = (Spannable) editText.getText();
                    spannable.setSpan(new StyleSpan(Typeface.BOLD), editText.getSelectionStart(), editText.getSelectionEnd(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    //볼드 해제 추가
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
                    imageView.setImageBitmap(img);
                    linearLayout.addView(imageView);
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

    private BitmapFactory.Options getBitmapSize(File imageFile)
    {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(imageFile.getAbsolutePath(), options);

        return options;
    }

}
