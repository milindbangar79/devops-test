variable "environment" {
  default = "dev"
}

variable "customer" {
  type        = "string"
  description = "Name of the VPC"
  default     = "ThreeTier"
}

variable "organization" {
  default = "Platform"
}

data "null_data_source" "tags" {
  inputs = {
    "ApplicationName" = "${ var.application_name }"
    "Environment"     = "${ var.environment }"
    "ManagedBy"       = "Terraform"
    "Organization"    = "${ var.organization }"
    "Customer"        = "${ var.customer }"
  }
}
