package com.aws.resources.main;

import java.io.PrintWriter;

import com.aws.resources.domain.EC2OutputDomain;
import com.aws.resources.ec2.EC2ClientResourcesClass;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author milindbangar
 * @since 07/03/2019
 * Class to invoke AWS client to get the Resource Data  for  EC2 Instances
 * The output is generated as JSON string
 */
public class AWSRetreievResourceData {

	public static void main(String[] args) throws AWSResourceCustomException {

		EC2ClientResourcesClass ec2ClientResource;

		EC2OutputDomain output = new EC2OutputDomain();

		ec2ClientResource = new EC2ClientResourcesClass();

		output.setInstance(ec2ClientResource.getInstance());
		output.setSecurityGrp(ec2ClientResource.getSecurityGroup());
		output.setAddress(ec2ClientResource.getAddress());
		output.setRegion(ec2ClientResource.getRegion());
		output.setZone(ec2ClientResource.getAvailabilityZone());
		output.setKeyPair(ec2ClientResource.getKeyPair());

		// Print the Object as JSON String

		ObjectMapper mapper = new ObjectMapper();

		try {
			//Not so efficient, but would work for small code testing in non-production environment
			PrintWriter resourceOutput = new PrintWriter(System.out,true);
			
			String format = "%s\n" ;
			
			resourceOutput.printf(format, mapper.writerWithDefaultPrettyPrinter().writeValueAsString(output));

		} catch (JsonProcessingException e) {
			throw new AWSResourceCustomException(e.getCause());
		}

	}

}
