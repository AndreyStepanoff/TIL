## AQA Courses - Lecture 2/3 - Demo

### Installation

Create a fork of a demo [repo](https://github.com/sskorol/aqa-heart-js-demo.git).

```shell
git clone https://github.com/[YOUR_GH_ID]/aqa-heart-js-demo.git && cd aqa-heart-js-demo
docker-compose up -d
npm ci
```

### Running Tests

```shell
npm test
```

### Report Generation

```shell
./generate_report.sh
```

### Tasks

- [x] Run tests from WebStorm
- [x] Run tests from CLI
- [x] Investigate issues
- [x] Fix broken tests
- [x] Create a new paragraph in README with a list of fixes you made
- [x] Push to remote
- [x] Update checkboxes of the completed tasks
- [x] Share a link with your mentor


### Fixed issues

- baseUrl: 'http://localhost:3000' in wdio.conf.js
- fix css selector (".flexbox-fix div[title='" + expectedColor + "']")