#! /bin/bash

./create-namespaces.sh
kubectl apply -f config -R
