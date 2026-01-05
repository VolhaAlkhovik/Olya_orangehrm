import config.Config;
import entities.Job;
import org.testng.annotations.Test;
import pages.LoginPage;
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

    sidePanel.adminButton().clickJobButton().clickJobTitle().clickAddButton().enterJobTitle(job);
  }
}
