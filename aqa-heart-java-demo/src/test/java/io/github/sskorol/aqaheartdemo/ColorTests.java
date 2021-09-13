package io.github.sskorol.aqaheartdemo;

import io.github.sskorol.core.DataSupplier;
import org.testng.annotations.Test;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class ColorTests {
    @DataSupplier
    public List<String> colors() {
        return List.of(
                "#D0021B",
                "#F5A623",
                "#F8E71C",
                "#8B572A",
                "#7ED321",
                "#417505",
                "#BD10E0",
                "#9013FE",
                "#4A90E2",
                "#50E3C2",
                "#B8E986",
                "#000000",
                "#4A4A4A",
                "#9B9B9B",
                "#FFFFFF"
        );
    }

    @Test(dataProvider = "colors")
    public void shouldChangeHeartColor(String expectedColor) throws InterruptedException {
        open("http://localhost:3000");
        $("#heart").click();
       $(".flexbox-fix div[title='"+ expectedColor +"']").click();
       Thread.sleep(2000);
        String actualColor = $("#heart>path").getAttribute("fill");

        assertThat(actualColor).isEqualToIgnoringCase(expectedColor);
    }
}
