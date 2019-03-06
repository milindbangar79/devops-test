output "vpc_id" {
  description = "The ID of the VPC"
  value       = "${element(concat(aws_vpc.default.*.id, list("")), 0)}"
}

output "vpc_cidr_block" {
  description = "The CIDR block of the VPC"
  value       = "${element(concat(aws_vpc.default.*.cidr_block, list("")), 0)}"
}

output "default_security_group_id" {
  description = "The ID of the security group created by default on VPC creation"
  value       = "${element(concat(aws_vpc.default.*.default_security_group_id, list("")), 0)}"
}

output "default_network_acl_id" {
  description = "The ID of the default network ACL"
  value       = "${element(concat(aws_vpc.default.*.default_network_acl_id, list("")), 0)}"
}

output "default_route_table_id" {
  description = "The ID of the default route table"
  value       = "${element(concat(aws_vpc.default.*.default_route_table_id, list("")), 0)}"
}

output "vpc_instance_tenancy" {
  description = "Tenancy of instances spin up within VPC"
  value       = "${element(concat(aws_vpc.default.*.instance_tenancy, list("")), 0)}"
}

output "vpc_enable_dns_support" {
  description = "Whether or not the VPC has DNS support"
  value       = "${element(concat(aws_vpc.default.*.enable_dns_support, list("")), 0)}"
}

output "vpc_enable_dns_hostnames" {
  description = "Whether or not the VPC has DNS hostname support"
  value       = "${element(concat(aws_vpc.default.*.enable_dns_hostnames, list("")), 0)}"
}

output "vpc_main_route_table_id" {
  description = "The ID of the main route table associated with this VPC"
  value       = "${element(concat(aws_vpc.default.*.main_route_table_id, list("")), 0)}"
}

#output "vpc_secondary_cidr_blocks" {
 # description = "List of secondary CIDR blocks of the VPC"
  #value       = ["${aws_vpc_ipv4_cidr_block_association.this.*.cidr_block}"]
#}

output "private_subnets" {
  description = "List of IDs of private subnets"
  value       = ["${aws_subnet.private-subnet.*.id}"]
}

output "private_subnets_cidr_blocks" {
  description = "List of cidr_blocks of private subnets"
  value       = ["${aws_subnet.private-subnet.*.cidr_block}"]
}

output "public_subnets" {
  description = "List of IDs of public subnets"
  value       = ["${aws_subnet.public-subnet.*.id}"]
}

output "public_subnets_cidr_blocks" {
  description = "List of cidr_blocks of public subnets"
  value       = ["${aws_subnet.public-subnet.*.cidr_block}"]
}

#Commenting as resources are not created as part of exercise
#output "public_route_table_ids" {
 # description = "List of IDs of public route tables"
  #value       = ["${aws_route_table.public.*.id}"]
#}

#output "private_route_table_ids" {
 # description = "List of IDs of private route tables"
  #value       = ["${aws_route_table.private.*.id}"]
#}

output "database_route_table_ids" {
  description = "List of IDs of database route tables"
  value       = ["${coalescelist(aws_route_table.web-public-rt.*.id, aws_route_table.web-public-rt.*.id)}"]
}


output "igw_id" {
  description = "The ID of the Internet Gateway"
  value       = "${element(concat(aws_internet_gateway.gw.*.id, list("")), 0)}"
}


#output "default_vpc_main_route_table_id" {
 # description = "The ID of the main route table associated with this VPC"
  #value       = "${element(concat(aws_default_vpc.this.*.main_route_table_id, list("")), 0)}"
#}

# VPC Endpoints
#output "vpc_endpoint_s3_id" {
 # description = "The ID of VPC endpoint for S3"
  #value       = "${element(concat(aws_vpc_endpoint.s3.*.id, list("")), 0)}"
#}

#output "vpc_endpoint_s3_pl_id" {
 # description = "The prefix list for the S3 VPC endpoint."
  #value       = "${element(concat(aws_vpc_endpoint.s3.*.prefix_list_id, list("")), 0)}"
#}


#output "vpc_endpoint_ec2_id" {
 # description = "The ID of VPC endpoint for EC2"
  #value       = "${element(concat(aws_vpc_endpoint.ec2.*.id, list("")), 0)}"
#}

#output "vpc_endpoint_ec2_network_interface_ids" {
 # description = "One or more network interfaces for the VPC Endpoint for EC2"
  #value       = "${flatten(aws_vpc_endpoint.ec2.*.network_interface_ids)}"
#}


#output "vpc_endpoint_ec2messages_id" {
 # description = "The ID of VPC endpoint for EC2MESSAGES"
  #value       = "${element(concat(aws_vpc_endpoint.ec2messages.*.id, list("")), 0)}"
#}

#output "vpc_endpoint_ec2messages_network_interface_ids" {
 # description = "One or more network interfaces for the VPC Endpoint for EC2MESSAGES"
  #value       = "${flatten(aws_vpc_endpoint.ec2messages.*.network_interface_ids)}"
#}

# Static values (arguments)
output "azs" {
  description = "A list of availability zones specified as argument to this module"
  value       = "${var.azs}"
}

# ELB
output "this_elb_id" {
  description = "The name of the ELB"
  value       = "${module.elb.this_elb_id}"
}

output "this_elb_name" {
  description = "The name of the ELB"
  value       = "${module.elb.this_elb_name}"
}

output "this_elb_dns_name" {
  description = "The DNS name of the ELB"
  value       = "${module.elb.this_elb_dns_name}"
}

output "this_elb_instances" {
  description = "The list of instances in the ELB (if may be outdated, because instances are attached using elb_attachment resource)"
  value       = ["${module.elb.this_elb_instances}"]
}

output "this_elb_source_security_group_id" {
  description = "The ID of the security group that you can use as part of your inbound rules for your load balancer's back-end application instances"
  value       = "${module.elb.this_elb_source_security_group_id}"
}

output "this_elb_zone_id" {
  description = "The canonical hosted zone ID of the ELB (to be used in a Route 53 Alias record)"
  value       = "${module.elb.this_elb_zone_id}"
}

