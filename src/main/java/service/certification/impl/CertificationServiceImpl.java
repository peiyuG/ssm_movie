package service.certification.impl;

import dao.certification.CertificationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.certification.CertificationItem;
import service.certification.CertificationService;

import javax.servlet.http.HttpServletRequest;

/**
 * @author chuyunfei
 * @date: 2018/3/30
 * @description:
 */
@Service
public class CertificationServiceImpl implements CertificationService {

	@Autowired
	private CertificationContext certificationContext;

	@Override
	public boolean deleteCertification(HttpServletRequest request) {
		// todo
		return false;
	}

	@Override
	public boolean checkCertification(String ipKey) {
		// todo
		return false;
	}

	@Override
	public void addCertification(HttpServletRequest request) {
		// todo
	}

	@Override
	public void update(String ipKey) {
		// todo
		System.out.println("111");
	}
}
