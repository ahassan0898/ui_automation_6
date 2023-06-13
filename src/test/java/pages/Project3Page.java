package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class Project3Page {


    public Project3Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "input[value='One way']")
    public WebElement oneWayRadioButton;

    @FindBy(css = "label:nth-child(2)")
    public WebElement roundTripRadioButton;

    @FindBy(xpath = "(//div[@class='field']/label)[1]")
    public WebElement cabinClassLabel;
    @FindBy(xpath = "(//div[@style='width: 100%;']/select)[1]")
    public WebElement cabinClassDropdown;

    @FindBy(css = "div:nth-child(3) ")
    public WebElement fromLabel;

    @FindBy(css = "div:nth-child(3) > div > select")
    public WebElement fromLabelDropDown;

    @FindBy(css = "div:nth-child(4) > label")
    public WebElement toLabel;

    @FindBy(css = "div:nth-child(4) > div > select")
    public WebElement toDropDown;

    @FindBy(css = "div:nth-child(5) > label")
    public WebElement departLabel;

    @FindBy(css = ".react-date-picker")
    public WebElement datePickerDepart;

    @FindBy(xpath = "(//div[@class='field']/label)[5]")
    public WebElement returnLabel;

    @FindBy(css = ".react-date-picker__inputGroup")
    public WebElement datePickerReturn;

    @FindBy(xpath = "(//div[@class='field']/label)[6]")
    public WebElement numberOfPassengersLabel;

    @FindBy(css = "form>div>div:nth-child(7)>div")
    public WebElement numPassengerBox;

    @FindBy(xpath = "(//div[@class='field']/label)[7]")
    public WebElement passenger1Label;

    @FindBy(css = "form>div>div:nth-child(8)>div>select")
    public WebElement passenger1_AgeDropdown;

    @FindBy(css = "button[class^='Button']")
    public WebElement bookButton;
}
