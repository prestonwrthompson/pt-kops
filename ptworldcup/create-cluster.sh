#! /bin/bash

if [[ -z $1 ]]; then
  echo "must specify cluster name"
  exit 1
fi

kops create cluster --zones us-west-2a $1
kops edit instancegroup --name=$1 nodes
kops edit instancegroup --name=$1 master-us-west-2a
kops update cluster $1 --yes
