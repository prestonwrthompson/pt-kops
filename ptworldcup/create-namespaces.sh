#! /bin/bash

create-namespace-if-not-exists () {
  ns=`kubectl get namespace $1 --no-headers --output=go-template={{.metadata.name}} 2>/dev/null`
  if [ -z "${ns}" ]; then
    kubectl create ns $1
  fi
}

create-namespace-if-not-exists teams
create-namespace-if-not-exists qotm
create-namespace-if-not-exists ambassador
create-namespace-if-not-exists grpc-greet
