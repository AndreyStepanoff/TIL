#!/bin/bash

ALLURE="allure"
ALLURE_VERSION="2.14.0"
ZIP_NAME="$ALLURE.zip"

if [ ! -d "$ALLURE_FOLDER" ]; then
  curl -L "https://github.com/allure-framework/allure2/releases/download/$ALLURE_VERSION/allure-$ALLURE_VERSION.zip" -o "$ZIP_NAME"
  unzip "$ZIP_NAME" && mv "allure-$ALLURE_VERSION" "$ALLURE"
fi

ALLURE_BIN="./$ALLURE/bin/allure"
$ALLURE_BIN generate -c -o build/reports/allure-report allure-results
$ALLURE_BIN open build/reports/allure-report
