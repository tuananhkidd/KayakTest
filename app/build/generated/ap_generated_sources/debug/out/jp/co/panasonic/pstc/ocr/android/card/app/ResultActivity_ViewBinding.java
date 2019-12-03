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
import jp.co.panasonic.pstc.ocr.android.card.app.custom.OcrTextView;

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
    target.orvTextCompany = Utils.findRequiredViewAsType(source, R.id.orv_text_company, "field 'orvTextCompany'", OcrTextView.class);
    target.orvTextFirstName = Utils.findRequiredViewAsType(source, R.id.orv_text_first_name, "field 'orvTextFirstName'", OcrTextView.class);
    target.orvTextLastName = Utils.findRequiredViewAsType(source, R.id.orv_text_last_name, "field 'orvTextLastName'", OcrTextView.class);
    target.orvTextAffiliation = Utils.findRequiredViewAsType(source, R.id.orv_text_affiliation, "field 'orvTextAffiliation'", OcrTextView.class);
    target.orvTextExetive = Utils.findRequiredViewAsType(source, R.id.orv_text_exetive, "field 'orvTextExetive'", OcrTextView.class);
    target.orvTextOffice1 = Utils.findRequiredViewAsType(source, R.id.orv_text_office1, "field 'orvTextOffice1'", OcrTextView.class);
    target.orvTextPostal1 = Utils.findRequiredViewAsType(source, R.id.orv_text_postal1, "field 'orvTextPostal1'", OcrTextView.class);
    target.orvTextAddress1 = Utils.findRequiredViewAsType(source, R.id.orv_text_address_1, "field 'orvTextAddress1'", OcrTextView.class);
    target.orvTextPhone1 = Utils.findRequiredViewAsType(source, R.id.orv_text_phone_1, "field 'orvTextPhone1'", OcrTextView.class);
    target.orvTextFax1 = Utils.findRequiredViewAsType(source, R.id.orv_text_fax_1, "field 'orvTextFax1'", OcrTextView.class);
    target.orvTextOffice2 = Utils.findRequiredViewAsType(source, R.id.orv_text_office2, "field 'orvTextOffice2'", OcrTextView.class);
    target.orvTextPostal2 = Utils.findRequiredViewAsType(source, R.id.orv_text_postal2, "field 'orvTextPostal2'", OcrTextView.class);
    target.orvTextAddress2 = Utils.findRequiredViewAsType(source, R.id.orv_text_address_2, "field 'orvTextAddress2'", OcrTextView.class);
    target.orvTextPhone2 = Utils.findRequiredViewAsType(source, R.id.orv_text_phone_2, "field 'orvTextPhone2'", OcrTextView.class);
    target.orvTextFax2 = Utils.findRequiredViewAsType(source, R.id.orv_text_fax_2, "field 'orvTextFax2'", OcrTextView.class);
    target.orvTextEmail1 = Utils.findRequiredViewAsType(source, R.id.orv_text_email1, "field 'orvTextEmail1'", OcrTextView.class);
    target.orvTextEmail2 = Utils.findRequiredViewAsType(source, R.id.orv_text_email2, "field 'orvTextEmail2'", OcrTextView.class);
    target.orvTextUrl1 = Utils.findRequiredViewAsType(source, R.id.orv_text_url1, "field 'orvTextUrl1'", OcrTextView.class);
    target.orvTextUrl2 = Utils.findRequiredViewAsType(source, R.id.orv_text_url2, "field 'orvTextUrl2'", OcrTextView.class);
    target.orvTextBuilding1 = Utils.findRequiredViewAsType(source, R.id.orv_text_building1, "field 'orvTextBuilding1'", OcrTextView.class);
    target.orvTextBuilding2 = Utils.findRequiredViewAsType(source, R.id.orv_text_building2, "field 'orvTextBuilding2'", OcrTextView.class);
    target.orvTextCellular1 = Utils.findRequiredViewAsType(source, R.id.orv_text_cellular1, "field 'orvTextCellular1'", OcrTextView.class);
    target.orvTextCellular2 = Utils.findRequiredViewAsType(source, R.id.orv_text_cellular2, "field 'orvTextCellular2'", OcrTextView.class);
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
    target.orvTextCompany = null;
    target.orvTextFirstName = null;
    target.orvTextLastName = null;
    target.orvTextAffiliation = null;
    target.orvTextExetive = null;
    target.orvTextOffice1 = null;
    target.orvTextPostal1 = null;
    target.orvTextAddress1 = null;
    target.orvTextPhone1 = null;
    target.orvTextFax1 = null;
    target.orvTextOffice2 = null;
    target.orvTextPostal2 = null;
    target.orvTextAddress2 = null;
    target.orvTextPhone2 = null;
    target.orvTextFax2 = null;
    target.orvTextEmail1 = null;
    target.orvTextEmail2 = null;
    target.orvTextUrl1 = null;
    target.orvTextUrl2 = null;
    target.orvTextBuilding1 = null;
    target.orvTextBuilding2 = null;
    target.orvTextCellular1 = null;
    target.orvTextCellular2 = null;
  }
}
