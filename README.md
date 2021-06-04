# TIL
Today I learned Python fundamentals

today I learned how to create sloppy bash scripts
Look at it:

 Create a shell script with code bellow andpass 2 arguments :


#!/bin/bash
curl -X POST -F username=$1 -F password=secret http://localhost:8000/auth | grep -o -P '(?<="access_token":").*(?=","token_type")' >token1.txt
token=$(cat token1.txt)
echo $token
curl http://localhost:8000/image -H "Authorization: Bearer $token" --output $2