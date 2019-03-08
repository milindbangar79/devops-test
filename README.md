# Devops Tests Repository

This is the test repo for Devops.

Folloiwng are the folders in the repository to address different questions in the test:

# Test 1 : Create 3 Tier Environment 
# Test 2 : Fetch the metadata of the resources created in Test 1 
# Test 3 : Evaluate an object and provide the expected outcome 


## Test 1 :  Create 3 Tier Environment ##

The sample code is available under "test-1" folder of the respository.

Cloud provider and tool used :

1. AWS Cloud Provider
2. Terraform for infra provisoning 

The Terraform scripts can currently be run using following commands :

```
1. terraform init
2. terraform plan
3. terraform apply
```
Terraform scripts will create the following artefacts on AWS :

```
1. Virtual Private Cloud 
2. Elastic Load Balancer with an EC2 instance 
3. Bastian host - to connect through SSH to other EC2 instance (including Private)
4. EC2 instances including:
  a. ELB - With Public IP
  b. Web Tier
  c. Database Tier
  d. Bastion
5. Subnets ( 1 Public and 1 Private - Configurable for nore)
  a. Public - applied to ELB and Bastion only
  b. Private - applied to Web and Database Tiers
6. Security Groups with Ingress and Egress rule for each resource created (Only on TCP)
  a. Ingress Rules for ELB 
     a) Incoming traffic on port 80
     b) SSH 22(from bastion only)
     c) 443(Not implemented. Requires Certificate)
     d) ICMP : To report any error with network 
     e) Denied access on any other port(s)
  b. Egress Rules for ELB (sgweb)
     a) Outgoing traffic on port 80 to Web Tier
     b) Denied access on any other port(s)
  c. Ingress Rules for Web Tier
     a) Incoming traffic on port 80 - Routed traffic from ELB
     b) SSH 22(from bastion only)
     c) 443(Not implemented. Requires Certificate)
     d) ICMP : To report any error with network 
     e) Denied access on any other port(s)
   d. Egress Rules for Web Tier (sgweb)
     a) Denied access on any other port(s)
   e. Ingress Rules for Database Tier (sgdb - for MySQL Database)  
     a) Incoming Traffic allowed only on PORT 3306
   f. Egress Rules for Database Tier (sgdb)
     a) Denied access on any other tcp port
7. Network ACL
```

## Test 2 : Fetch the metadata of cloud resources created in Test 1 ##

The sample code is available under "test-2" folder of the respository.

Platform : AWS , Resource : EC2

Tools  : AWS Java SDK 

Java Build Tool : Maven

Maven Dependency :

```
<dependencyManagement>
		<dependencies>
			<dependency>
				<groupId>software.amazon.awssdk</groupId>
				<artifactId>bom</artifactId>
				<version>${sdk-bom.version}</version>
				<type>pom</type>
				<scope>import</scope>
			</dependency>
		</dependencies>
	</dependencyManagement>

	<dependencies>
		<dependency>
			<groupId>software.amazon.awssdk</groupId>
			<artifactId>ec2</artifactId>
		</dependency>
	</dependencies>
```

Approach Used :
```
1. Created a Java client for EC2 
2. Used EnvironmentVariableCredentialsProvider to connect to AWS . Had created the environment variables {AWS_ACCESS_KEY_ID} and {AWS_SECRET_ACCESS_KEY}
3. Following metadata for EC2 was considered:
  a) Instance
  b) Security Groups - Currently getting an issue Security group Not Attached to Default VPC 
  c) Address
  d) Region
  e) Zone
  f) KeyPair
4. Generated the JSON using custom objects (POJOs) , as EC2 response methods return non-serializable objects 
```

Sample JSON output from the Client :

```
{
  "address" : [ ],
  "zone" : [ {
    "state" : "available",
    "regionName" : "eu-west-2",
    "zoneName" : "eu-west-2a",
    "zoneId" : "euw2-az2"
  }, {
    "state" : "available",
    "regionName" : "eu-west-2",
    "zoneName" : "eu-west-2b",
    "zoneId" : "euw2-az3"
  }, {
    "state" : "available",
    "regionName" : "eu-west-2",
    "zoneName" : "eu-west-2c",
    "zoneId" : "euw2-az1"
  } ],
  "instance" : [ {
    "imageId" : "ami-0a15b1ad20094b9f5",
    "instanceId" : "i-06828911924cffbea",
    "instanceType" : "T2_MICRO",
    "kernelId" : null,
    "keyName" : null,
    "launchTime" : {
      "nano" : 0,
      "epochSecond" : 1551963818
    },
    "monitoring" : "disabled",
    "availabilityZone" : null,
    "affinity" : null,
    "groupName" : null,
    "partitionNumber" : null,
    "hostId" : null,
    "tenancy" : null,
    "spreadDomain" : null,
    "platform" : null,
    "privateIpAddress" : "10.0.1.242",
    "publicDnsName" : "ec2-35-176-43-205.eu-west-2.compute.amazonaws.com",
    "publicIpAddress" : null,
    "stateTransitionReason" : null,
    "subnetId" : "subnet-0a35bca9d0c2edd15",
    "vpcId" : null,
    "architecture" : "x86_64",
    "ebsOptimized" : false,
    "enaSupport" : true,
    "hypervisor" : "xen",
    "rootDeviceName" : null,
    "rootDeviceType" : null,
    "securityGroups" : [ {
      "groupName" : "elb_sg",
      "groupId" : "sg-09e4a08f7f110fed8"
    } ],
    "sourceDestCheck" : null,
    "spotInstanceRequestId" : null,
    "sriovNetSupport" : null,
    "virtualizationType" : null
  }, {
    "imageId" : "ami-0a15b1ad20094b9f5",
    "instanceId" : "i-0403ae8bf36bdeffc",
    "instanceType" : "T2_NANO",
    "kernelId" : null,
    "keyName" : null,
    "launchTime" : {
      "nano" : 0,
      "epochSecond" : 1551963819
    },
    "monitoring" : "enabled",
    "availabilityZone" : null,
    "affinity" : null,
    "groupName" : null,
    "partitionNumber" : null,
    "hostId" : null,
    "tenancy" : null,
    "spreadDomain" : null,
    "platform" : null,
    "privateIpAddress" : "10.0.1.25",
    "publicDnsName" : "ec2-3-8-139-27.eu-west-2.compute.amazonaws.com",
    "publicIpAddress" : null,
    "stateTransitionReason" : null,
    "subnetId" : "subnet-0a35bca9d0c2edd15",
    "vpcId" : null,
    "architecture" : "x86_64",
    "ebsOptimized" : false,
    "enaSupport" : true,
    "hypervisor" : "xen",
    "rootDeviceName" : null,
    "rootDeviceType" : null,
    "securityGroups" : [ {
      "groupName" : "bastion-security-group-20190307125944738000000001",
      "groupId" : "sg-0f5b8abdd7fee54fc"
    } ],
    "sourceDestCheck" : null,
    "spotInstanceRequestId" : null,
    "sriovNetSupport" : null,
    "virtualizationType" : null
  } ],
  "keyPair" : [ {
    "keyFingerprint" : "9e:9b:d5:5d:7a:44:6f:c5:6f:ae:9b:58:e8:19:40:a2:f4:19:07:aa",
    "keyName" : "admin-2960"
  }, {
    "keyFingerprint" : "07:ab:1e:83:13:6a:b6:2b:b9:b1:06:03:c6:86:72:c5",
    "keyName" : "threetier"
  } ],
  "region" : [ {
    "endpoint" : "ec2.eu-north-1.amazonaws.com",
    "regionName" : "eu-north-1"
  }, {
    "endpoint" : "ec2.ap-south-1.amazonaws.com",
    "regionName" : "ap-south-1"
  }, {
    "endpoint" : "ec2.eu-west-3.amazonaws.com",
    "regionName" : "eu-west-3"
  }, {
    "endpoint" : "ec2.eu-west-2.amazonaws.com",
    "regionName" : "eu-west-2"
  }, {
    "endpoint" : "ec2.eu-west-1.amazonaws.com",
    "regionName" : "eu-west-1"
  }, {
    "endpoint" : "ec2.ap-northeast-2.amazonaws.com",
    "regionName" : "ap-northeast-2"
  }, {
    "endpoint" : "ec2.ap-northeast-1.amazonaws.com",
    "regionName" : "ap-northeast-1"
  }, {
    "endpoint" : "ec2.sa-east-1.amazonaws.com",
    "regionName" : "sa-east-1"
  }, {
    "endpoint" : "ec2.ca-central-1.amazonaws.com",
    "regionName" : "ca-central-1"
  }, {
    "endpoint" : "ec2.ap-southeast-1.amazonaws.com",
    "regionName" : "ap-southeast-1"
  }, {
    "endpoint" : "ec2.ap-southeast-2.amazonaws.com",
    "regionName" : "ap-southeast-2"
  }, {
    "endpoint" : "ec2.eu-central-1.amazonaws.com",
    "regionName" : "eu-central-1"
  }, {
    "endpoint" : "ec2.us-east-1.amazonaws.com",
    "regionName" : "us-east-1"
  }, {
    "endpoint" : "ec2.us-east-2.amazonaws.com",
    "regionName" : "us-east-2"
  }, {
    "endpoint" : "ec2.us-west-1.amazonaws.com",
    "regionName" : "us-west-1"
  }, {
    "endpoint" : "ec2.us-west-2.amazonaws.com",
    "regionName" : "us-west-2"
  } ],
  "securityGrp" : null
}
```

## Test 3 : Evaluate an object and provide the expected outcome ##

The sample code is available under "test-3" folder of the respository.

Requirement Statement :

```
Fetch the last value in a nested object of type {"x":{"y":"{"z":"a"}"}}
```

Approach :

```
1. Language Used : Java
2. Object Type considered : Map
3. Object created : HashMap (implementation of Java Map interface) . Object Structure : {x={y={z=a}}}
4. Object Structure : <String, Map<String, Map<String, String>>>
5. Input as arguments to Java main(). If no arguments are passed , an ArrayOutOfboundIndexException is thrown
6. As String "" is a valid value in Java, a result will be returned for input like "x" " " "z" "a". Not a good practice and can be imporve by checking for exactly 4 arguments
6. Used Strings as per requirement
8. Wrote Junits covering the following scenarios
  a) Positive : Expected outcome of "a" , if all inputs are correct, Map created is not null, contains Key 
  b) Negative : Expected outcome of "b", but was "a"
  c) Positive : Expect exception if no arguments are passed to main()
  d) Positive : Test for main() using ExpectedSystemExit rule 
```

