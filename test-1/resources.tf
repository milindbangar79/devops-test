# Define SSH key pair for our instances
resource "aws_key_pair" "default" {
  key_name = "threetier"
  public_key = "${file("${var.key_path}")}"
}

# Define webserver inside the private subnet
resource "aws_instance" "wb" {

   ami  = "${var.ami}"
   instance_type = "t1.micro"
   key_name = "${aws_key_pair.default.id}"
   subnet_id = "${aws_subnet.private-subnet.id}"
   vpc_security_group_ids = ["${aws_security_group.sgweb.id}"]
   user_data = "${file("userdata.sh")}"

  tags {
    Name = "application-webserver"
  }
}

# Define database inside the private subnet
resource "aws_instance" "db" {

   ami  = "${var.ami}"
   instance_type = "t1.micro"
   key_name = "${aws_key_pair.default.id}"
   subnet_id = "${aws_subnet.private-subnet.id}"
   vpc_security_group_ids = ["${aws_security_group.sgdb.id}"]

  tags {
    Name = "application-database"
  }
}
