package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SwipeableBasicScreen extends BaseScreen{

    public SwipeableBasicScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@resource-id='android:id/text1']")
    List<MobileElement> list;
    @FindBy(xpath = "//*[@resource-id='android:id/button1']")
    MobileElement okButton;

    public SwipeableBasicScreen swipeFromLeftToRight(int index) {
        MobileElement element = list.get(index);
        Rectangle rect= element.getRect();
        int xFrom =rect.getX()+rect.getWidth()/2;
        int yFrom = rect.getY()+ rect.getHeight()/2;

        int xTo= xFrom+ rect.getWidth()/2;
        int yTo= yFrom;

        TouchAction<?> touchAction= new TouchAction<>(driver);
        touchAction.longPress(PointOption.point(xFrom,yFrom))
                .moveTo(PointOption.point(xTo,yTo))
                .release().perform();

        return this;
    }

    public SwipeableBasicScreen swipeFromRightToLeft(int index) {
        MobileElement element = list.get(index);
        Rectangle rect= element.getRect();
        int xFrom =rect.getX()+rect.getWidth()/2;
        int yFrom = rect.getY()+ rect.getHeight()/2;

        int xTo= xFrom- rect.getWidth()/2;
        int yTo= yFrom;

        TouchAction<?> touchAction= new TouchAction<>(driver);
        touchAction.longPress(PointOption.point(xFrom,yFrom))
                .moveTo(PointOption.point(xTo,yTo))
                .release().perform();

        return this;
    }

    public SwipeableBasicScreen confirm() {
        okButton.click();
        return this;
    }
}
