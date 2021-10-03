package triangleTests;

import io.github.sskorol.core.DataSupplier;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class TriangleTests {
    @DataSupplier
    public List<String> colors() {
        return List.of(
                "0, 0, 0",
                "255, 107, 107",
                "240, 101, 149",
                "204, 93, 232",
                "132, 94, 247",
                "92, 124, 250",
                "51, 154, 240",
                "34, 184, 207",
                "32, 201, 151",
                "81, 207, 102",
                "148, 216, 45",
                "252, 196, 25");
    }
    @DataSupplier
    public List<String> size(){
        return List.of(
                "sm",
                "md",
                "lg",
                "xl");
    }
    String hostAddress = "http://localhost:8262/";

    @DataSupplier
    public List<String> buttonDirrection() {
        return List.of(
                "direction-top-left",
                "direction-top",
                "direction-top-right",
                "direction-right",
                "direction-bottom-right",
                "direction-bottom",
                "direction-bottom-left",
                "direction-left");
    }
    @Test(dataProvider = "buttonDirrection")
    public void shouldCreateTriangleWithDifferentDirections(String dirrection) {
        open(hostAddress);
        $(By.xpath("//img[@alt='Triangle generator']")).click();                                 // triangle generator button
        $(By.xpath("//div[@class='" + dirrection + "']//ancestor::button")).click();                                  // triangle dirrection right
        $(By.xpath("//button[@type='button' and text()='xl']")).click();
        $(By.xpath("//div//button[@style='background-color: rgb(0, 0, 0);']")).click();
        // button xl
        String triangleClass = $(By.xpath("//div[starts-with(@class, 'TrianglePreview')]//child::div")).getAttribute("class");
        String triangleStyle = $(By.xpath("//div[starts-with(@class, 'TrianglePreview')]//child::div")).getAttribute("style");
        System.out.println(triangleClass);
        System.out.println(triangleStyle);
        String trianglergbColors = triangleStyle.substring(triangleStyle.indexOf("(") +1, triangleStyle.indexOf(")"));
        System.out.println(trianglergbColors);
        assertThat(triangleClass).isEqualTo(dirrection);
    }

    @Test(dataProvider = "colors")
    public void shouldCreateTriangleWithDifferentcolors(String expectedColor) {
        open(hostAddress);
        $(By.xpath("//img[@alt='Triangle generator']")).click();                                 // triangle generator button
        $(By.xpath("//div[@class='direction-right']//ancestor::button")).click();                                  // triangle dirrection right
        $(By.xpath("//button[@type='button' and text()='xl']")).click();
        $(By.xpath("//div//button[@style='background-color: rgb("+ expectedColor +");']")).click();
        // button xl
        String triangleClass = $(By.xpath("//div[starts-with(@class, 'TrianglePreview')]//child::div")).getAttribute("class");
        String triangleStyle = $(By.xpath("//div[starts-with(@class, 'TrianglePreview')]//child::div")).getAttribute("style");
        System.out.println(triangleClass);
        System.out.println(triangleStyle);
        String trianglergbColors = triangleStyle.substring(triangleStyle.indexOf("(") +1, triangleStyle.indexOf(")"));
        System.out.println(trianglergbColors);
        assertThat(trianglergbColors).isEqualTo(expectedColor);
    }

    @Test(dataProvider = "size")
    public void shouldCreateTriangleWithDifferentSizes(String expectedSize) {
        open(hostAddress);
        $(By.xpath("//img[@alt='Triangle generator']")).click();                                 // triangle generator button
        $(By.xpath("//div[@class='direction-top-right']//ancestor::button")).click();                                  // triangle dirrection right
        $(By.xpath("//button[@type='button' and text()='"+ expectedSize +"']")).click();
        $(By.xpath("//div//button[@style='background-color: rgb(240, 101, 149);']")).click();
        // button xl
        String triangleClass = $(By.xpath("//div[starts-with(@class, 'TrianglePreview')]//child::div")).getAttribute("class");
        String triangleStyle = $(By.xpath("//div[starts-with(@class, 'TrianglePreview')]//child::div")).getAttribute("style");
        System.out.println(triangleClass);
        System.out.println(triangleStyle);
        // String borderStyle = triangleStyle.substring(triangleStyle.lastIndexOf("border-width: "), triangleStyle.indexOf(";"));
        triangleStyle = triangleStyle.substring(triangleStyle.indexOf("border-width: "));
        triangleStyle = triangleStyle.substring(triangleStyle.indexOf("border-width: "), triangleStyle.indexOf(";"));
        System.out.println(triangleStyle);
        String expectedSizeToPixels = null;
        if (expectedSize == "sm"){
            expectedSizeToPixels = "border-width: 0px 10px 6px 0px";
        }
        if (expectedSize == "md"){
            expectedSizeToPixels = "border-width: 0px 22px 12px 0px";
        }
        if (expectedSize == "lg"){
            expectedSizeToPixels = "border-width: 0px 54px 36px 0px;";
        }
        if (expectedSize == "xl"){
            expectedSizeToPixels = "border-width: 0px 128px 94px 0px;";
        }
        assertThat(triangleStyle).isEqualTo(expectedSizeToPixels);
    }
}
