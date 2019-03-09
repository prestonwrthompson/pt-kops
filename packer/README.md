# packer

Simple packer examples. `example.json` is from the Packer getting started tutorial. `ami-docker-ce-packer` will create an ubuntu image that has docker installed and running, taken mostly from https://github.com/garystafford/ami-docker-ce-packer.

## Usage

For `example.json`
```
packer build example.json
```

For `ami-docker-ce-packer`, from the `ami-docker-ce-packer` directory
```
packer build ubuntu_docker_ce_ami.json
```
