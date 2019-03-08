resource "aws_instance" "bastion" {
  ami                         = "${var.ami}"
  instance_type               = "t2.micro"
  associate_public_ip_address = true
  key_name                    = "${aws_key_pair.bastion_key.id}"
  subnet_id                   = "${aws_subnet.public-subnet.id}"
  vpc_security_group_ids      = ["${aws_security_group.bastion-sg.id}"]
  source_dest_check           = false

  tags {
    Name = "threetier-bastion-host"
  }
}

resource "aws_key_pair" "bastion_key" {
  key_name   = "bastion-three-tier"
  public_key = "${file("${var.key_path}")}"
}