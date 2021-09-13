## AQA Courses - Lecture 2 - Demo

### Installation

Create a fork of a demo [repo](https://github.com/sskorol/aqa-heart-java-demo.git).

```shell
git clone https://github.com/[YOUR_GH_ID]/aqa-heart-java-demo.git && cd aqa-heart-java-demo
docker-compose up -d
```

### Running Tests

```shell
./gradlew clean test
```

### Report Generation

```shell
./generate_report.sh
```

### Tasks

- [x] Run tests from IntelliJ IDEA
- [x] Run tests from CLI
- [x] Investigate issues
- [x] Fix broken tests
- [x] Create a new paragraph in README with a list of fixes you made
- [x] Push to remote
- [x] Update checkboxes of the completed tasks
- [x] Share a link with your mentor


### Fixed issues:

- Fix colors list;
- Fix css selector "$(".flexbox-fix div[title='"+ expectedColor +"']").click();"
- Fix css selector $("#heart>path").getAttribute("fill");
- Add small delay between tests (Thread.sleep is bad solution I know ;)