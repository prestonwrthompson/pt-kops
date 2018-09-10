# ptworldcup

This section of the repo contains scripts for deploying a Kubernetes cluster on AWS using kops. The `teams` directory contains code for a gRPC service and creating a Docker image for that service. The `config` directory contains configurations for Kubernetes resources for deploying `teams` to Kubernetes and making it available to requests via Ambassador.

## Deploying the cluster

Follow the [instructions from kops](https://github.com/kubernetes/kops/blob/master/docs/aws.md) for setting up a subdomain and s3 bucket for the cluster.

Next, set your aws cli credentials with

```
export AWS_PROFILE=my-profile
```

Create the cluster in `us-west-2a` with

```
./create-cluster.sh cluster-name.example.com
```

This will open a text editor to edit the instance groups for the master and nodes. This is to allow you to set the desired instance size. I used `t2.micro` for both.

The cluster will now be created, but it will take a few minutes to set up. You can check for completion with

```
kops validate cluster cluster-name.example.com
```

## Deploying resources

When the cluster is ready, run

```
./start-all.sh
```

This will create namespaces and resources for Ambassador, `teams`, and a couple others. The [deployment for `teams`](config/teams-deployment.yaml) references my dockerhub repo. You can change that if you want to use your own image.

Next, you will need to use the AWS console to edit the nodes security group to add an inbound rule. Add a new `Custom TCP Rule` on port `30303` for source `0.0.0.0/0`. I hope to automate this process at some point -- I imagine it can be done by editing the kops configuration for the instance group.

Then, run the following to get the IP for either node.

```
./print-connection-info.sh
```

Use the IP to test a simple http service running on the cluster (the trailing slash is required).
```
curl <IP>:30303/qotm/
```

From the teams directory, run the following to test a request to the teams gRPC service. You will need gradle and Java 8 to run this.
```
HOST=<IP> PORT=30303 ./gradlew runClient
```

## Tearing down the cluster

Run the following to remove the resources we added. This isn't actually necessary if you are going to tear down the cluster.

```
./stop-all.sh
```

To tear down the cluster, run

```
./tear-down-cluster.sh cluster-name.example.com
```
