package jp.co.panasonic.pstc.ocr.android.card.app;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;
import java.io.InputStream;

import jp.co.panasonic.pstc.ocr.android.card.app.bus.GetDataFromUnityEvent;
import jp.co.panasonic.pstc.ocr.android.card.app.camera.CameraData;
import jp.co.panasonic.pstc.ocr.android.card.app.util.FileUtil;

/**
 * メインアクティビティクラス(カメラ)
 *
 * @author Panasonic Solution Technologies Co., Ltd.
 */
public class MainActivity extends Activity {

    /**
     * 変数・定数宣言
     */
    private final static int MENU_SETTING = 0;    // 設定
    private final static int MENU_HELP = 1;    // ヘルプ

    public final static int PHOTO_GALLERY = 1;    // フォトギャラリーID
    public final static int REQUEST_CODE_UNITY_CAMERA = 1234;    // フォトギャラリーID
    public final static int PERMISSION_CODE = 1212;

    private Activity activity;            // アクティビティ
    private Button cameraButton;        // 「カメラ撮影」ボタン
    private Button pictureButton;        // 「画像」ボタン

    public static MainActivity currentActivity;

    public static void processImage(String base64image) {
        Log.v("ahuhu", "ahihi" + base64image);
    }
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
        Log.d("MainActivity", "onCreate()");
        EventBus.getDefault().register(this);
        // カメラデータ取得
        CameraData cameraData = CameraData.getInstance();
        {
            // プレビュー表示フラグをオンに設定
            cameraData.setPreview(true);
        }

        this.setContentView(R.layout.main);
        this.setTitle(R.string.app_name);

        cameraButton = ((Button) this.findViewById(R.id.Camera));
        cameraButton.setOnClickListener(new ExecCameraButtonOnClick());

        pictureButton = ((Button) this.findViewById(R.id.Picture));
        pictureButton.setOnClickListener(new ExecPictureButtonOnClick());

        // アクティビティ保持
        this.activity = this;
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            saveFile();
        } else {
            String[] permissions = new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};
            ActivityCompat.requestPermissions(this, permissions, PERMISSION_CODE);
        }

        currentActivity = this;
    }

    /**
     * アクティビティ表示処理<br />
     * アクティビティが表示された際にコールされる。
     */
    @Override
    public void onResume() {
        super.onResume();
        Log.d("MainActivity", "onResume()");


    }

    private void saveFile() {
        FileUtil.saveDictionaryAndLicenseFile(this, "address.dic");
        FileUtil.saveDictionaryAndLicenseFile(this, "company.dic");
        FileUtil.saveDictionaryAndLicenseFile(this, "fname.dic");
        FileUtil.saveDictionaryAndLicenseFile(this, "jocr1.dic");
        FileUtil.saveDictionaryAndLicenseFile(this, "jocr2.dic");
        FileUtil.saveDictionaryAndLicenseFile(this, "jocr3.dic");
        FileUtil.saveDictionaryAndLicenseFile(this, "jocr4.dic");
        FileUtil.saveDictionaryAndLicenseFile(this, "keyword.dic");
        FileUtil.saveDictionaryAndLicenseFile(this, "lname.dic");
        FileUtil.saveDictionaryAndLicenseFile(this, "Jpost.dic");
        FileUtil.saveDictionaryAndLicenseFile(this, "LicenseInfo.polf");

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_CODE) {
            if (grantResults.length != 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED
                    && grantResults[1] == PackageManager.PERMISSION_GRANTED
                    && grantResults[2] == PackageManager.PERMISSION_GRANTED) {
                saveFile();
            } else {
                Toast.makeText(this, "Permission Deny!", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

    /**
     * アクティビティ破棄処理<br />
     */
    public void onDestroy() {
        // カメラデータ破棄
        CameraData cameraData = CameraData.getInstance();
        cameraData.destroy();

        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onGetData(GetDataFromUnityEvent event) {
        Log.v("ahihi", "base64 " + event.getBase64String());
    }

    /**
     * オプションメニュー作成処理<br />
     *
     * @param menu メニュー(Menu型)
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, MENU_SETTING, 0, "設定");
        menu.add(0, MENU_HELP, 1, "ヘルプ");
        return true;
    }

    /**
     * オプションメニュー表示処理<br />
     *
     * @param item アイテム(MenuItem型)
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MENU_SETTING:
                // 設定アクティビティ起動
                Intent intent = new Intent(
                        getApplicationContext(),
                        jp.co.panasonic.pstc.ocr.android.card.app.SettingActivity.class
                );
                startActivity(intent);
                break;
            case MENU_HELP:
                // ヘルプアクティビティ起動
                intent = new Intent(
                        getApplicationContext(),
                        jp.co.panasonic.pstc.ocr.android.card.app.HelpActivity.class
                );
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /** アクティビティ [END] ================================== */


    /** イベントリスナー [START] =============================== */

    /**
     * 「カメラ撮影」ボタン押下イベント処理クラス
     */
    private class ExecCameraButtonOnClick implements OnClickListener {
        @Override
        public void onClick(View v) {

//            Intent intent = new Intent(
//                    getApplicationContext(),
//                    MainActivity.class
//            );
//            startActivity(intent);
            // カメラアクティビティ表示
            Intent cameraIntent = new Intent(
                    getApplicationContext(),
                    jp.co.panasonic.pstc.ocr.android.card.app.camera.CameraActivity.class
            );
            startActivityForResult(cameraIntent, REQUEST_CODE_UNITY_CAMERA);
        }
    }

    /**
     * 「画像」ボタン押下イベント処理クラス
     */
    private class ExecPictureButtonOnClick implements OnClickListener {
        @Override
        public void onClick(View v) {

            // SDカード表示フラグをTRUEへ設定
            CameraData cameraData = CameraData.getInstance();
            cameraData.setSdcard(true);

            // フォトギャラリー表示
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType("image/*");
            startActivityForResult(intent, PHOTO_GALLERY);
        }
    }

    /** イベントリスナー [END] ================================= */


    /** 他アクティビティ結果取得 [START] =========================== */

    /**
     * 他アクティビティ呼出結果取得処理<br />
     *
     * @param requestCode リクエストコード(int型)
     * @param resultCode  リザルトコード(int型)
     * @param intent      インテント(Intent型)
     */
    @Override
    protected void onActivityResult(
            int requestCode,
            int resultCode,
            Intent intent) {
        Log.d("MainActivity", "onActivityResult()");

        switch (requestCode) {
//            case REQUEST_CODE_UNITY_CAMERA:{
//                if(resultCode == Activity.RESULT_OK){
//                    EventBus.getDefault().post(new GetDataFromUnityEvent(intent.getStringExtra("base64image")));
//                }
//                break;
//            }
            //region gallery
            case PHOTO_GALLERY:
                // フォトギャラリー
                if (resultCode != RESULT_OK) return;

                // カメラデータ取得
                CameraData cameraData = CameraData.getInstance();

                // カメラデータ変換
            {
                // カメラデータ初期化(必須)
                cameraData.init();

                // 画像データを取得
                Bitmap bitmap = null;
                {
                    // 画像URIを取得
                    Uri photoUri = intent.getData();
                    if (photoUri == null) return;

                    // ビットマップ画像を取得
                    try {
                        BitmapFactory.Options opt = new BitmapFactory.Options();
                        opt.inPreferredConfig = Bitmap.Config.ARGB_8888;
                        InputStream is = getContentResolver().openInputStream(photoUri);
                        // 情報を取得する
                        opt.inJustDecodeBounds = true;
                        BitmapFactory.decodeStream(is, null, opt);
                        opt.inJustDecodeBounds = false;
                        // 画像のロード
                        is = getContentResolver().openInputStream(photoUri);
                        bitmap = BitmapFactory.decodeStream(is, null, opt);
                    } catch (IOException e) {

                    }
                }
                if (bitmap == null) return;

                // カメラデータに格納
                cameraData.setBitmapData(bitmap);
            }

            // プレビュー表示フラグチェック
            if (cameraData.isPreview()) {
                // プレビュー表示あり

                // カメラ撮影画像プレビュー表示
                Intent cameraIntent = new Intent(
                        getApplicationContext(),
                        jp.co.panasonic.pstc.ocr.android.card.app.CameraPicturePreviewActivity.class
                );
                startActivity(cameraIntent);
            } else {
                // プレビュー表示なし

                // プログレスバー表示＆バックグラウンド処理開始
                CameraProgress progress = new CameraProgress(activity, false);
                progress.setProgressTitle("Processing");        // プログレスタイトル
                progress.setProgressMessage("Please Wait...");    // プログレスメッセージ
                progress.setProgressCountUp(1);                    // カウントアップ値
                progress.setProgressCountUpMills(250);            // カウントアップ間隔(ミリ秒)
                progress.setProgressMaxCount(100);                // 最大カウント値
                progress.execute("request");
            }

            break;
            //endregion
            default:
                break;
        }

    }

    /** 他アクティビティ結果取得 [END] ============================= */

}