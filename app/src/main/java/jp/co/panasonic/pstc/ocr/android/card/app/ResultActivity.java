package jp.co.panasonic.pstc.ocr.android.card.app;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView.BufferType;

import com.bumptech.glide.Glide;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.co.panasonic.pstc.ocr.android.card.app.camera.CameraData;
import jp.co.panasonic.pstc.ocr.android.card.app.custom.OcrResultView;
import jp.co.panasonic.pstc.ocr.card.CardRecog;

/**
 * OCR認識結果表示アクティビティクラス
 *
 * @author Panasonic Solution Technologies Co., Ltd.
 */
public class ResultActivity extends Activity {
    @BindView(R.id.orv_company)
    OcrResultView orvCompany;
    @BindView(R.id.orv_first_name)
    OcrResultView orvFirstName;
    @BindView(R.id.orv_last_name)
    OcrResultView orvLastName;
    @BindView(R.id.orv_address_1)
    OcrResultView orvAddress1;
    @BindView(R.id.orv_phone_1)
    OcrResultView orvPhone1;
    @BindView(R.id.orv_fax_1)
    OcrResultView orvFax1;
    @BindView(R.id.orv_address_2)
    OcrResultView orvAddress2;
    @BindView(R.id.orv_phone_2)
    OcrResultView orvPhone2;
    @BindView(R.id.orv_fax_2)
    OcrResultView orvFax2;
    @BindView(R.id.orv_url1)
    OcrResultView orvUrl1;
    @BindView(R.id.orv_url2)
    OcrResultView orvUrl2;
    @BindView(R.id.img_result)
    ImageView imgResult;
    @BindView(R.id.orv_email1)
    OcrResultView orvEmail1;
    @BindView(R.id.orv_email2)
    OcrResultView orvEmail2;
    /**
     * 変数・定数宣言
     */
    private EditText resultEdit;            // 認識結果テキストボックス
    private Button topButton;            // 「トップ画面へ」ボタン


    /** アクティビティ [START] ================================ */

    /**
     * アクティビティ生成時処理<br />
     * アクティビティが生成された場合にコールされる。
     *
     * @param savedInstanceState ステータス(Bundle型)
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("ResultActivity", "onCreate()");


        // カメラデータ取得
        CameraData cameraData = CameraData.getInstance();

        this.setContentView(R.layout.restext);
        ButterKnife.bind(this);
        String str = getString(R.string.app_name) + "認識結果";
        this.setTitle(str);

        topButton = ((Button) this.findViewById(R.id.gototop));
        topButton.setOnClickListener(new ExecTopButtonOnClick());

        resultEdit = ((EditText) this.findViewById(R.id.result_txt));
        resultEdit.setText(cameraData.getOcrResult(), BufferType.NORMAL);

        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/jp.co.panasonic.pstc.ocr.android.card.app/files",
                "/photo.png");
        Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());

        Glide.with(this)
                .load(bitmap)
                .into(imgResult);

        setResult(cameraData.getCardRecog());

    }

    private void setResult(CardRecog cardRecog) {
        if (cardRecog != null) {
            if (cardRecog.getCompany() != null) {
                orvCompany.setResult(cardRecog.getCompany().getImage(), cardRecog.getCompany().getText());
            }
            if (cardRecog.getFname() != null) {
                orvFirstName.setResult(cardRecog.getFname().getImage(), cardRecog.getFname().getText());
            }

            if (cardRecog.getLname() != null) {
                orvLastName.setResult(cardRecog.getLname().getImage(), cardRecog.getLname().getText());
            }

            if (cardRecog.getAddress1() != null) {
                orvAddress1.setResult(cardRecog.getAddress1().getImage(), cardRecog.getAddress1().getText());
            }

            if (cardRecog.getTel1() != null) {
                orvPhone1.setResult(cardRecog.getTel1().getImage(), cardRecog.getTel1().getText());
            }

            if (cardRecog.getFax1() != null) {
                orvFax1.setResult(cardRecog.getFax1().getImage(), cardRecog.getFax1().getText());
            }

            if (cardRecog.getAddress2() != null) {
                orvAddress2.setResult(cardRecog.getAddress2().getImage(), cardRecog.getAddress2().getText());
            }

            if (cardRecog.getTel2() != null) {
                orvPhone2.setResult(cardRecog.getTel2().getImage(), cardRecog.getTel2().getText());
            }

            if (cardRecog.getFax2() != null) {
                orvFax2.setResult(cardRecog.getFax2().getImage(), cardRecog.getFax2().getText());
            }

            if (cardRecog.getUrl1() != null) {
                orvUrl1.setResult(cardRecog.getUrl1().getImage(), cardRecog.getUrl1().getText());
            }

            if (cardRecog.getUrl2() != null) {
                orvUrl2.setResult(cardRecog.getUrl2().getImage(), cardRecog.getUrl2().getText());
            }

            if (cardRecog.getMail1() != null) {
                orvEmail1.setResult(cardRecog.getMail1().getImage(), cardRecog.getMail1().getText());
            }

            if (cardRecog.getMail2() != null) {
                orvEmail2.setResult(cardRecog.getMail2().getImage(), cardRecog.getMail2().getText());
            }

        }
    }

    /** アクティビティ [END] ================================== */


    /** イベントリスナー [START] =============================== */

    /**
     * 「トップ画面へ」ボタン押下イベント処理クラス
     */
    private class ExecTopButtonOnClick implements OnClickListener {
        @Override
        public void onClick(View v) {

            // OCR認識結果表示アクティビティ終了
            finish();
        }
    }

    /** イベントリスナー [END] ================================= */

}
