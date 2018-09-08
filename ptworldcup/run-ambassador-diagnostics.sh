#! /bin/bash

pod_name=$(kubectl get pods -o go-template --template '{{range .items}}{{.metadata.name}}{{"\n"}}{{end}}' -n ambassador | head -n 1)
echo "Visit diagnostics at http://localhost:8877/ambassador/v0/diag/"
kubectl port-forward $pod_name -n ambassador 8877
