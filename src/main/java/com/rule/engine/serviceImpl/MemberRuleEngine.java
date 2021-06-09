package com.rule.engine.serviceImpl;

import org.springframework.stereotype.Service;

import com.rule.engine.service.MemberOperations;

@Service
public class MemberRuleEngine implements MemberOperations {

	@Override
	public boolean activate() {
		// TODO member activate logic implementations
		return true;
	}

	@Override
	public boolean sendEmail() {
		// TODO after member activate/upgrade send email logic implementations
		return true;
	}

	@Override
	public boolean upgrade() {
		// TODO member upgrade logic implementations
		return true;
	}

}
