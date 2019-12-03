package jp.co.panasonic.pstc.ocr.android.card.app.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import jp.co.panasonic.pstc.ocr.android.card.app.R;

public class OcrResultView extends LinearLayout {
    private Context mContext;
    private ImageView img;
    private TextView tv;
    private TextView tvTitle;

    public OcrResultView(Context context) {
        super(context);
        init(context);
    }

    public OcrResultView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
        setParams(attrs);
    }

    public OcrResultView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
        setParams(attrs);
    }

    private void init(Context context) {
        this.mContext = context;
        View view = LayoutInflater.from(context).inflate(R.layout.layout_ocr_result, this, true);
        img = view.findViewById(R.id.img);
        tv = view.findViewById(R.id.tv);
        tvTitle = view.findViewById(R.id.tv_title);
    }

    private void setParams(AttributeSet attrs){
        TypedArray typedArray = mContext.getTheme().obtainStyledAttributes(attrs,R.styleable.OcrResultView,0,0);
        String title = typedArray.getString(R.styleable.OcrResultView_title);
        tvTitle.setText(title);
    }

    public void setImage(Bitmap bitmap) {
        Glide.with(mContext)
                .load(bitmap)
                .into(img);
    }

    public void setText(String text) {
        tv.setText(text);
    }

    public void setResult(Bitmap bitmap, String text) {
        setImage(bitmap);
        setText(text);
    }
}
