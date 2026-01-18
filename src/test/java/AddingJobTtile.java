import config.Config;
import entities.Job;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SaveJobTitle;
import pages.SidePanel;

public class AddingJobTtile extends BaseTest {

  @Test
  public void addingJobTitle() {

    LoginPage loginPage = new LoginPage(driver);
    loginPage.successLogin(Config.get("app.username"), Config.get("app.password"));
    SidePanel sidePanel = new SidePanel(driver);

    Job job =
        Job.builder()
            .jobTitlefield(faker.job().title())
            .jobDescription(faker.job().keySkills())
            .build();

    SaveJobTitle saveJobTitle = sidePanel.adminButton().clickJobButton().clickJobTitle().clickAddButton().enterJobTitle(job);

    Assert.assertTrue(saveJobTitle.isSuccessToasterDisplayed(), "Success toaster is not displayed");

  }


}
