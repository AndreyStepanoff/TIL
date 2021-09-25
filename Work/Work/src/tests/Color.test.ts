import { suite, test } from "@testdeck/mocha";
import { expect } from "chai";
import { data } from "../utils/decorators";

@suite
class ColorTests {
  @data([
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
  ])
  @test
  public shouldChangeHeartColor(expectedColor: string) {
    browser.url("/");
    $("#heart").click();
    $(".flexbox-fix div[title='" + expectedColor + "']").click();
    const actualColor = $("#heart>path").getAttribute("fill");

    expect(actualColor).to.be.equalIgnoreCase(expectedColor);
  }
}
