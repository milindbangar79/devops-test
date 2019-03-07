######
# ELB
######
module "elb" {
  source  = "terraform-aws-modules/elb/aws"
  version = "1.4.1"

  name = "threetier-elb"

  subnets         = ["${aws_subnet.public-subnet.id}"]
  security_groups = ["${aws_security_group.elb.id}"]
  internal        = false
  
  #Should be true for multiple availability zones
  cross_zone_load_balancing = false

  listener = [
    {
      instance_port     = "80"
      instance_protocol = "HTTP"
      lb_port           = "80"
      lb_protocol       = "HTTP"
    },
    {
      instance_port     = "8080"
      instance_protocol = "HTTP"
      lb_port           = "8080"
      lb_protocol       = "HTTP"
    },
   # {
    #  instance_port     = "443"
     # instance_protocol = "HTTPS"
     # lb_port           = "443"
     # lb_protocol       = "HTTPS"
    #},
  ]

  health_check = [
    {
      target              = "HTTP:80/"
      interval            = 30
      healthy_threshold   = 2
      unhealthy_threshold = 2
      timeout             = 5
    },
  ]

  // Uncomment this section and set correct bucket name to enable access logging
  //  access_logs = [
  //    {
  //      bucket = "my-access-logs-bucket"
  //    },
  //  ]

  tags = {
    Owner       = "mbangar"
    Environment = "dev"
  }
  # ELB attachments
  number_of_instances = "${var.number_of_instances}"
  instances           = ["${module.ec2_instances.id}"]
}

################
# EC2 instances
################
module "ec2_instances" {
  source = "terraform-aws-modules/ec2-instance/aws"

  instance_count = "${var.number_of_instances}"

  name                        = "threetier-elb"
  ami                         = "${var.ami}"
  instance_type               = "t2.micro"

  # The same availability zone as our instance
  
  vpc_security_group_ids      = ["${aws_security_group.elb.id}"]
  subnet_id                   = "${aws_subnet.public-subnet.id}"
  associate_public_ip_address = true
}