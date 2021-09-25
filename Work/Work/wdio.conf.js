exports.config = {
  sync: true,
  runner: 'local',
  specs: [
    './dist/tests/**/*.test.js'
  ],
  maxInstances: 1,
  capabilities: [{
    browserName: 'chrome'
  }],
  logLevel: 'trace',
  coloredLogs: true,
  bail: 0,
  baseUrl: 'http://localhost:3000',
  waitforTimeout: 5000,
  connectionRetryTimeout: 90000,
  connectionRetryCount: 3,
  framework: 'mocha',
  reporters: [
    [
      'allure',
      {
        resultsDir: './allure-results',
        disableWebdriverStepsReporting: true,
        disableWebdriverScreenshotsReporting: true,
        disableMochaHooks: true
      }
    ]
  ],
  mochaOpts: {
    timeout: 60000,
    compilers: ['ts:ts-node/register'],
    require: ['source-map-support/register']
  },
  before: function(capabilities, specs) {
    global.reporter = require('@wdio/allure-reporter').default
    const chai = require('chai')
    chai.use(require('chai-string'))
    chai.config.includeStack = true
    chai.config.showDiff = true
    chai.config.truncateThreshold = 0
    global.expect = chai.expect
  }
}
