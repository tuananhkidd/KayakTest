package jp.co.panasonic.pstc.ocr.android.card.app.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import jp.co.panasonic.pstc.ocr.android.card.app.R;

public class OcrTextView extends LinearLayout {
    private Context mContext;
    private TextView tvTitle;
    private TextView tvDetail;


    public OcrTextView(Context context) {
        super(context);
        init(context);
    }

    public OcrTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
        setParams(attrs);
    }

    public OcrTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
        setParams(attrs);
    }

    private void init(Context context) {
        this.mContext = context;
        View view = LayoutInflater.from(context).inflate(R.layout.layout_ocr_text_result, this, true);
        tvDetail = view.findViewById(R.id.tv_detail);
        tvTitle = view.findViewById(R.id.tv_title);
    }

    private void setParams(AttributeSet attrs){
        TypedArray typedArray = mContext.getTheme().obtainStyledAttributes(attrs,R.styleable.OcrTextView,0,0);
        String title = typedArray.getString(R.styleable.OcrTextView_otv_title);
        tvTitle.setText(title);
    }

    public void setDetail(String text) {
        tvDetail.setText(text);
    }
}
