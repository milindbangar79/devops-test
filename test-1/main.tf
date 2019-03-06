locals {
  
  # Use `local.vpc_id` to give a hint to Terraform that subnets should be deleted before secondary CIDR blocks can be free!
  #vpc_id = "${element(concat(aws_vpc_ipv4_cidr_block_association.this.*.vpc_id, aws_vpc.this.*.id, list("")), 0)}"
}


################
# Public subnet
################
resource "aws_vpc" "default" {

  cidr_block = "${var.vpc_cidr}"
  enable_dns_hostnames = "${var.enable_dns_hostnames}"
  enable_classiclink = "${var.enable_classiclink}"

  tags {
    Name = "threetier-application-vpc"
    BuildWith = "terraform"
  }
}


################
# Public subnet
################
resource "aws_subnet" "public-subnet" {
  vpc_id = "${aws_vpc.default.id}"
  cidr_block = "${var.public_subnet_cidr}"
  availability_zone = "${var.azs[0]}"

  tags {
    Name = "Web Public Subnet"
    BuildWith = "terraform"
  }
}

#################
# Private subnet
#################
resource "aws_subnet" "private-subnet" {
  vpc_id = "${aws_vpc.default.id}"
  cidr_block = "${var.private_subnet_cidr}"
  availability_zone = "${var.azs[0]}"

  tags {
    Name = "Database Private Subnet"
    BuildWith = "terraform"
  }
}

# Define the internet gateway
resource "aws_internet_gateway" "gw" {
  vpc_id = "${aws_vpc.default.id}"

  tags {
    Name = "VPC Internet Gateway"
    BuildWith = "terraform"
  }
}



# Define the route table
resource "aws_route_table" "web-public-rt" {
  vpc_id = "${aws_vpc.default.id}"

  route {
    cidr_block = "0.0.0.0/0"
    gateway_id = "${aws_internet_gateway.gw.id}"
  }

  tags {
    Name = "Public Subnet RT"
    BuildWith = "terraform"
  }
}

# Assign the route table to the public Subnet
resource "aws_route_table_association" "web-public-rt" {
  subnet_id = "${aws_subnet.public-subnet.id}"
  route_table_id = "${aws_route_table.web-public-rt.id}"
}