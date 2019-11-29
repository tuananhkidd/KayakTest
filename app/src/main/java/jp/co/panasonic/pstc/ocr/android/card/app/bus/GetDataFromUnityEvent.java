package jp.co.panasonic.pstc.ocr.android.card.app.bus;

public class GetDataFromUnityEvent {
    private String base64String;

    public GetDataFromUnityEvent(String base64String) {
        this.base64String = base64String;
    }

    public String getBase64String() {
        return base64String;
    }

    public void setBase64String(String base64String) {
        this.base64String = base64String;
    }
}
