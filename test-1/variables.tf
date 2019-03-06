variable "create_vpc" {
  description = "Controls if VPC should be created (it affects almost all resources)"
  default     = true
}
variable "region" {
  default = "eu-west-1"
}

variable "aws_region" {
  default = "eu-west-1"
}

variable "azs" {
  default = ["eu-west-1a", "eu-west-1b", "eu-west-1c"]
}

variable "private_subnets" {
  default = ["10.0.1.0/24", "10.0.2.0/24", "10.0.3.0/24"]
}

variable "public_subnets" {
  default = ["10.0.101.0/24", "10.0.102.0/24", "10.0.103.0/24"]
}

variable "vpc_cidr" {
  description = "CIDR for the VPC"
  default = "10.0.0.0/16"
}

variable "public_subnet_cidr" {
  description = "CIDR for the public subnet"
  default = "10.0.1.0/24"
}

variable "private_subnet_cidr" {
  description = "CIDR for the private subnet"
  default = "10.0.2.0/24"
}

variable "public_subnet_tag" {
  default = "web-application"
}

variable "application_name" {
  default = "three-tier-application"
  
}

variable "ami" {
  description = "Amazon Linux AMI"
  default = "ami-031a3db8bacbcdc20"
}

variable "key_path" {
  description = "SSH Public Key path"
  default = "test_rsa.pub"
}

variable "key_name" {
  description = "Key Pair  to be used with ELB"
  default = "threetier"  
}

variable "enable_dns_hostnames" {
  description = "Should be true to enable DNS support in the Default VPC"
  default = true
}

variable "enable_classiclink" {
  description = "Should be true to enable ClassicLink in the Default VPC"
  default = false
  
}

variable "intra_subnets" {
  type        = "list"
  description = "A list of intra subnets"
  default     = []
}

variable "enable_s3_endpoint" {
  description = "Should be true if you want to provision an S3 endpoint to the VPC"
  default     = false
}

variable "number_of_instances" {
  description = "Number of instances to create and attach to ELB"
  default     = 1
}

variable "user_group" {
  default = "bastion-users" 
}

variable "root_user_group" {
  default = "common-root-users"  
}


