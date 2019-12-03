// Generated code from Butter Knife. Do not modify!
package jp.co.panasonic.pstc.ocr.android.card.app;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import jp.co.panasonic.pstc.ocr.android.card.app.custom.OcrResultView;

public class ResultActivity_ViewBinding implements Unbinder {
  private ResultActivity target;

  @UiThread
  public ResultActivity_ViewBinding(ResultActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ResultActivity_ViewBinding(ResultActivity target, View source) {
    this.target = target;

    target.orvCompany = Utils.findRequiredViewAsType(source, R.id.orv_company, "field 'orvCompany'", OcrResultView.class);
    target.orvFirstName = Utils.findRequiredViewAsType(source, R.id.orv_first_name, "field 'orvFirstName'", OcrResultView.class);
    target.orvLastName = Utils.findRequiredViewAsType(source, R.id.orv_last_name, "field 'orvLastName'", OcrResultView.class);
    target.orvAddress1 = Utils.findRequiredViewAsType(source, R.id.orv_address_1, "field 'orvAddress1'", OcrResultView.class);
    target.orvPhone1 = Utils.findRequiredViewAsType(source, R.id.orv_phone_1, "field 'orvPhone1'", OcrResultView.class);
    target.orvFax1 = Utils.findRequiredViewAsType(source, R.id.orv_fax_1, "field 'orvFax1'", OcrResultView.class);
    target.orvAddress2 = Utils.findRequiredViewAsType(source, R.id.orv_address_2, "field 'orvAddress2'", OcrResultView.class);
    target.orvPhone2 = Utils.findRequiredViewAsType(source, R.id.orv_phone_2, "field 'orvPhone2'", OcrResultView.class);
    target.orvFax2 = Utils.findRequiredViewAsType(source, R.id.orv_fax_2, "field 'orvFax2'", OcrResultView.class);
    target.orvUrl1 = Utils.findRequiredViewAsType(source, R.id.orv_url1, "field 'orvUrl1'", OcrResultView.class);
    target.orvUrl2 = Utils.findRequiredViewAsType(source, R.id.orv_url2, "field 'orvUrl2'", OcrResultView.class);
    target.imgResult = Utils.findRequiredViewAsType(source, R.id.img_result, "field 'imgResult'", ImageView.class);
    target.orvEmail1 = Utils.findRequiredViewAsType(source, R.id.orv_email1, "field 'orvEmail1'", OcrResultView.class);
    target.orvEmail2 = Utils.findRequiredViewAsType(source, R.id.orv_email2, "field 'orvEmail2'", OcrResultView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ResultActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.orvCompany = null;
    target.orvFirstName = null;
    target.orvLastName = null;
    target.orvAddress1 = null;
    target.orvPhone1 = null;
    target.orvFax1 = null;
    target.orvAddress2 = null;
    target.orvPhone2 = null;
    target.orvFax2 = null;
    target.orvUrl1 = null;
    target.orvUrl2 = null;
    target.imgResult = null;
    target.orvEmail1 = null;
    target.orvEmail2 = null;
  }
}
