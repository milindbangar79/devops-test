data "template_file" "ssh_ec2_iam_user_data" {
  template = "${file("ssh-ec2-iam-user-data.tpl")}"

  vars {
    user_group           = "${ var.application_name }-${ var.user_group }"
    root_user_group      = "${ var.application_name }-${ var.root_user_group }"
    additional_user_data = ""
  }
}
