#! /bin/bash

if [[ -z $1 ]]; then
  echo "must specify cluster name"
  exit 1
fi

kops delete cluster $1 --yes
