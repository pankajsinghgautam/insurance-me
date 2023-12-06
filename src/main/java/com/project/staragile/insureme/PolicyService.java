package com.project.staragile.insureme;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PolicyService {
	
	@Autowired
	PolicyRepository policyRepository;
	
	
	public Policy CreatePolicy() {
		
		Policy policy = generateDummyPolicy();
		
		return policyRepository.save(policy);
		
			
	}
	
	public Policy updatePolicy() {
		
		return null;
	}
	
	public Policy deletePolicy() {
		
		return null;
	}
	
	public Policy searchPolicy() {
		
		return null;
	}
	
	
	public Policy generateDummyPolicy() {
		return new Policy(1, "Shubham", "Individual" , 10000, "10-Sep-2021", "10-Sep-2022");
	}

	public Policy registerPolicy(Policy policy) {
		// TODO Auto-generated method stub
		return policyRepository.save(policy);
	}

	public Policy getPolicyDetails(int policyId) {
		// TODO Auto-generated method stub
		return policyRepository.findById(policyId).get();
	}

	public Policy updatePolicy(int policyId, Policy updatedPolicy) {
		Policy policy = getPolicyDetails(policyId);
		 if (Objects.nonNull(policy) ) {
			 policy.setPolicyHolderName(updatedPolicy.getPolicyHolderName());
			 policyRepository.save(policy);
			 return policy;
		 }
		return null;
	}
	
	public String deleteById(int policyId) {
		  Policy policy = getPolicyDetails(policyId);
		  if (Objects.nonNull(policy) ) {
			  policyRepository.delete(policy);
			  return "Successfully Deleted";
		  }
			return "Deletion Failed";
		}

}
