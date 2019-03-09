provider "aws" {
  access_key = "${var.access_key}"
  secret_key = "${var.secret_key}"
  region     = "${var.region}"
}

resource "aws_instance" "example" {
  ami           = "${var.ami}"
  instance_type = "t2.micro"
  key_name      = "${aws_key_pair.terraform_getting_started.key_name}"

  security_groups = [
    "${aws_security_group.allow_ssh.name}",
  ]

  tags = {
    Name = "TerraformGettingStarted"
  }
}

resource "aws_eip" "ip" {
  instance = "${aws_instance.example.id}"
}

resource "aws_key_pair" "terraform_getting_started" {
  key_name   = "terraform-getting-started"
  public_key = "${var.ssh_public_key}"
}

resource "aws_security_group" "allow_ssh" {
  name        = "allow_ssh"
  description = "Allow SSH inbound traffic"

  ingress {
    from_port   = 22
    to_port     = 22
    protocol    = "tcp"
    cidr_blocks = ["${var.my_ip}"]
  }

  tags = {
    Name = "allow_ssh"
  }
}

output "ip" {
  value = "${aws_eip.ip.public_ip}"
}
