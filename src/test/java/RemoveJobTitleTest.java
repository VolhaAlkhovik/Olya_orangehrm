import config.Config;
import entities.Job;

import pages.JobTitleView;
import pages.LoginPage;
import pages.SaveJobTitle;
import pages.SidePanel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoveJobTitleTest extends BaseTest {

    @Test
    public void removeJobTitle() {
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

        JobTitleView jobTitleView = new JobTitleView(driver);
        jobTitleView.removeJobTitle(job.getJobTitlefield()).clickYesButton().checkSuccessToaster();

    }

}
