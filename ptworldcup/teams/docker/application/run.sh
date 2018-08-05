#!/bin/bash
set -ex

# Run our Application
set -- java -jar teams-0.0.1.jar
set -x
exec "$@"