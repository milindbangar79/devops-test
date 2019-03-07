package com.aws.resources.ec2;

import java.util.ArrayList;
import java.util.List;

import com.aws.resources.domain.AddressObj;
import com.aws.resources.domain.InstanceGroupIdentifier;
import com.aws.resources.domain.InstanceObj;
import com.aws.resources.domain.KeyPairObj;
import com.aws.resources.domain.RegionObj;
import com.aws.resources.domain.SecurityGroupObj;
import com.aws.resources.domain.ZoneObj;

import software.amazon.awssdk.auth.credentials.EnvironmentVariableCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ec2.Ec2Client;
import software.amazon.awssdk.services.ec2.model.Address;
import software.amazon.awssdk.services.ec2.model.AvailabilityZone;
import software.amazon.awssdk.services.ec2.model.DescribeAddressesResponse;
import software.amazon.awssdk.services.ec2.model.DescribeAvailabilityZonesResponse;
import software.amazon.awssdk.services.ec2.model.DescribeInstancesRequest;
import software.amazon.awssdk.services.ec2.model.DescribeInstancesResponse;
import software.amazon.awssdk.services.ec2.model.DescribeKeyPairsResponse;
import software.amazon.awssdk.services.ec2.model.DescribeRegionsResponse;
import software.amazon.awssdk.services.ec2.model.DescribeSecurityGroupsRequest;
import software.amazon.awssdk.services.ec2.model.DescribeSecurityGroupsResponse;
import software.amazon.awssdk.services.ec2.model.GroupIdentifier;
import software.amazon.awssdk.services.ec2.model.Instance;
import software.amazon.awssdk.services.ec2.model.KeyPairInfo;
import software.amazon.awssdk.services.ec2.model.Reservation;
import software.amazon.awssdk.services.ec2.model.SecurityGroup;

public class EC2ClientResourcesClass {

	Ec2Client ec2 = Ec2Client.builder().region(Region.EU_WEST_2)
			.credentialsProvider(EnvironmentVariableCredentialsProvider.create()).build();

	/**
	 * 
	 * @return List<Address> address.publicIp(), address.domain(),
	 *         address.allocationId(), address.networkInterfaceId());
	 */
	public List<AddressObj> getAddress() {

		DescribeAddressesResponse addressResponse;

		addressResponse = ec2.describeAddresses();

		List<AddressObj> addressList = new ArrayList<>();

		for (Address address : addressResponse.addresses()) {

			AddressObj addressMapper = new AddressObj();

			addressMapper.setAllocationId(address.allocationId());
			addressMapper.setAssociationId(address.associationId());
			addressMapper.setDomain(address.domainAsString());
			addressMapper.setInstanceId(address.instanceId());
			addressMapper.setNetworkInterfaceId(address.networkInterfaceId());
			addressMapper.setNetworkInterfaceOwnerId(address.networkInterfaceOwnerId());
			addressMapper.setPrivateIpAddress(address.privateIpAddress());
			addressMapper.setPublicIp(address.publicIp());

			addressList.add(addressMapper);
		}

		return addressList;

	}

	/**
	 * @param groupId
	 * @return List<SecurityGroup> group.groupId(), group.vpcId(),
	 *         group.description()
	 */
	public List<SecurityGroupObj> getSecurityGroup() {

		DescribeSecurityGroupsResponse securityGroupResponse;

		List<String> securityGroupNames = new ArrayList<>();
		securityGroupNames.add("sg-08f9960cb720d253e");
		//securityGroupNames.add("sg_test_web");
		//securityGroupNames.add("elb_sg");
		//securityGroupNames.add("bastion-security-group-20190307094225879300000001");

		DescribeSecurityGroupsRequest request = DescribeSecurityGroupsRequest.builder().groupNames(securityGroupNames)
				.build();

		securityGroupResponse = ec2.describeSecurityGroups(request);

		List<SecurityGroupObj> securityGroupList = new ArrayList<>();

		for (SecurityGroup group : securityGroupResponse.securityGroups()) {

			SecurityGroupObj securityGroupMapper = new SecurityGroupObj();

			securityGroupMapper.setDescription(group.description());
			securityGroupMapper.setGroupId(group.groupId());
			securityGroupMapper.setGroupName(group.groupName());
			securityGroupMapper.setVpcId(group.vpcId());
			securityGroupList.add(securityGroupMapper);
		}
		return securityGroupList;

	}

	/**
	 * 
	 * @return List<Instance> instance.instanceId(), instance.imageId(),
	 *         instance.instanceType(), instance.state().name(),
	 *         instance.monitoring().state()
	 */
	public List<InstanceObj> getInstance() {

		DescribeInstancesResponse instanceResponse;

		boolean isDone = false;

		DescribeInstancesRequest request = DescribeInstancesRequest.builder().build();

		List<InstanceObj> instanceList = new ArrayList<>();

		while (!isDone) {

			instanceResponse = ec2.describeInstances(request);

			for (Reservation reservation : instanceResponse.reservations()) {
				for (Instance instance : reservation.instances()) {

					InstanceObj instanceMapper = new InstanceObj();

					instanceMapper.setInstanceId(instance.instanceId());
					instanceMapper.setArchitecture(instance.architectureAsString());
					instanceMapper.setEbsOptimized(instance.ebsOptimized());
					instanceMapper.setEnaSupport(instance.enaSupport());
					instanceMapper.setHypervisor(instance.hypervisorAsString());
					instanceMapper.setImageId(instance.imageId());
					instanceMapper.setInstanceType(instance.instanceType().name());
					instanceMapper.setKernelId(instance.kernelId());
					instanceMapper.setKeyName(instance.keyName());
					instanceMapper.setMonitoring(instance.monitoring().stateAsString());
					instanceMapper.setLaunchTime(instance.launchTime());
					instanceMapper.setPlatform(instance.platformAsString());
					instanceMapper.setPublicDnsName(instance.publicDnsName());
					instanceMapper.setPlatform(instance.platformAsString());
					instanceMapper.setPrivateIpAddress(instance.privateIpAddress());
					instanceMapper.setSubnetId(instance.subnetId());

					List<InstanceGroupIdentifier> groupIds = new ArrayList<>();

					for (GroupIdentifier group : instance.securityGroups()) {
						InstanceGroupIdentifier groups = new InstanceGroupIdentifier();
						groups.setGroupId(group.groupId());
						groups.setGroupName(group.groupName());
						groupIds.add(groups);
					}

					instanceMapper.setSecurityGroups(groupIds);

					instanceMapper.setPublicDnsName(instance.publicDnsName());

					instanceList.add(instanceMapper);
				}
			}
			if (instanceResponse.nextToken() == null) {
				isDone = true;
			}
		}
		return instanceList;
	}

	/**
	 * 
	 * @return List<KeyPairInfo> keyPair.keyName(), keyPair.keyFingerprint()
	 */
	public List<KeyPairObj> getKeyPair() {

		DescribeKeyPairsResponse keyPairResponse;

		keyPairResponse = ec2.describeKeyPairs();

		List<KeyPairObj> keyPairList = new ArrayList<>();

		for (KeyPairInfo keyPair : keyPairResponse.keyPairs()) {

			KeyPairObj kpMapper = new KeyPairObj();
			kpMapper.setKeyName(keyPair.keyName());
			kpMapper.setKeyFingerprint(keyPair.keyFingerprint());

			keyPairList.add(kpMapper);

		}

		return keyPairList;
	}

	/**
	 * @return List<software.amazon.awssdk.services.ec2.model.Region
	 *         region.regionName(), region.endpoint()
	 */
	public List<RegionObj> getRegion() {

		DescribeRegionsResponse regionResponse;

		regionResponse = ec2.describeRegions();

		List<RegionObj> regionList = new ArrayList<>();

		for (software.amazon.awssdk.services.ec2.model.Region region : regionResponse.regions()) {

			RegionObj regionMapper = new RegionObj();
			regionMapper.setRegionName(region.regionName());
			regionMapper.setEndpoint(region.endpoint());
			regionList.add(regionMapper);

		}

		return regionList;

	}

	/**
	 * 
	 * @return List<AvailabilityZone> zone.zoneName(), zone.state(),
	 *         zone.regionName()
	 */
	public List<ZoneObj> getAvailabilityZone() {

		DescribeAvailabilityZonesResponse zoneResponse;

		zoneResponse = ec2.describeAvailabilityZones();

		List<ZoneObj> zoneList = new ArrayList<>();

		for (AvailabilityZone zone : zoneResponse.availabilityZones()) {

			ZoneObj zoneMapper = new ZoneObj();
			zoneMapper.setRegionName(zone.regionName());
			zoneMapper.setState(zone.stateAsString());
			zoneMapper.setZoneId(zone.zoneId());
			zoneMapper.setZoneName(zone.zoneName());
			zoneList.add(zoneMapper);
		}

		return zoneList;

	}

}
