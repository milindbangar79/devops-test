module "bastion" {
  source  = "terraform-aws-modules/ec2-instance/aws"
  version = "1.13.0"

  name           = "bastion"
  instance_count = 1

  ami                         = "${var.ami}"
  instance_type               = "${var.bastion-instance-type}"
  monitoring                  = true
  vpc_security_group_ids      = ["${ module.bastion_sg.this_security_group_id }"]
  subnet_id                   = "${aws_subnet.public-subnet.id}"
  associate_public_ip_address = true
  iam_instance_profile        = "${ aws_iam_instance_profile.bastion.name }"
  user_data                   = "${ data.template_file.ssh_ec2_iam_user_data.rendered }"

  root_block_device = [{
    delete_on_termination = true
    volume_size           = "8"
    volume_type           = "standard"
  }]

  tags = "${ merge(data.null_data_source.tags.inputs, map("Name", format("%s-bastion", var.application_name))) }"
}

module "bastion_sg" {
  source  = "terraform-aws-modules/security-group/aws"
  version = "2.9.0"

  name        = "bastion-security-group"
  description = "Security group for bastion host and open to all"
  vpc_id      = "${aws_vpc.default.id}"

  ingress_with_cidr_blocks = [
    {
      from_port   = 22
      to_port     = 22
      protocol    = "tcp"
      description = "SSH Port"
      cidr_blocks = "0.0.0.0/0"
    },
  ]

  egress_with_cidr_blocks = [
    {
      from_port   = 0
      to_port     = 0
      protocol    = "-1"
      cidr_blocks = "0.0.0.0/0"
    },
  ]

  tags = "${ merge(data.null_data_source.tags.inputs, map("Name", format("%s-bastion-sg", var.application_name))) }"
}

# Policy for Elastic search server to discover nodes
resource "aws_iam_instance_profile" "bastion" {
  name = "${ var.application_name }-bastion"
  role = "${ aws_iam_role.bastion.name }"
}

resource "aws_iam_role" "bastion" {
  name = "${ var.application_name }-bastion-role"
  path = "/"

  assume_role_policy = <<EOF
{
  "Version": "2012-10-17",
  "Statement": [ {
    "Action": "sts:AssumeRole",
    "Principal": {
    "Service": "ec2.amazonaws.com"
    },
    "Effect": "Allow",
    "Sid": ""
  }]
}
EOF
}
